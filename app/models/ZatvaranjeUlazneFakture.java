package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

import com.mysql.fabric.xmlrpc.base.Data;

public class ZatvaranjeUlazneFakture  extends Model{
	
	@Column()
	public Date datum;
	
	@Column()
	public Float iznosZatvaranja;
	
	
	public ZatvaranjeUlazneFakture(Date datum, Float iznosZatvaranja,
			StavkaIzvoda stavkaIyvoda, UlaznaFaktura ulaznaFaktura) {
		super();
		this.datum = datum;
		this.iznosZatvaranja = iznosZatvaranja;
		this.stavkaIyvoda = stavkaIyvoda;
		this.ulaznaFaktura = ulaznaFaktura;
	}
	@ManyToOne
	public StavkaIzvoda stavkaIyvoda;
	@ManyToOne
	public  UlaznaFaktura ulaznaFaktura;

}
