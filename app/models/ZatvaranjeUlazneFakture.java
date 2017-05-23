package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class ZatvaranjeUlazneFakture extends Model {

	public Date datum;
	public Float iznosZatvaranja;
	
	@ManyToOne
	public StavkaIzvoda stavkaIzvoda;
	
	@ManyToOne
	public UlaznaFaktura ulaznaFaktura;

	public ZatvaranjeUlazneFakture(Date datum, Float iznosZatvaranja,
			StavkaIzvoda stavkaIzvoda, UlaznaFaktura ulaznaFaktura) {
		super();
		this.datum = datum;
		this.iznosZatvaranja = iznosZatvaranja;
		this.stavkaIzvoda = stavkaIzvoda;
		this.ulaznaFaktura = ulaznaFaktura;
	}
	
	//odradjeno
	
}
