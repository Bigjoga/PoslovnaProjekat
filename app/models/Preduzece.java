package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Preduzece extends Model {
	
	

	@OneToMany(mappedBy="preduzece")
	public List<PoslovnaGodina> poslovnagodina;
	
	@Column(nullable = false, length=30)
	public String naziv;
	
	@Column(nullable = false, length=30)
	public String adresa;
	
	@Column(nullable = false, length=20)
	public String kontakt;
	
	@Column(nullable = false, length=25)
	public String Sifra;
	
	@OneToMany(mappedBy="preduzece")
	public List<PoslovniPartner>  poslovniPartner;

	public Preduzece(List<PoslovnaGodina> poslovnagodina, String naziv,
			String adresa, String kontakt, String sifra,
			List<PoslovniPartner> poslovniPartner) {
		super();
		this.poslovnagodina = poslovnagodina;
		this.naziv = naziv;
		this.adresa = adresa;
		this.kontakt = kontakt;
		Sifra = sifra;
		this.poslovniPartner = poslovniPartner;
	}
	
	
	
	
	
}
