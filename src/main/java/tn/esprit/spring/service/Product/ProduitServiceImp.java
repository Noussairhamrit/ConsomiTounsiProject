package tn.esprit.spring.service.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.repository.UserRepsitory;
import tn.esprit.spring.repository.Product.ProduitRepository;
import tn.esprit.spring.repository.Product.SousCategoriesRepository;
import tn.esprit.spring.repository.Product.StoreManagerRepository;
import Utils.AppConstants;
import tn.esprit.spring.controller.Product.JSFSousCategorie;
import tn.esprit.spring.entity.Product.ImageProduit;
import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.entity.Product.SousCategories;
import tn.esprit.spring.entity.Product.StoreManger;

@Service
public class ProduitServiceImp implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	SousCategoriesRepository sousCatRep;
	@Autowired
	UserRepsitory userRep;
	@Autowired
	StoreManagerRepository gerantRep;
	
	@Autowired
	FileStorageServiceImpl fileStorageServiceImpl;
	@Autowired
	JSFSousCategorie controllersouscat;
	
	@Autowired
	ImageService imageser;
	
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	ModelMap modelmap = new ModelMap();
	
	private ServletContext servletContext;
	
	private Produit product = new Produit();
	private List<Produit> products;
	
	public Produit findOne(int id) {
		return produitRepository.getOne(id);
	}

	
	public int ajouterProduit(Produit produit) {
		produitRepository.save(produit);
		// TODO Auto-generated method stub
		return produit.getId();
	}
	public void deleteProduitById(int produitId)

	{
		Produit produit = produitRepository.findById(produitId).get();
		produitRepository.delete(produit);
//		if (produitRepository.existsById(produitId)) {
//	
//			produitRepository.delete(produitRepository.getOne(produitId));
//	
//			return true;
//		}
//		else {
//			throw new IllegalArgumentException("Invalid Bar Code, Product do not exist");
//		}	
	}
	
	public List<Produit> getAllProduits() {
		return (List<Produit>) produitRepository.findAll();
}
	
	public String chercherNomProduitById(int produitId) {
		// TODO Auto-generated method stub
		Produit produitManagedEntity = produitRepository.findById(produitId).get();
		return produitManagedEntity.getNom();
	}
	public void mettreAjourQuantiteProduit(long quantite, int produitId) {
		Produit produit = produitRepository.findById(produitId).get();
		produit.setQuantite(quantite);
		produitRepository.save(produit);

	}
	
	public void affecterProduitASCategorie(int produitId, long scatId) {
		Produit produit = produitRepository.findById(produitId).get();
		SousCategories Scat = sousCatRep.findById(scatId).get();
		produit.setSouscat(Scat);
		produitRepository.save(produit);
		
	}


	public void GerantAddProduit(long userId, int produitId) {
//		Produit produit = produitRepository.findById(produitId).get();
//		StoreManger user = userRep.findById(userId).get();
//		produit.setGerant(user);
//		produitRepository.save(produit);
		
	}
	
	public int calculetNombreProduitJPQL() {
		return produitRepository.countemp();
	}
	
	public Produit AjoutProduit(String ProduitJson, long scatId, List<MultipartFile> file)
			throws JsonMappingException, JsonProcessingException, IOException { 
		Produit prod= objectMapper.readValue(ProduitJson, Produit.class);
		SousCategories Scat = sousCatRep.findById(scatId).get();  
		//StoreManger gerant = gerantRep.getOne(iduser);
//		if (!prod.BarcodeIsvalid(prod.getBarreCode())) {
//			return null;
//		}
		//prod.setGerant(gerant);
		prod.setSouscat(Scat);
	
		produitRepository.save(prod);
		for (MultipartFile i : file) {
			String fileName = fileStorageServiceImpl.storeFile(i);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path(AppConstants.DOWNLOAD_PATH).path(fileName).toUriString();
			ImageProduit image=new ImageProduit();
			image.setImage(fileDownloadUri);
			image.setIdproduit(prod);
			imageser.save(image);

		}
				
		return prod;
	}
	
	public String findProdimg(int idProd){
		return produitRepository.findProdimg(idProd);
	}

	
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}


	
	public List<Produit> findProduitBySCategorie(long scatId) {
		return produitRepository.findProduitBySCategorie(scatId);
	}

	public Iterable<Produit> findAll() {
		return produitRepository.findAll();
	}



	public Produit updateProduct(Produit product, Long barCode) {
		Produit p=product;
		p=produitRepository.save(product);
		return 	p;
	}


	
	public Produit getOne(int id) {
		return produitRepository.getOne(id);
	}


	
	public Long getProductBybarCode(int idprod) {
		Produit produitManagedEntity = produitRepository.findById(idprod).get();
		return produitManagedEntity.getBarreCode();
	}


	
	public boolean existsById(int id) {
		return produitRepository.existsById(id);
	}


	
	public String delete(int id) {
		Produit p =produitRepository.findById(id).get();
		produitRepository.delete(p);
		return "/product-list.xhtml?faces-redirect=true";
	}


	
	public String save() {
		produitRepository.save(product);
		product = new Produit();
		return "/product-list.xhtml?faces-redirect=true";
	}


	
	public void loadData() {
		products = (List<Produit>) produitRepository.findAll();
		
	}



	public List<Produit> getProducts() {
		return products;
	}


	
	public void addProdImage(Produit p, UploadedFiles files) {
	//	SousCategories Scat = sousCatRep.findSousCategorieByName(controllersouscat.getSnom());  
		//SsCategorie ssc = sousSousCategorieRepository.findSsCategorieByName(controllerSousSousCategorie.getNomSsCategorie());
		//p.setSouscat(Scat);;
		produitRepository.save(p);
		
		for (UploadedFile f : files.getFiles()) {
         	String newFileName = fileStorageServiceImpl.UploadImages(f);
         	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH).path(newFileName).toUriString();
			ImageProduit image = new ImageProduit();
			image.setImage(fileDownloadUri);
			image.setIdproduit(p);
			imageser.save(image);
		}
		
	}


	
	public List<Produit> findProdCat(Long idCategorie) {
		return produitRepository.findProdCat(idCategorie);
	}


	public void addProduitWithImage(Produit p, UploadedFiles files) {
		SousCategories Scat = sousCatRep.findSousCategorieByName(controllersouscat.getNomSCategorie());
		p.setSouscat(Scat);
		produitRepository.save(p);
		for (UploadedFile f : files.getFiles()) {
         	String newFileName = fileStorageServiceImpl.UploadImages(f);
         	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH).path(newFileName).toUriString();
			ImageProduit image = new ImageProduit();
			image.setImage(fileDownloadUri);
			image.setIdproduit(p);
			imageser.save(image);
		}
	}


	
	public Produit updateProd(Produit user) {
       return produitRepository.save(user);
		
	
	}

	
	

	
	


	
	
	
}
