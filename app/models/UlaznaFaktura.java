package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
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
	
	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	@Column(nullable = false, length=5)
	public String brojFakture;
	
	@Column(nullable = false)
	public Date datumFakture;
	
	@Column(nullable = false)
	public Date datumValute;
	
	@Column(nullable = false, length=3)
	public Number ukupanRabat;
	
	@Column(nullable = false, length=17)
	public Float ukupanIznosBezPDV;
	
	@Column(nullable = false, length=3)
	public Number ukupanPDV;
	
	@Column(nullable = false, length=17)
	public Float ukupnoZaPlacanje;
	
	@Column(nullable = false, length=17)
	public Float preostaliIznos;
	
	@Column(nullable = false, length=25, unique=true)
	public String IDfakture;

	public UlaznaFaktura(List<ZatvaranjeUlazneFakture> zatvaranjeUlazneFaktude,
			PoslovnaGodina poslovnaGodina, PoslovniPartner poslovniPartner,
			String brojFakture, Date datumFakture, Date datumValute,
			Number ukupanRabat, Float ukupanIznosBezPDV, Number ukupanPDV,
			Float ukupnoZaPlacanje, Float preostaliIznos, String iDfakture) {
		super();
		this.zatvaranjeUlazneFaktude = zatvaranjeUlazneFaktude;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
		this.brojFakture = brojFakture;
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.ukupanRabat = ukupanRabat;
		this.ukupanIznosBezPDV = ukupanIznosBezPDV;
		this.ukupanPDV = ukupanPDV;
		this.ukupnoZaPlacanje = ukupnoZaPlacanje;
		this.preostaliIznos = preostaliIznos;
		IDfakture = iDfakture;
	}
	
	
}
