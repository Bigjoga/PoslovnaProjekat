package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class IzlaznaFaktura  extends Model{
	
	@OneToMany(mappedBy="izlaznaFaktura")
	public List<ZatvaranjeIzlazneFakture> zatvaranjeIzlazneFakture;
	

}
