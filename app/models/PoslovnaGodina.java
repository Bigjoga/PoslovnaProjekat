package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class PoslovnaGodina extends Model {
	
	@ManyToOne
	public Preduzece preduzece;

}
