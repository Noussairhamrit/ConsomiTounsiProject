package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Provider;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ProviderRepository;
import tn.esprit.spring.repository.StockRepository;
@Service
public class ProviderServiceImpl implements IProviderSerivce{
	@Autowired 
	ProviderRepository providerRepository;
	
	
	public Long ajouterProvider(Provider prov) {
		providerRepository.save(prov);
		return prov.getUserId();
	}

	
	@Override
	public void deleteProvider(int IdProvider) {
		providerRepository.deleteById(IdProvider);
	}
	
	@Override
	public void UpdateProvider(int IdProvider,String pro_name,String Domain,String email, int gsm) {
		Provider pro = providerRepository.findById(IdProvider).get();
		pro.setNom(pro_name);
		pro.setDomain(Domain);
		pro.setEmail(email);
		pro.setNum_tel(gsm);
		
		providerRepository.save(pro);
	}
	
	
	@Override
	public List<Provider> ShowProvider() {
		return (List<Provider>)providerRepository.findAll();
	}
	
	
	
	
	

	

}
