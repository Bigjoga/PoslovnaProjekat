package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class ZatvaranjeIzlazneFakture extends Model {

	@Column(nullable = false, length=10)
	public Date datum ;
	
	@ManyToOne
	public IzlaznaFaktura izlaznaFaktura;

	public ZatvaranjeIzlazneFakture(
		    Date datum,
			IzlaznaFaktura izlaznaFaktura) {
		super();
		
		this.datum = datum;
		this.izlaznaFaktura = izlaznaFaktura;
	}
}
