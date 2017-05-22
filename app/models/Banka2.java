package models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import antlr.collections.List;

@Entity
public class Banka2 extends Model {
	
	@Column(nullable = false, length=3, unique=true)
	public int sifra;
	@Column(nullable = true, length=30)
	public String naziv;
	
	@OneToMany(mappedBy= "banka2")
	public ArrayList<RacuniPreduzeca> racuniPreduzeca;

	public Banka2(int sifra, String naziv,
			ArrayList<RacuniPreduzeca> racuniPreduzeca) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.racuniPreduzeca = racuniPreduzeca;
	}

	
	
	
	
}
