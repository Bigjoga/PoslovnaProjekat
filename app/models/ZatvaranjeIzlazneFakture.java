package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class ZatvaranjeIzlazneFakture extends Model {

	@ManyToOne
	public StavkaIzvoda stavkaIzvoda;
	
	public Date datum ;
	public Float iznosZatvaranja;
	
	@ManyToOne
	public IzlaznaFaktura izlaznaFaktura;

	public ZatvaranjeIzlazneFakture(StavkaIzvoda stavkaIzvoda, Date datum,
			Float iznosZatvaranja, IzlaznaFaktura izlaznaFaktura) {
		super();
		this.stavkaIzvoda = stavkaIzvoda;
		this.datum = datum;
		this.iznosZatvaranja = iznosZatvaranja;
		this.izlaznaFaktura = izlaznaFaktura;
	}
	
	//odradjeno
	
}
