package tn.esprit.spring.controller.Product;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helpers.ZXingHelper;
import Utils.AppConstants;
import tn.esprit.spring.entity.AppResponse;
import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.service.Product.FileStorageService;
import tn.esprit.spring.service.Product.FileStorageServiceImpl;
import tn.esprit.spring.service.Product.ProduitService;



@RestController
@RequestMapping("/product")
public class RestControlProduit {
	
	@Autowired
	ProduitService produitser;
	
	@Autowired
	FileStorageServiceImpl fileStorageServiceImpl;
	
	@Autowired
	FileStorageService fileStorageService;
	
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	private ServletContext servletContext;
	
	// http://localhost:8081/SpringMVC/servlet/ajouterProd
		//{"id":6,"nom":"jawher", "prix":630L, "Description":"bon produit", "quantite":98L, "poid":1L,"barreCode":61947885L,"img":"allah","prixAchat":780L,"prixVente":897}
	
	@PostMapping("/ajouterProd")
	@ResponseBody
	public Produit ajouterProduit(@RequestBody Produit produit) {
		produitser.ajouterProduit(produit);
		return produit;
	}
	
	
	 // URL : http://localhost:8081/SpringMVC/servlet/getAllProduits
		@GetMapping(value = "/getAllProduits")
	    @ResponseBody
		public List<Produit> getAllProduits() {
			
			return produitser.getAllProduits();
		}
		
		 // URL : http://localhost:8081/SpringMVC/servlet/deleteProduitById/1
	    @DeleteMapping("/deleteProduitById/{idprod}") 
		@ResponseBody 
		public ResponseEntity<String> deleteProduitById(@PathVariable("idprod")int produitId) {
	    	produitser.deleteProduitById(produitId);
	    	return ResponseEntity.ok("Produit Supprimer avec succes");
			
		}
	    
	 // URL : http://localhost:8081/product/getProductBybarCode/1
	    @GetMapping(value = "getProductBybarCode/{code}")
	    @ResponseBody
	    public Long getProductBybarCode(@PathVariable("code")int idProd) {
			return produitser.getProductBybarCode(idProd);
		}
	    
	    
	 // URL : http://localhost:8081/SpringMVC/servlet/chercherNomProduitById/1
	    @GetMapping(value = "chercherNomProduitById/{nom}")
	    @ResponseBody
	    public String chercherNomProduitById(@PathVariable("nom")int produitId) {
			return produitser.chercherNomProduitById(produitId);
		}
	    
	    
	    
	 // Mise a jour quantite  : http://localhost:8081/SpringMVC/servlet/MiseAjourQuantite/7/newquant
		@PutMapping(value = "/MiseAjourQuantite/{id}/{newquant}") 
		@ResponseBody
	    public void mettreAjourQuantiteProduit(@PathVariable("newquant") long quantite,@PathVariable("id") int produitId) {
			produitser.mettreAjourQuantiteProduit(quantite, produitId);
			
		}
		
		// http://localhost:8081/SpringMVC/servlet/affecterProduitASCategorie/4/4
		@PutMapping(value = "/affecterProduitASCategorie/{idprod}/{idScat}") 
		public void affecterProduitASCategorie(@PathVariable("idprod") int produitId, @PathVariable("idScat") long scatId) {
			produitser.affecterProduitASCategorie(produitId, scatId);

		}
		
		// URL : http://localhost:8081/SpringMVC/servlet/calculetNombreProduitJPQL
	    @GetMapping(value = "calculetNombreProduitJPQL")
	    @ResponseBody
		public int calculetNombreProduitJPQL() {
			
			return produitser.calculetNombreProduitJPQL();
		}
	    
	    
	 // http://localhost:8081/SpringMVC/produit/ajoutProduit/1/1
		//{"nom":"taekouando","prix":50,"description":"original ","quantite":80,"poid":10,"barcode":6190000001001,"prixAchat":780,"prixVente":897}
		@PostMapping(value ="/ajoutProduit/{scatid}")
		public Produit AjouterProduit(@PathVariable(value = "scatid") Long scatId,
				@RequestParam(value = "produit", required = true) String ProduitJson,
				@RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) List<MultipartFile> file)
				throws JsonParseException, JsonMappingException, IOException {
			return produitser.AjoutProduit(ProduitJson, scatId, file);
		}
		
		//http://localhost:8081/SpringMVC/servlet/findPBS/1
		@GetMapping("/findPBS/{idSCat}")
		public List<Produit> findProduitBySCategorie(@PathVariable(value = "idSCat") long scatId) {
			return produitser.findProduitBySCategorie(scatId);
		}
