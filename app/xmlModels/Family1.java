package xmlModels;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Family1 {

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
	public Integer IDfakture;
    
    @XmlElement(name="poslovnaGodina")
	public String poslovnaGodina;
    
    @XmlElement(name="poslovniPartner")
	public String poslovniPartner;

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

	public Integer getIDfakture() {
		return IDfakture;
	}

	public void setIDfakture(Integer iDfakture) {
		IDfakture = iDfakture;
	}

	public String getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(String poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public String getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(String poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}
}
