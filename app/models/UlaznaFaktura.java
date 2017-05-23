package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class UlaznaFaktura extends Model {
	
	@OneToMany(mappedBy="ulaznaFaktura")
	public List<ZatvaranjeUlazneFakture>zatvaranjeUlazneFaktude;

}