//		
//		//http://localhost:8081/SpringMVC/servlet/catProd/1
//		@GetMapping("/catProd/{idCategorie}")
//		public List<Produit> findProduitCategorie(@PathVariable(value = "idCategorie") Long catId) {
//			return produitser.findProduitCategorie(catId);
//		}
		
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
		
		
		
		@RequestMapping(value = "/addProd", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		public AppResponse createProduit(
				@RequestParam(value = "produit", required = true) String empJson,
				@RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file)
				throws JsonParseException, JsonMappingException, IOException {
			String fileName = fileStorageService.storeFile(file);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
					.path(fileName).toUriString();

			Produit produit = objectMapper.readValue(empJson, Produit.class);
			produit.setImg(fileDownloadUri);
			produitser.ajouterProduit(produit);

			return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
		}
		
        
		
		@PutMapping(value = "/manage/updateProduct/{barCode}") 
		@ResponseBody
		public Produit updateProduct(@PathVariable("barCode") Long barCode,@RequestBody Produit product) {
			Produit p= product;
			 p.getBarreCode();
			p.setDescription(p.getDescription());
			p.setNom(p.getNom());
			p.setPrix(p.getPrix());
			//prod.setSouscat(((validCategory(p.getCategory()));
			return produitser.updateProduct(p, barCode);
		}
		
		
		
//		/* ajouter event avec image*/
//		//http://localhost:8081/SpringMVC/servlet/produit/addProd
//		@PostMapping("/addProd")
//		
//		public String addProd(@RequestParam(value = "produit", required = true) String ProduitJson,
//				@RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) List<MultipartFile> file) 
//						throws JsonParseException, JsonMappingException,IOException {
//			Produit e = objectMapper.readValue(ProduitJson, Produit.class);
//
//			for (MultipartFile i : file) {
//				String fileName = fileStorageService.storeFile(i);
//				String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//						.path(AppConstants.DOWNLOAD_PATH).path(fileName).toUriString();
//				
//				e.setImages(fileDownloadUri);
//				produitser.ajouterProduit(e);
//
//			}
//			return "Successful";
//		}
		
//		//http://localhost:8081/SpringMVC/servlet/addP
//		@PostMapping("/addP")
//		//@RequestMapping(value = AppConstants.EMPLOYEE_URI, method = RequestMethod.POST)
//		public AppResponse createEmployee(
//				@RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String empJson,
//				@RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file)
//				throws JsonParseException, JsonMappingException, IOException {
//			String fileName = fileStorageService.storeFile(file);
//			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
//					.path(fileName).toUriString();
//
//			Produit employee = objectMapper.readValue(empJson, Produit.class);
//			employee.setImages(fileDownloadUri);
//			produitser.ajouterProduit(employee);
//
//			return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
//		}
		
		
		@RequestMapping(method = RequestMethod.GET)
		public String index(ModelMap modelMap) {
			modelMap.put("products", produitser.findAll());
			return "product/index";
		}
		
		@PostMapping(value ="/ajoutP")
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
		
		
		public void setServletContext(ServletContext servletContext) {
			this.servletContext = servletContext;
		}
		
		
		

		//http://localhost:8081/product/Categorie/1
		@GetMapping("/Categorie/{idCategorie}")
		public List<Produit> findProdCat(@PathVariable(value = "idCategorie") Long idCategorie) {
			return produitser.findProdCat(idCategorie);
		}
		
		

		
		
		


}
