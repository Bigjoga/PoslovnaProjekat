package models;

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
	
	@ManyToOne
	public Banka1 banka1;
	
	@OneToMany(mappedBy="racun")
	public List<DnevnoStanje>  DnevnoStanje;

	public Racun(Integer iDracuna, Banka1 banka1,
			List<DnevnoStanje> dnevnoStanje) {
		super();
		IDracuna = iDracuna;
		this.banka1 = banka1;
		this.DnevnoStanje = dnevnoStanje;
	}
	
	//odradjeno

}
