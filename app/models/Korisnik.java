package models;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Korisnik extends Model{

	@Column(nullable =false)
	public String email;
	
	@Column(nullable =false)
	public String sifra;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Korisnik(String email, String sifra) {
		super();
		this.email = email;
		this.sifra = sifra;
	}

	public Korisnik() {
		super();
	}	
}
