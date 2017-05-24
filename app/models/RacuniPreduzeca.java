package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class RacuniPreduzeca extends Model {

	@Column(unique=true, nullable=false, length=18)
	public String mojracun;
	
	@ManyToOne
	public Banka2 banka2;
	
	@ManyToOne
	public Preduzece preduzece;
	
	@OneToMany(mappedBy="recunipreduzeca")
	public List <DnevnoStanje> dnevnoStanje;

	public RacuniPreduzeca(String mojracun, Banka2 banka2, Preduzece preduzece,
			List<DnevnoStanje> dnevnoStanje) {
		super();
		this.mojracun = mojracun;
		this.banka2 = banka2;
		this.preduzece = preduzece;
		this.dnevnoStanje = dnevnoStanje;
	}
}
