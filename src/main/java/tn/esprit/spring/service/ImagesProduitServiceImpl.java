package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.ImageProduit;
import tn.esprit.spring.repository.ImageProduitRepository;

@Service
public class ImagesProduitServiceImpl implements ImageService {

	@Autowired
	ImageProduitRepository imagerep;
	
	public ImageProduit save(ImageProduit image) {
		
		return imagerep.save(image);
	}

}
