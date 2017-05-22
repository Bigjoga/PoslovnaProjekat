package models;

import java.util.ArrayList;

import javax.persistence.OneToMany;

import org.dom4j.rule.Mode;

import play.db.jpa.Model;

public class Preduzece extends Model{
	
	@OneToMany(mappedBy="preduzece")
	public ArrayList<PoslovnaGodina>  poslovnaGodina;
	
	@OneToMany(mappedBy="preduzece")
	public ArrayList<RacuniPreduzeca>  racuniPreduzeca;

	
	public Preduzece(ArrayList<PoslovnaGodina> poslovnaGodina,
			ArrayList<RacuniPreduzeca> racuniPreduzeca) {
		super();
		this.poslovnaGodina = poslovnaGodina;
		this.racuniPreduzeca = racuniPreduzeca;
	}

	
}
