package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import com.sun.org.apache.xpath.internal.operations.Bool;

@Entity
public class DnevnoStanje extends Model {
	
	@ManyToOne
	public RacuniPreduzeca recunipreduzeca;
	
	@Column(nullable = false, length=10)
	public Date datumIzvoda;
	
	@Column(nullable = false, length=20)
	public Float prethodnoStanje;
	
	@Column(length=20)
	public Float stanjeUKorist;
	
	@Column(length=20)
	public Float stanjeNaTeret;
	
	@Column(nullable = false, length=20)
	public Float novoStanje;
	
	@Column(length=20)
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
		this.stanjeUKorist = prometUkorist;
		this.stanjeNaTeret = prometNaTeret;
		this.novoStanje = novoStanje;
		this.rezervisano = rezervisano;
		this.stavkaIzvoda = stavkaIzvoda;
	}
}
