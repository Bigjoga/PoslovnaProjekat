package models;

import java.util.ArrayList;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

public class StavkaIzvoda extends Model {
	
	
	public Float iznos;
	
	public Float preostaliIznos;
	
	@ManyToOne
	public ArrayList<DnevnoStanje> dnevnoStanje;
	
	@OneToMany(mappedBy="StavkaIzvoda")
	public ArrayList<ZatvaranjeUlazneFakture>  zatvaranjeUlazneFakture;
	
	@ManyToOne
	public PoslovniPartner poslovniPartner;

	@OneToMany(mappedBy="StavkaIzvoda")
	public ZatvaranjeIzlazneFakture zatvaranjeIzlazneFakture;

	public StavkaIzvoda(Float iznos, Float preostaliIznos,
			ArrayList<DnevnoStanje> dnevnoStanje,
			ArrayList<ZatvaranjeUlazneFakture> zatvaranjeUlazneFakture,
			PoslovniPartner poslovniPartner,
			ZatvaranjeIzlazneFakture zatvaranjeIzlazneFakture) {
		super();
		this.iznos = iznos;
		this.preostaliIznos = preostaliIznos;
		this.dnevnoStanje = dnevnoStanje;
		this.zatvaranjeUlazneFakture = zatvaranjeUlazneFakture;
		this.poslovniPartner = poslovniPartner;
		this.zatvaranjeIzlazneFakture = zatvaranjeIzlazneFakture;
	}
	
}
