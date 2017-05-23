package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class NaloziZaPlacanje extends Model{

	@ManyToOne
	public PredlogPlacanja predlogPlacanja;

	public NaloziZaPlacanje(PredlogPlacanja predlogPlacanja) {
		super();
		this.predlogPlacanja = predlogPlacanja;
	}
	
	//odradjeno
	
}
