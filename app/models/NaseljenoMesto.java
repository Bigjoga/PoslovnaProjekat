package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class NaseljenoMesto extends Model{
	
	
	@Column(nullable = false, length =3 , unique=true)
	public String oznaka;
	@Column(nullable = false, length = 40)
	public String naziv;
	@Column(nullable = false, length = 5)
	public String postanskiBroj;
	
	@ManyToOne
	public Drzava drzava;
	
	@OneToMany(mappedBy= "naseljenoMesto")
	public List<Banka1> banka1;

	public NaseljenoMesto(String oznaka, String naziv, String postanskiBroj,
			Drzava drzava, List<Banka1> banka1) {
		super();
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.postanskiBroj = postanskiBroj;
		this.drzava = drzava;
		this.banka1 = banka1;
	}
}
