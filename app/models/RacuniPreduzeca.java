package models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

public class RacuniPreduzeca  extends Model{
	
	@Column(nullable = false, length=18, unique=true)
	public String mojRacun;
	
	
	@ManyToOne
	public Drzava drzava;
	
	@OneToMany(mappedBy="racuniPreduyeca")
	public ArrayList<DnevnoStanje> dnevnoStanje;
	
	@ManyToOne
	public Preduzece preduzece;

	public RacuniPreduzeca(String mojRacun, Drzava drzava,
			ArrayList<DnevnoStanje> dnevnoStanje, Preduzece preduzece) {
		super();
		this.mojRacun = mojRacun;
		this.drzava = drzava;
		this.dnevnoStanje = dnevnoStanje;
		this.preduzece = preduzece;
	}

	


	
	

}
