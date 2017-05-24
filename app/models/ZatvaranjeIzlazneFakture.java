package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class ZatvaranjeIzlazneFakture extends Model {

	@ManyToOne
	public StavkaIzvoda stavkaIzvoda;
	
	//@Column(nullable = false, length=10, unique=true)
	//public String idIzlazneFakture;
	
	@Column(nullable = false, length=10)
	public Date datum ;
	
	@Column(nullable = false, length=17)
	public Float iznos;
	
	@ManyToOne
	public IzlaznaFaktura izlaznaFaktura;

	public ZatvaranjeIzlazneFakture(StavkaIzvoda stavkaIzvoda, 
			String idIzlazneFakture, Date datum,
			Float iznos, IzlaznaFaktura izlaznaFaktura) {
		super();
		this.stavkaIzvoda = stavkaIzvoda;
		//this.idIzlazneFakture = idIzlazneFakture;
		this.datum = datum;
		this.iznos = iznos;
		this.izlaznaFaktura = izlaznaFaktura;
	}
}
