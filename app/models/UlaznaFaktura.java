package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class UlaznaFaktura extends Model {
	
	@OneToMany(mappedBy="ulaznaFaktura")
	public List<ZatvaranjeUlazneFakture>zatvaranjeUlazneFaktude;

	@ManyToOne
	public PoslovnaGodina poslovnaGodina;
	
	@OneToMany(mappedBy="ulaznaFaktura")
	public List<StaSePlaca>  staSePlaca;
	
	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	public Integer broj;
	public Float iznosZaPlacanje;
	public Float preostaliIznos;
	
	public UlaznaFaktura(List<ZatvaranjeUlazneFakture> zatvaranjeUlazneFaktude,
			PoslovnaGodina poslovnaGodina, List<StaSePlaca> staSePlaca,
			PoslovniPartner poslovniPartner, Integer broj,
			Float iznosZaPlacanje, Float preostaliIznos) {
		super();
		this.zatvaranjeUlazneFaktude = zatvaranjeUlazneFaktude;
		this.poslovnaGodina = poslovnaGodina;
		this.staSePlaca = staSePlaca;
		this.poslovniPartner = poslovniPartner;
		this.broj = broj;
		this.iznosZaPlacanje = iznosZaPlacanje;
		this.preostaliIznos = preostaliIznos;
	}
	
	
	//odradjeno
	
	
	
}
