package models;

import java.sql.Date;

import javax.persistence.ManyToOne;

import play.db.jpa.Model;

public class ZatvaranjeIzlazneFakture  extends Model{
	
	
	public Date datum;
	
	public Float iznosZatvaranja;
	
	@ManyToOne
	public StavkaIzvoda stavkaIzvoda;
	@ManyToOne
	public IzlaznaFaktura izlaznaFaktura;
	
	public ZatvaranjeIzlazneFakture(Date datum, Float iznosZatvaranja,
			StavkaIzvoda stavkaIzvoda, IzlaznaFaktura izlaznaFaktura) {
		super();
		this.datum = datum;
		this.iznosZatvaranja = iznosZatvaranja;
		this.stavkaIzvoda = stavkaIzvoda;
		this.izlaznaFaktura = izlaznaFaktura;
	}

}
