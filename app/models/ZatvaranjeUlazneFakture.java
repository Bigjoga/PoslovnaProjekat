package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class ZatvaranjeUlazneFakture extends Model {

	@Column(nullable = false, length=10)
	public Date datum;

	@ManyToOne
	public UlaznaFaktura ulaznaFaktura;

	public ZatvaranjeUlazneFakture(
			Date datum,
			UlaznaFaktura ulaznaFaktura) {
		super();
		this.datum = datum;
		this.ulaznaFaktura = ulaznaFaktura;
	}
}
