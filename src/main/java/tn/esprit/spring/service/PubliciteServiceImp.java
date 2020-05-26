package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.AppConstants;
import tn.esprit.spring.entity.Publicite;

import tn.esprit.spring.repository.PubliciteRepository;
@Service 
public class PubliciteServiceImp implements PubliciteSercice {

	
	@Autowired
	PubliciteRepository publiciteRep;
	
	@Autowired
	FileStorageServiceImpl fileStorageServiceImpl;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	public int ajouterPublicite(Publicite publicite) {
		publiciteRep.save(publicite);
		// TODO Auto-generated method stub
		return publicite.getId();
		
	}

	
	public void deletePublicite(int pubId) {
		Publicite publicite = publiciteRep.findById(pubId).get();
		publiciteRep.delete(publicite);
		
	}


	
	public List<Publicite> getAllPublicites() {
		return (List<Publicite>) publiciteRep.findAll();
	}


	public void modifierPublicite(Publicite p, int pubId) {
		Publicite publicite = publiciteRep.findById(pubId).get();
		
		publicite.setCost(p.getCost());
		publicite.setDateEnd(p.getDateEnd());
		publicite.setDateStart(p.getDateStart());
		
		publicite.setName(p.getName());
//		publicite.setTarget(p.getTarget());
//		
//		publicite.setView(p.getView());
		
		publiciteRep.save(publicite);
		
	}


	
	public Publicite AjoutPub(String ProduitJson, MultipartFile file)
			throws JsonMappingException, JsonProcessingException, IOException {
		Publicite pub = objectMapper.readValue(ProduitJson, Publicite.class);
		String fileName = fileStorageServiceImpl.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		.path(AppConstants.DOWNLOAD_PATH).path(fileName).toUriString();
		
		int length =fileName.length();
		String typefile=fileName.substring(length-3,length);
		if (typefile.equals("png")||typefile.equals("peg")||typefile.equals("jpg"))
		{
			pub.setImage(fileDownloadUri);
		}
		else
		{
			pub.setVedio(fileDownloadUri);
		}
			
		return publiciteRep.save(pub);

	}



//	public Optional<Publicite> getpubById(Long id) {
//		return publiciteRep.findById(id);
//	}


	
	


	
	
	
	
}
