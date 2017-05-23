package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class RacunPoslovnogPartnera  extends Model{

	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	@Column(length=18, unique=true,nullable=false)
	public String racun;
	public boolean aktivan;
	
	@ManyToOne
	public Banka1 banka1;

	public RacunPoslovnogPartnera(PoslovniPartner poslovniPartner,
			String racun, boolean aktivan, Banka1 banka1) {
		super();
		this.poslovniPartner = poslovniPartner;
		this.racun = racun;
		this.aktivan = aktivan;
		this.banka1 = banka1;
	}
	
	//odradjeno
}
