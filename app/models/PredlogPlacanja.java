package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.sun.org.apache.xpath.internal.operations.Bool;

import play.db.jpa.Model;

@Entity
public class PredlogPlacanja extends Model {

	@OneToMany(mappedBy="predlogPlacanja")
	public List<StaSePlaca> staSePlaca;
	
	@Column(length=10)
	public Date datum;
	
	@Column(length=10)
	public Integer broj;
	
	@Column(length=2)
	public Bool placeno;
	
	@OneToMany(mappedBy="predlogPlacanja")
	public List<NaloziZaPlacanje> naloziZaPlacanje;

	public PredlogPlacanja(List<StaSePlaca> staSePlaca, Date datum,
			Integer broj, Bool placeno, List<NaloziZaPlacanje> naloziZaPlacanje) {
		super();
		this.staSePlaca = staSePlaca;
		this.datum = datum;
		this.broj = broj;
		this.placeno = placeno;
		this.naloziZaPlacanje = naloziZaPlacanje;
	}
}
