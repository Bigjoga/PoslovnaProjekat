package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class PoslovnaGodina extends Model {
	
	@Column(nullable=false, unique=true)
	public Integer IDgodine;
	
	@Column(nullable=false)
	public Integer godina;
	
	@Column(nullable=false)
	public Boolean zakljucena;
	
	@ManyToOne
	public Preduzece preduzece;
	
	@OneToMany(mappedBy="poslovnaGodina")
	public List <UlaznaFaktura>  ulaznaFaktura;
	
	@OneToMany(mappedBy="poslovnaGodina")
	public List<IzlaznaFaktura>  izlaznaFaktura;

	
	public PoslovnaGodina(Integer IDgodine, Integer godina, Boolean zakljucena,
			Preduzece preduzece, List<UlaznaFaktura> ulaznaFaktura,
			List<IzlaznaFaktura> izlaznaFaktura) {
		super();
		this.IDgodine = IDgodine;
		this.godina = godina;
		this.zakljucena = zakljucena;
		this.preduzece = preduzece;
		this.ulaznaFaktura = ulaznaFaktura;
		this.izlaznaFaktura = izlaznaFaktura;
	}
}
