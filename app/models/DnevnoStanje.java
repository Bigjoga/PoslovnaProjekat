package models;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import com.mysql.fabric.xmlrpc.base.Data;

public class DnevnoStanje extends Model {

	public Date datumIzvoda;
	
	public Float prethodnoStanje;
	
	public Float prometUkorist;
	
	public Float prometNaTeret;
	
	public Float NovoStanje;
	
	public Boolean rezervisano;
	
	@ManyToOne
	public RacuniPreduzeca racuniPreduzeca;
	
	@OneToMany(mappedBy="DnevnoStanje")
	ArrayList<StavkaIzvoda> stavkaIzvoda;

	public DnevnoStanje(Date datumIzvoda, Float prethodnoStanje,
			Float prometUkorist, Float prometNaTeret, Float novoStanje,
			Boolean rezervisano, RacuniPreduzeca racuniPreduzeca,
			ArrayList<StavkaIzvoda> stavkaIzvoda) {
		super();
		this.datumIzvoda = datumIzvoda;
		this.prethodnoStanje = prethodnoStanje;
		this.prometUkorist = prometUkorist;
		this.prometNaTeret = prometNaTeret;
		NovoStanje = novoStanje;
		this.rezervisano = rezervisano;
		this.racuniPreduzeca = racuniPreduzeca;
		this.stavkaIzvoda = stavkaIzvoda;
	}
	
}
