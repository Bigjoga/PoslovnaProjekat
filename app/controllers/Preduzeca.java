package controllers;

import java.util.List;

import models.Banka1;
import models.Drzava;
import models.Preduzece;
import models.Racun;
import play.mvc.Controller;

public class Preduzeca extends Controller{

	public static void show(String mode, Long selectedId)
	{
		List<Preduzece> preduzeceee = Preduzece.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(preduzeceee,mode,selectedId);
	}
<<<<<<< HEAD
	/*
	public static void create(Preduzece preddd)
=======
	
	public static void create(Preduzece pred)
>>>>>>> 5b35f4b5e80964e128878733e4990ed7970cd27f
	{
		pred.save();
		show("add",pred.id);
	}	
	
	public static void edit(Preduzece pred)
	{
		pred.save();
		show("edit",pred.id);
	}
	
	public static void delete(Long id)
	{
		Preduzece pred = Preduzece.findById(id);
		pred.delete();
		show("edit", pred.id-1);
	}
	
	public static void filter(Preduzece pred)
	{
		List<Preduzece> preduzeceee = Preduzece.find("bySifraLikeAndNazivLikeAndAdresaLikeAndKontaktLike", 
				"%"+pred.sifra+"%", "%"+pred.naziv+"%" , "%"+pred.adresa+"%" , "%"+pred.kontakt+"%").fetch();
		String mode = "edit";
		renderTemplate("Preduzeca/show.html", preduzeceee, mode );
	}
	*/
	public static void create(Preduzece preddd)
	{
		preddd.save();
		show("add",preddd.id);
	}	
}
