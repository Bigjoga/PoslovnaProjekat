package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class StavkaIzvoda extends Model{
	
	@OneToMany(mappedBy="stavkaIzvoda")
	public List<ZatvaranjeUlazneFakture> zatvaranjeUlazneFakture;
	
	@ManyToOne
	public DnevnoStanje DnevnoStanje;
	
	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	@OneToMany(mappedBy="stavkaIzvoda")
	public List<ZatvaranjeIzlazneFakture> zatvaranjeIzlazneFakture;
	
	@Column(nullable = false, length=17, unique=true)
	public Float iznos;
	
	@Column(nullable = false, length=17)
	public Float preostaliIznos;
	
	
	public StavkaIzvoda(List<ZatvaranjeUlazneFakture> zatvaranjeUlazneFakture,
			models.DnevnoStanje dnevnoStanje, PoslovniPartner poslovniPartner,
			List<ZatvaranjeIzlazneFakture> zatvaranjeIzlazneFakture,
			Float iznos, Float preostaliIznos) {
		super();
		this.zatvaranjeUlazneFakture = zatvaranjeUlazneFakture;
		DnevnoStanje = dnevnoStanje;
		this.poslovniPartner = poslovniPartner;
		this.zatvaranjeIzlazneFakture = zatvaranjeIzlazneFakture;
		this.iznos = iznos;
		this.preostaliIznos = preostaliIznos;
	}

}
