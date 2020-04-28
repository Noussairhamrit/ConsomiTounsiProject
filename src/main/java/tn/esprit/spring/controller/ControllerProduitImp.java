package tn.esprit.spring.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

import Helpers.ZXingHelper;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.SousCategoriesRepository;
import tn.esprit.spring.repository.UserRepsitory;
import tn.esprit.spring.service.ProduitService;

@Controller
public class ControllerProduitImp implements ServletContextAware {
	@Autowired
	ProduitService produitser;
	@Autowired
	SousCategoriesRepository sousCatRep;
	@Autowired
	UserRepsitory userRep;
	
	private ServletContext servletContext;

	
	public Produit ajouterProduit(@RequestBody Produit produit) {
		produitser.ajouterProduit(produit);
		return produit;
	}
	
	public List<Produit> getAllProduits() {
		
		return produitser.getAllProduits();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("products", produitser.findAll());
		return "product/index";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("product") Produit product, @RequestParam(value = "file") MultipartFile file,
			ModelMap modelMap) {
		String fileName = saveImage(file);
		product.setImg(fileName);
		modelMap.put("product", product);
		return "product/success";
	}
	
	
	private String saveImage(MultipartFile multipartFile) {
		try {
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(servletContext.getRealPath("/uploads/images/" + multipartFile.getOriginalFilename()));
			Files.write(path, bytes);
			return multipartFile.getOriginalFilename();
		} catch (IOException e) {
			return null;
		}
	}
	
	
	@RequestMapping(value = "qrcode/{id}", method = RequestMethod.GET)
	public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getQRCodeImage(id, 200, 200));
		outputStream.flush();
		outputStream.close();
	}
	
	@RequestMapping(value = "barcode/{id}", method = RequestMethod.GET)
	public void barcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getBarCodeImage(id, 200, 200));
		outputStream.flush();
		outputStream.close();
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
