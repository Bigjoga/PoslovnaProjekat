package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Banka1  extends Model{
	
	@Column(length=6, nullable=false, unique=true)
	public Number sifra;
	
	@Column(length=30)
	public String naziv;
	
	@OneToMany(mappedBy="banka1")
	public List <RacunPoslovnogPartnera> racunPoslovnogPartnera;

	public Banka1(Number sifra, String naziv,
			List<RacunPoslovnogPartnera> racunPoslovnogPartnera) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.racunPoslovnogPartnera = racunPoslovnogPartnera;
	}
	

	//odradjeno
	
}
