package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

import play.db.jpa.Model;

@Entity
public class Banka2 extends Model {
	
	@Column(unique=true, length=3, nullable=false)
	public Number sifra;
	
	@Column(length=30)
	public String naziv;
	
	@OneToMany(mappedBy="banka2")
	public List<RacuniPreduzeca> racunipreduyeca;

	public Banka2(Number sifra, String naziv,
			List<RacuniPreduzeca> racunipreduyeca) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.racunipreduyeca = racunipreduyeca;
	}
	
	//odradjena
	

}
