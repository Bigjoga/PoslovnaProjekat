package xmlModels;

import java.sql.Date;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Family {

	@XmlElement(name="datumIzvoda")
    private String datumIzvoda;
    
    @XmlElement(name="novoStanje")
    private Float novoStanje;
    
    @XmlElement(name="prethodnoStanje")
    private Float prethodnoStanje;
    
    @XmlElement(name="rezervisano")
    private Boolean rezervisano;
    
    @XmlElement(name="stanjeNaTeret")
    private Float stanjeNaTeret;
    
    @XmlElement(name="stanjeUKorist")
    private Float stanjeUKorist;
    
    @XmlElement(name="racun")
    private Integer racun;
    
    public String getDatumIzvoda() {
		return datumIzvoda;
	}

	public void setDatumIzvoda(String datumIzvoda) {
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

	public Integer getRacun() {
		return racun;
	}

	public void setRacun(Integer racun) {
		this.racun = racun;
	}
}