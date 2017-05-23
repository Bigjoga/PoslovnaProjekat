package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class IzlaznaFaktura  extends Model{
	
	@OneToMany(mappedBy="izlaznaFaktura")
	public List<ZatvaranjeIzlazneFakture> zatvaranjeIzlazneFakture;

	@ManyToOne
	public PoslovniPartner poslovniPartner;

	public Integer broj;
	public Float iznosZaPlacanje;
	public Float preostaliIznos;
	public IzlaznaFaktura(
			List<ZatvaranjeIzlazneFakture> zatvaranjeIzlazneFakture,
			PoslovniPartner poslovniPartner, Integer broj,
			Float iznosZaPlacanje, Float preostaliIznos) {
		super();
		this.zatvaranjeIzlazneFakture = zatvaranjeIzlazneFakture;
		this.poslovniPartner = poslovniPartner;
		this.broj = broj;
		this.iznosZaPlacanje = iznosZaPlacanje;
		this.preostaliIznos = preostaliIznos;
	}
	
	//odradjeno
	
	
}
