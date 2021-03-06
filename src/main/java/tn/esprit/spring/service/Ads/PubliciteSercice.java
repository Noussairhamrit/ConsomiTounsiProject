package tn.esprit.spring.service.Ads;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tn.esprit.spring.entity.Ads.Publicite;

public interface PubliciteSercice {
	
	public int ajouterPublicite(Publicite publicite);
	public void deletePublicite(int pubId);
	public List<Publicite> getAllPublicites();
	public void modifierPublicite(Publicite p, int pubId);
	public Publicite AjoutPub(String ProduitJson,MultipartFile file)throws JsonMappingException, JsonProcessingException,IOException;
	//Optional<Publicite> getpubById(Long id);

}
