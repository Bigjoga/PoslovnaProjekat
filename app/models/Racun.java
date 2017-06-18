package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Racun  extends Model{
	
	@Column(unique=true, nullable=false, length=18)
	public Integer IDracuna;
	
	@Column(nullable=false)
	public Date datumOtvaranja;
	
	@Column(nullable=false)
	public Date datumZatvaranja;
	
	@ManyToOne
	public Banka1 banka1;
	
	@OneToMany(mappedBy="racun")
	public List<DnevnoStanje>  DnevnoStanje;

	public Racun(Integer IDracuna, Banka1 banka1,
			Date datumOtvaranja, Date datumZatvaranja,
			List<DnevnoStanje> dnevnoStanje) {
		super();
		this.IDracuna = IDracuna;
		this.banka1 = banka1;
		this.datumOtvaranja = datumOtvaranja;
		this.datumZatvaranja = datumZatvaranja;
		this.DnevnoStanje = dnevnoStanje;
	}
}
