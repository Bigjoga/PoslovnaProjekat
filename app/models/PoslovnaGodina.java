package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class PoslovnaGodina extends Model {
	
	@ManyToOne
	public Preduzece preduzece;
	
	@OneToMany(mappedBy="poslovnaGodina")
	public List <UlaznaFaktura>  ulaznaFaktura;

	public PoslovnaGodina(Preduzece preduzece, List<UlaznaFaktura> ulaznaFaktura) {
		super();
		this.preduzece = preduzece;
		this.ulaznaFaktura = ulaznaFaktura;
	}
}
