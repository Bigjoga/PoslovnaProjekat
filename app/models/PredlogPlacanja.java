package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class PredlogPlacanja extends Model {

	@OneToMany(mappedBy="predlogPlacanja")
	public List<StaSePlaca> staSePlaca;
	
	public Date datum;
	public Integer broj;
	public String status;
	
	@OneToMany(mappedBy="predlogPlacanja")
	public List<NaloziZaPlacanje> naloziZaPlacanje;

	public PredlogPlacanja(List<StaSePlaca> staSePlaca, Date datum,
			Integer broj, String status, List<NaloziZaPlacanje> naloziZaPlacanje) {
		super();
		this.staSePlaca = staSePlaca;
		this.datum = datum;
		this.broj = broj;
		this.status = status;
		this.naloziZaPlacanje = naloziZaPlacanje;
	}
	
	//odradjeno
}
