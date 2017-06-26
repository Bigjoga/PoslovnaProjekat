package controllers;

import java.util.List;

import models.Korisnik;
import play.mvc.Controller;

public class Logovanje extends Controller{

	public static void show(String mode)
	{
		if(mode == null || mode.equals(""))
			mode = "login";
		render(mode);
	}
	
	public static void login(Korisnik korisnik)
	{
		
		System.out.println("------------------>" + korisnik.email);
		System.out.println("------------------>" + korisnik.sifra);
		
		
		List<Korisnik> kor = Korisnik.findAll();
		boolean nasao = false;
		String mode;
		
		System.out.println("----------------------->> " + kor.get(0).email);
		
		for(Korisnik k : kor)
		{
			if(k.email.equals(korisnik.email) && k.sifra.equals(korisnik.sifra))
			{
				nasao = true;
				session.put("radnik_email", k.email);
				session.put("radnik_sifra", k.sifra);
				session.put("radnik_id", k.id);
				
			    //mode = "edit";
			    renderTemplate("Drzave/show.html", "login");
				return;
			}
			else{
				
				mode = "add";
			    renderTemplate("Logovanje/show.html", mode);
			}
		}
		
		
	}
}
