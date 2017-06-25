package xmlModels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import models.PoslovnaGodina;
import models.PoslovniPartner;

@XmlAccessorType(XmlAccessType.FIELD)
public class Family2 {
	
	@XmlElement(name="brojFakture")
	public Integer brojFakture;
	
    @XmlElement(name="datumFakture")
	public String datumFakture;
	
    @XmlElement(name="datumValute")
	public String datumValute;
	
    @XmlElement(name="ukupanRabat")
	public Float ukupanRabat;
	
    @XmlElement(name="ukupanIznosBezPDV")
	public Float ukupanIznosBezPDV;
	
    @XmlElement(name="ukupanPDV")
	public Float ukupanPDV;
	
    @XmlElement(name="ukupnoZaPlacanje")
	public Float ukupnoZaPlacanje;
	
    @XmlElement(name="preostaliIznos")
	public Float preostaliIznos;
	
    @XmlElement(name="IDfakture")
	public String IDfakture;
    
    @XmlElement(name="poslovnaGodina")
	public Integer poslovnaGodina;
    
    @XmlElement(name="poslovniPartner")
	public String poslovniPartner;

	public Family2(Integer brojFakture, String datumFakture,
			String datumValute, Float ukupanRabat, Float ukupanIznosBezPDV,
			Float ukupanPDV, Float ukupnoZaPlacanje, Float preostaliIznos,
			String IDfakture, Integer poslovnaGodina, String poslovniPartner) {
		super();
		this.brojFakture = brojFakture;
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.ukupanRabat = ukupanRabat;
		this.ukupanIznosBezPDV = ukupanIznosBezPDV;
		this.ukupanPDV = ukupanPDV;
		this.ukupnoZaPlacanje = ukupnoZaPlacanje;
		this.preostaliIznos = preostaliIznos;
		this.IDfakture = IDfakture;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
	}
/*
	public Family2(Integer brojFakture2, String string, String string2,
			Float ukupanRabat2, Float ukupanIznosBezPDV2, Float ukupanPDV2,
			Float ukupnoZaPlacanje2, Float preostaliIznos2, String iDfakture2,
			PoslovnaGodina poslovnaGodina2, PoslovniPartner poslovniPartner2) {
		// TODO Auto-generated constructor stub
	}*/

	public Integer getBrojFakture() {
		return brojFakture;
	}

	public void setBrojFakture(Integer brojFakture) {
		this.brojFakture = brojFakture;
	}

	public String getDatumFakture() {
		return datumFakture;
	}

	public void setDatumFakture(String datumFakture) {
		this.datumFakture = datumFakture;
	}

	public String getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(String datumValute) {
		this.datumValute = datumValute;
	}

	public Float getUkupanRabat() {
		return ukupanRabat;
	}

	public void setUkupanRabat(Float ukupanRabat) {
		this.ukupanRabat = ukupanRabat;
	}

	public Float getUkupanIznosBezPDV() {
		return ukupanIznosBezPDV;
	}

	public void setUkupanIznosBezPDV(Float ukupanIznosBezPDV) {
		this.ukupanIznosBezPDV = ukupanIznosBezPDV;
	}

	public Float getUkupanPDV() {
		return ukupanPDV;
	}

	public void setUkupanPDV(Float ukupanPDV) {
		this.ukupanPDV = ukupanPDV;
	}

	public Float getUkupnoZaPlacanje() {
		return ukupnoZaPlacanje;
	}

	public void setUkupnoZaPlacanje(Float ukupnoZaPlacanje) {
		this.ukupnoZaPlacanje = ukupnoZaPlacanje;
	}

	public Float getPreostaliIznos() {
		return preostaliIznos;
	}

	public void setPreostaliIznos(Float preostaliIznos) {
		this.preostaliIznos = preostaliIznos;
	}

	public String getIDfakture() {
		return IDfakture;
	}

	public void setIDfakture(String iDfakture) {
		IDfakture = iDfakture;
	}

	public Integer getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(Integer poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public String getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(String poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}
}
