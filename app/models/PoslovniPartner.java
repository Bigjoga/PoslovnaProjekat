package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class PoslovniPartner extends Model {
	
	@OneToMany(mappedBy="poslovniPartner")
	public List<StavkaIzvoda> stavkaIzvoda;

}
