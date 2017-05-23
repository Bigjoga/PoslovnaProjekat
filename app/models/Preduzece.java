package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Preduzece extends Model {
	
	@OneToMany(mappedBy="preduzece")
	public List<RacuniPreduzeca>  racuniPreduzeca;

	@OneToMany(mappedBy="preduzece")
	public List<PoslovnaGodina> poslovnagodina;

	public Preduzece(List<RacuniPreduzeca> racuniPreduzeca,
			List<PoslovnaGodina> poslovnagodina) {
		super();
		this.racuniPreduzeca = racuniPreduzeca;
		this.poslovnagodina = poslovnagodina;
	}

	
	
	//odradjeno
	
}
