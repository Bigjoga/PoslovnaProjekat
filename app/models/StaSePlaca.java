package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class StaSePlaca extends Model {
	
	@ManyToOne
	public UlaznaFaktura ulaznaFaktura;

	@Column(nullable = false, length=17)
	public Float iznosZaPlacanje;
	
	@Column(nullable = false, length=18)
	public String saKogRacuna;
	
	@ManyToOne
	public PredlogPlacanja predlogPlacanja;

	public StaSePlaca(UlaznaFaktura ulaznaFaktura, Float iznosZaPlacanje,
			String saKogRacuna, PredlogPlacanja predlogPlacanja) {
		super();
		this.ulaznaFaktura = ulaznaFaktura;
		this.iznosZaPlacanje = iznosZaPlacanje;
		this.saKogRacuna = saKogRacuna;
		this.predlogPlacanja = predlogPlacanja;
	}
}
