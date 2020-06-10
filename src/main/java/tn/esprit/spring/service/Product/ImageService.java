package tn.esprit.spring.service.Product;

import java.util.List;

import tn.esprit.spring.entity.Product.ImageProduit;

public interface ImageService {
	
	public ImageProduit save(ImageProduit image);
	public ImageProduit findImageProd(int idProd);
	public List<ImageProduit> findAllImages(int idProduit);
}
