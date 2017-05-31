package models;

import java.sql.Date;
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
	
	@Column(nullable = false, unique=true)
	public Integer brojStavke;
	
	@Column(nullable = false, length=256)
	public String DuznikNalagodavac;
	
	@Column(nullable = false, length=256)
	public String svrhaPlacanja;
	
	@Column(nullable = false, length=256)
	public String PoverilacPrimalac;
	
	@Column(nullable = false)
	public Date datumPrijema;
	
	@Column()
	public Date datumValute;
	
	@Column(length=2)
	public Number modelZaduzenja;
	
	@Column(length=20)
	public String pozivNaBrojZaduzenja;
	
	@Column(length=18)
	public String racunPoverioca;
	
	@Column(length=2)
	public Number modelOdobrenja;
	
	@Column(length=20)
	public String pozivNaBrojOdobrenja;
	
	@Column(nullable = false)
	public Boolean hitno;
	
	@Column(nullable = false)
	public Float iznos;
	
	@Column(nullable = false, length=1)
	public Number tipGreske;
	
	@Column(length=1)
	public String status;
	
	public StavkaIzvoda(List<ZatvaranjeUlazneFakture> zatvaranjeUlazneFakture,
			models.DnevnoStanje dnevnoStanje, PoslovniPartner poslovniPartner,
			List<ZatvaranjeIzlazneFakture> zatvaranjeIzlazneFakture,
			Integer brojStavke, String DuznikNalagodavac,
			String svrhaPlacanja, String PoverilacPrimalac,
			Date datumPrijema, Date datumValute, Number modelZaduzenja,
			String pozivNaBrojZaduzenja, String racunPoverioca, Number modelOdobrenja,
			String pozivNaBrojOdobrenja, Boolean hitno, Float iznos, Number tipGreske, String status) {
		super();
		this.zatvaranjeUlazneFakture = zatvaranjeUlazneFakture;
		DnevnoStanje = dnevnoStanje;
		this.poslovniPartner = poslovniPartner;
		this.zatvaranjeIzlazneFakture = zatvaranjeIzlazneFakture;
		this.brojStavke = brojStavke;
		this.DuznikNalagodavac = DuznikNalagodavac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.PoverilacPrimalac = PoverilacPrimalac;
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
