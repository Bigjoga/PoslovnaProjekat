package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class ZatvaranjeUlazneFakture extends Model {

	//@Column(nullable = false, length=10, unique=true)
	//public String idUlazneFakture;
	
	@Column(nullable = false, length=10)
	public Date datum;
	
	@Column(nullable = false, length=17)
	public Float iznos;
	
	@ManyToOne
	public StavkaIzvoda stavkaIzvoda;
	
	@ManyToOne
	public UlaznaFaktura ulaznaFaktura;

	public ZatvaranjeUlazneFakture(Date datum, Float iznos,
			StavkaIzvoda stavkaIzvoda, UlaznaFaktura ulaznaFaktura) {
		super();
		this.datum = datum;
		this.iznos = iznos;
		this.stavkaIzvoda = stavkaIzvoda;
		this.ulaznaFaktura = ulaznaFaktura;
	}
}
