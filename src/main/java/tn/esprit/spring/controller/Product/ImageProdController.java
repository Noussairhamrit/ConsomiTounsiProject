package tn.esprit.spring.controller.Product;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Product.ImageProduit;
import tn.esprit.spring.service.Product.ImageService;



@Controller(value = "ImageProdController")
@ELBeanName(value = "ImageProdController")
public class ImageProdController {
	@Autowired
	ImageService imgser;
	
	
	private Long id;
	private String image;
	
	
	public ImageService getImgser() {
		return imgser;
	}

	public void setImgser(ImageService imgser) {
		this.imgser = imgser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ImageProduit> findAllImages(int idProduit) {
		return imgser.findAllImages(idProduit);
	}
	
	public ImageProduit getImageProduits(int idProd){
		ImageProduit img=imgser.findAllImages(idProd).get(0);
		return img;
	}
	
	
}
