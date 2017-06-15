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
		
		/*
		List<Korisnik> kor = Korisnik.findAll();
		boolean nasao = false;
		
		for(Korisnik k : kor)
		{
			if(k.email.equals(korisnik.email) && k.sifra.equals(korisnik.sifra))
			{
				nasao = true;
				session.put("radnik_email", k.email);
				session.put("radnik_sifra", k.sifra);
				session.put("radnik_id", k.id);
				
				String mode = "";
				return;
			}
		}
		*/
		
		if(korisnik.email.equals("gaja") && korisnik.sifra.equals("gaja")){
			
			String mode = "add";
			renderTemplate("Drzave/show.html", mode);
		}
		
		else {
			
			String mode = "logovanje";
			renderTemplate("Logovanje/show.html", mode);
			
		}
		
		/*
		String mode = "logovanje";
		renderTemplate("Logovanje/show.html", mode);
		*/
	}
}
