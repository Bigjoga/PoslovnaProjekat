package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class StaSePlaca extends Model {
	
	@ManyToOne
	public UlaznaFaktura ulaznaFaktura;

	public Float iznos;
	
	@Column(length=18)
	public String saKogRacuna;
	
	@ManyToOne
	public PredlogPlacanja predlogPlacanja;

	public StaSePlaca(UlaznaFaktura ulaznaFaktura, Float iznos,
			String saKogRacuna, PredlogPlacanja predlogPlacanja) {
		super();
		this.ulaznaFaktura = ulaznaFaktura;
		this.iznos = iznos;
		this.saKogRacuna = saKogRacuna;
		this.predlogPlacanja = predlogPlacanja;
	}
	
	//odradjeno
	
}
