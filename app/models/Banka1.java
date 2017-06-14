package models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Banka1 extends Model{
	
	@Column(length=3, nullable=false, unique=true)
	public Integer sifra;
	
	@Column(length=30, nullable=false)
	public String naziv;
	
	@OneToMany(mappedBy="banka1")
	public List <RacunPoslovnogPartnera> racunPoslovnogPartnera;

	@OneToMany(mappedBy="banka1")
	public Collection<Racun> racuni;
	
	@ManyToOne
	public NaseljenoMesto naseljenoMesto;

	public Banka1(Integer sifra, String naziv,
			List<RacunPoslovnogPartnera> racunPoslovnogPartnera,
			Collection<Racun> racuni, NaseljenoMesto naseljenoMesto){//, List<NaseljenoMesto> naseljenoMesto) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.racunPoslovnogPartnera = racunPoslovnogPartnera;
		this.racuni = racuni;
		this.naseljenoMesto = naseljenoMesto;
	}
}
