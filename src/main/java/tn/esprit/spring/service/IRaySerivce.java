package tn.esprit.spring.service;

import tn.esprit.spring.entity.Ray;

public interface IRaySerivce {
	
	public int ajouterRay(Ray ray);
	public void deleteRay(int RayId);
	public void UpdateRay(int RayId,String RayName, String RayType, String ArranType, int RayCapacity);
	


}
