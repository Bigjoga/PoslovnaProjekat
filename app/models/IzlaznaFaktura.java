package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mysql.fabric.xmlrpc.base.Data;

import play.db.jpa.Model;

@Entity
public class IzlaznaFaktura extends Model{
	
	@OneToMany(mappedBy="izlaznaFaktura")
	public List<ZatvaranjeIzlazneFakture> zatvaranjeIzlazneFakture;

	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	@ManyToOne 
	public PoslovnaGodina poslovnaGodina;

	@Column(nullable = false, length=5)
	public Integer brojFakture;
	
	@Column(nullable = false, length=10)
	public Date datumFakture;
	
	@Column(nullable = false, length=10)
	public Date datumValute;
	
	@Column(nullable = false, length=3)
	public Float ukupanRabat;
	
	@Column(nullable = false, length=20)
	public Float ukupanIznosBezPDV;
	
	@Column(nullable = false, length=3)
	public Float ukupanPDV;
	
	@Column(nullable = false, length=20)
	public Float ukupnoZaPlacanje;
	
	@Column(nullable = false, length=20)
	public Float preostaliIznos;
	
	@Column(nullable = false, length=25, unique=true)
	public String IDfakture;

	public IzlaznaFaktura(
			List<ZatvaranjeIzlazneFakture> zatvaranjeIzlazneFakture,
			PoslovniPartner poslovniPartner, PoslovnaGodina poslovnaGodina,
			Integer brojFakture, Date datumFakture, Date datumValute,
			Float ukupanRabat, Float ukupanIznosBezPDV, Float ukupanPDV,
			Float ukupnoZaPlacanje, Float preostaliIznos, String iDfakture) {
		super();
		this.zatvaranjeIzlazneFakture = zatvaranjeIzlazneFakture;
		this.poslovniPartner = poslovniPartner;
		this.poslovnaGodina = poslovnaGodina;
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
