package xmlExport;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import models.DnevnoStanje;
import models.PoslovniPartner;

@XmlRootElement(name = "employee")
@XmlAccessorType (XmlAccessType.FIELD)
public class StavkaIzvodaExport {

	
	public String dnevnoStanje;
	
	
	public String poslovniPartner;

	
	public Integer brojStavke;
	
	
	public String duznikNalagodavac;
	
	
	public String svrhaPlacanja;
	
	
	public String poverilacPrimalac;
	
	
	public String datumPrijema;
	
	
	public String datumValute;
	
	
	public Integer modelZaduzenja;
	
	
	public String pozivNaBrojZaduzenja;
	
	
	public String racunPoverioca;
	
	
	public Integer modelOdobrenja;
	
	
	public String pozivNaBrojOdobrenja;
	
	
	public Boolean hitno;
	
	
	public Float iznos;
	
	
	public Integer tipGreske;
	
	
	public String status;


	public StavkaIzvodaExport(String dnevnoStanje, String poslovniPartner,
			Integer brojStavke, String duznikNalagodavac, String svrhaPlacanja,
			String poverilacPrimalac, String datumPrijema, String datumValute,
			Integer modelZaduzenja, String pozivNaBrojZaduzenja,
			String racunPoverioca, Integer modelOdobrenja,
			String pozivNaBrojOdobrenja, Boolean hitno, Float iznos,
			Integer tipGreske, String status) {
		super();
		this.dnevnoStanje = dnevnoStanje;
		this.poslovniPartner = poslovniPartner;
		this.brojStavke = brojStavke;
		this.duznikNalagodavac = duznikNalagodavac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.poverilacPrimalac = poverilacPrimalac;
		this.datumPrijema = datumPrijema;
		this.datumValute = datumValute;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
		this.racunPoverioca = racunPoverioca;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.hitno = hitno;
		this.iznos = iznos;
		this.tipGreske = tipGreske;
		this.status = status;
	}


	
	
	
	
	
	
	
}