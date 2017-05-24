package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Preduzece extends Model {
	
	@OneToMany(mappedBy="preduzece")
	public List<RacuniPreduzeca>  racuniPreduzeca;

	@OneToMany(mappedBy="preduzece")
	public List<PoslovnaGodina> poslovnagodina;
	
	@Column(nullable = false, length=30)
	public String naziv;
	
	@Column(nullable = false, length=30)
	public String adresa;
	
	@Column(nullable = false, length=20)
	public String kontakt;
	
	public Preduzece(List<RacuniPreduzeca> racuniPreduzeca,
			List<PoslovnaGodina> poslovnagodina,
			String naziv, String adresa, String kontakt) 
	{
		super();
		this.racuniPreduzeca = racuniPreduzeca;
		this.poslovnagodina = poslovnagodina;
		this.naziv = naziv;
		this.adresa = adresa;
		this.kontakt = kontakt;
	}
}
