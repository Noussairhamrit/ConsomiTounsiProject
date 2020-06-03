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
	
	
	public int ajouterProvider(Provider prov) {
		providerRepository.save(prov);
		return prov.getIdProvider();
	}

	
	@Override
	public void deleteProvider(int IdProvider) {
		providerRepository.deleteById(IdProvider);
	}
	
	@Override
	public void UpdateProvider(int IdProvider,String pro_name,String Domain,String email, int gsm) {
		Provider pro = providerRepository.findById(IdProvider).get();
		pro.setPro_name(pro_name);
		pro.setDomain(Domain);
		pro.setEmail(email);
		pro.setGsm(gsm);
		
		providerRepository.save(pro);
	}
	
	
	@Override
	public List<Provider> ShowProvider() {
		return (List<Provider>)providerRepository.findAll();
	}
	
	
	
	
	

	

}
