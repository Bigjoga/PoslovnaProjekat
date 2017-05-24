package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class RacunPoslovnogPartnera  extends Model{

	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	@Column(nullable=false, length = 18, unique=true)
	public String brojRacun;
	
	@Column(nullable=false)
	public boolean aktivan;
	
	@ManyToOne
	public Banka1 banka1;

	public RacunPoslovnogPartnera(PoslovniPartner poslovniPartner,
			String brojRacun, boolean aktivan, Banka1 banka1) {
		super();
		this.poslovniPartner = poslovniPartner;
		this.brojRacun = brojRacun;
		this.aktivan = aktivan;
		this.banka1 = banka1;
	}
}
