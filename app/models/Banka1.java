package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Banka1  extends Model{
	
	@Column(length=3, nullable=false, unique=true)
	public Integer sifra;
	
	@Column(length=30, nullable=false)
	public String naziv;
	
	@OneToMany(mappedBy="banka1")
	public List <RacunPoslovnogPartnera> racunPoslovnogPartnera;

	@OneToMany(mappedBy="banka1")
	public List<Racun> racun;

	public Banka1(Integer sifra, String naziv,
			List<RacunPoslovnogPartnera> racunPoslovnogPartnera,
			List<Racun> racun) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.racunPoslovnogPartnera = racunPoslovnogPartnera;
		this.racun = racun;
	}
	
	
	

	//odradjenooooo
	
}
