package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Preduzece extends Model {
	
	@Column(nullable = false, length=30)
	public String naziv;
	
	@Column(nullable = false, length=30)
	public String adresa;
	
	@Column(nullable = false, length=20)
	public String kontakt;
	
	@Column(nullable = false, length=25 ,unique=true)
	public String sifra;
	
	@OneToMany(mappedBy="preduzece")
	public List<PoslovniPartner>  poslovniPartner;
	
	@OneToMany(mappedBy="preduzece")
	public List<PoslovnaGodina> poslovnaGodina;

	public Preduzece(List<PoslovnaGodina> poslovnaGodina, String naziv,
			String adresa, String kontakt, String sifra,
			List<PoslovniPartner> poslovniPartner) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.kontakt = kontakt;
		this.sifra = sifra;
		this.poslovniPartner = poslovniPartner;
		this.poslovnaGodina = poslovnaGodina;
	}
	
	
	
	
	
}
