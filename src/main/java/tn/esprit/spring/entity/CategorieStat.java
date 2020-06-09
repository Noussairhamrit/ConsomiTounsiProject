package tn.esprit.spring.entity;

public class CategorieStat {
	private Long n;
	private String nomCategorie;
	public CategorieStat() {
		super();
	}
	public CategorieStat(Long n, String nomCategorie) {
		super();
		this.n = n;
		this.nomCategorie = nomCategorie;
	}
	public Long getN() {
		return n;
	}
	public void setN(Long n) {
		this.n = n;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	
}
