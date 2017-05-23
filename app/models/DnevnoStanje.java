package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import com.sun.org.apache.xpath.internal.operations.Bool;

@Entity
public class DnevnoStanje extends Model {
	
	@ManyToOne
	public RacuniPreduzeca recunipreduzeca;
	
	public Date datumIzvoda;
	public Float prethodnoStanje;
	public Float prometUkorist;
	public Float prometNaTeret;
	public Float novoStanje;
	public Bool rezervisano;
	
	@OneToMany(mappedBy="DnevnoStanje")
	public List<StavkaIzvoda>  stavkaIzvoda;

	public DnevnoStanje(RacuniPreduzeca recunipreduzeca, Date datumIzvoda,
			Float prethodnoStanje, Float prometUkorist, Float prometNaTeret,
			Float novoStanje, Bool rezervisano, List<StavkaIzvoda> stavkaIzvoda) {
		super();
		this.recunipreduzeca = recunipreduzeca;
		this.datumIzvoda = datumIzvoda;
		this.prethodnoStanje = prethodnoStanje;
		this.prometUkorist = prometUkorist;
		this.prometNaTeret = prometNaTeret;
		this.novoStanje = novoStanje;
		this.rezervisano = rezervisano;
		this.stavkaIzvoda = stavkaIzvoda;
	}

	
	
	//odradjeno
	

}
