package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class StavkaIzvoda extends Model{
	
	@OneToMany(mappedBy="stavkaIzvoda")
	public List<ZatvaranjeUlazneFakture> zatvaranjeUlazneFakture;
	

}
