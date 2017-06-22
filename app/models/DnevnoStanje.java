package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import play.db.jpa.Model;

@Entity
public class DnevnoStanje extends Model {

	@XmlElement(name="datumIzvoda")
	@Column(nullable = false, length=10)
	public Date datumIzvoda;
	
	@XmlElement(name="novoStanje")
	@Column(nullable = false, length=20)
	public Float novoStanje;
	
	@XmlElement(name="prethodnoStanje")
	@Column(nullable = false, length=20)
	public Float prethodnoStanje;
	
	@XmlElement(name="rezervisano")
	@Column
	public Boolean rezervisano;
	
	@XmlElement(name="stanjeNaTeret")
	@Column(length=20)
	public Float stanjeNaTeret;
	
	@XmlElement(name="stanjeUKorist")
	@Column(length=20)
	public Float stanjeUKorist;
	
	@XmlElement(name="racun")
	@ManyToOne
	public Racun racun;
	
	@OneToMany(mappedBy="DnevnoStanje")
	public List<StavkaIzvoda> stavkaIzvoda;
	
	public DnevnoStanje(Racun racun, Date datumIzvoda, Float prethodnoStanje,
			Float stanjeUKorist, Float stanjeNaTeret, Float novoStanje,
			Boolean rezervisano, List<StavkaIzvoda> stavkaIzvoda) {
		super();
		this.racun = racun;
		this.datumIzvoda = datumIzvoda;
		this.prethodnoStanje = prethodnoStanje;
		this.stanjeUKorist = stanjeUKorist;
		this.stanjeNaTeret = stanjeNaTeret;
		this.novoStanje = novoStanje;
		this.rezervisano = rezervisano;
		this.stavkaIzvoda = stavkaIzvoda;
	}

	public Date getDatumIzvoda() {
		return datumIzvoda;
	}

	public void setDatumIzvoda(Date datumIzvoda) {
		this.datumIzvoda = datumIzvoda;
	}

	public Float getNovoStanje() {
		return novoStanje;
	}

	public void setNovoStanje(Float novoStanje) {
		this.novoStanje = novoStanje;
	}

	public Float getPrethodnoStanje() {
		return prethodnoStanje;
	}

	public void setPrethodnoStanje(Float prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}

	public Boolean getRezervisano() {
		return rezervisano;
	}

	public void setRezervisano(Boolean rezervisano) {
		this.rezervisano = rezervisano;
	}

	public Float getStanjeNaTeret() {
		return stanjeNaTeret;
	}

	public void setStanjeNaTeret(Float stanjeNaTeret) {
		this.stanjeNaTeret = stanjeNaTeret;
	}

	public Float getStanjeUKorist() {
		return stanjeUKorist;
	}

	public void setStanjeUKorist(Float stanjeUKorist) {
		this.stanjeUKorist = stanjeUKorist;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public List<StavkaIzvoda> getStavkaIzvoda() {
		return stavkaIzvoda;
	}

	public void setStavkaIzvoda(List<StavkaIzvoda> stavkaIzvoda) {
		this.stavkaIzvoda = stavkaIzvoda;
	}

     
}
