package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class DnevnoStanje extends Model {
	
	@ManyToOne
	public RacuniPreduzeca recunipreduzeca;

}
