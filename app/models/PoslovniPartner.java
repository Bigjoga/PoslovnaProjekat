package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class PoslovniPartner extends Model {
	
	@OneToMany(mappedBy="poslovniPartner")
	public List<StavkaIzvoda> stavkaIzvoda;
	
	@OneToMany(mappedBy="poslovniPartner")
	public List<UlaznaFaktura>  ulaznaFaktura;

	@OneToMany(mappedBy="poslovniPartner")
	public List<RacunPoslovnogPartnera> racunPoslovnogPartnera;
	
	@OneToMany(mappedBy="poslovniPartner")
	public List<IzlaznaFaktura> izlaznaFaktura;
	
	@ManyToOne
	public Preduzece preduzece;

	public PoslovniPartner(List<StavkaIzvoda> stavkaIzvoda,
			List<UlaznaFaktura> ulaznaFaktura,
			List<RacunPoslovnogPartnera> racunPoslovnogPartnera,
			List<IzlaznaFaktura> izlaznaFaktura) {
		super();
		this.stavkaIzvoda = stavkaIzvoda;
		this.ulaznaFaktura = ulaznaFaktura;
		this.racunPoslovnogPartnera = racunPoslovnogPartnera;
		this.izlaznaFaktura = izlaznaFaktura;
	}
}
