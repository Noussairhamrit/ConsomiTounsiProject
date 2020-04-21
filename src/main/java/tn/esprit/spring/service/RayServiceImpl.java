package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Ray;
import tn.esprit.spring.repository.RayRepository;
@Service
public class RayServiceImpl implements IRaySerivce{
	@Autowired 
	RayRepository rayRepository;
	
	
	public int ajouterRay(Ray ray) {
		rayRepository.save(ray);
		return ray.getRayId();
	}

	
	@Override
	public void deleteRay(int RayId) {
		rayRepository.deleteById(RayId);
	}
	
	@Override
	public void UpdateRay(int RayId,String RayName, String RayType, String ArranType, int RayCapacity) {
		Ray ray = rayRepository.findById(RayId).get();
		ray.setRayName(RayName);
		ray.setRayType(RayType);
		ray.setArranType(ArranType);
		ray.setRayCapacity(RayCapacity);

	}

	

}
