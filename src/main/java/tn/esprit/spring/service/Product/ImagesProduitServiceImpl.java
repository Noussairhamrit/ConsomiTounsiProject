package tn.esprit.spring.service.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product.ImageProduit;
import tn.esprit.spring.repository.Product.ImageProduitRepository;

@Service
public class ImagesProduitServiceImpl implements ImageService {

	@Autowired
	ImageProduitRepository imagerep;
	
	public ImageProduit save(ImageProduit image) {
		
		return imagerep.save(image);
	}

	
	public ImageProduit findImageProd(int idProd) {
		return imagerep.findImageProd(idProd);
	}


	
	public List<ImageProduit> findAllImages(int idProduit) {
		return imagerep.findAllImages(idProduit);
	}

}
