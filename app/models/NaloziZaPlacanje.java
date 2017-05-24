package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.sun.org.apache.xpath.internal.operations.Bool;

import play.db.jpa.Model;


@Entity
public class NaloziZaPlacanje extends Model{
	
	@Column(nullable = false, length=50, unique=true)
	public String idPoruke;
	
	@Column(nullable = false, length=255)
	public String nalagodavac;
	
	@Column(nullable = false, length=255)
	public String svrhaPlacanja;
	
	@Column(nullable = false, length=255)
	public String poverilac;
	
	@Column(nullable = false, length=10)
	public Date datumNaloga;
	
	@Column(nullable = false, length=10)
	public Date datumValute;
	
	@Column(nullable = false, length=18)
	public String racunDuznika;
	
	@Column(length=2)
	public Number modelZaduzenja;
	
	@Column(length=20)
	public Number pozivNaBrojZaduzenja;
	
	@Column(nullable = false, length=18)
	public String racunPoverioca;
	
	@Column(nullable = false, length=2)
	public Number modelOdobrenja;
	
	@Column(nullable = false, length=20)
	public Number pozivNaBrojOdobrenja;
	
	@Column(nullable = false, length=17)
	public Float iznos;
	
	@Column(nullable = false, length=3)
	public String oznakaValute;
	
	@Column(nullable = false)
	public Bool hitno;
	
	@ManyToOne
	public PredlogPlacanja predlogPlacanja;

	public NaloziZaPlacanje(String idPoruke, String nalagodavac,
			String svrhaPlacanja, String poverilac,
			Date datumNaloga, Date datumValute,
			String racunDuznika, Number modelZaduzenja, 
			Number pozivNaBrojZaduzenja,
			String racunPoverioca, Number modelOdobrenja,
			Number pozivNaBrojOdobrenja, Float iznos,
			String oznakaValute, Bool hitno,PredlogPlacanja predlogPlacanja) {
		super();
		this.idPoruke = idPoruke;
		this.nalagodavac = nalagodavac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.poverilac = poverilac;
		this.datumNaloga = datumNaloga;
		this.datumValute = datumValute;
		this.racunDuznika = racunDuznika;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
		this.racunPoverioca = racunPoverioca;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.iznos = iznos;
		this.oznakaValute = oznakaValute;
		this.hitno = hitno;
		this.predlogPlacanja = predlogPlacanja;
	}

}
