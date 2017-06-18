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

	public static void create(Preduzece pred)
	{
		validation.required(pred.naziv);
		validation.required(pred.adresa);
		validation.required(pred.kontakt);
		validation.required(pred.sifra);
		validation.maxSize(pred.naziv, 30);
		validation.maxSize(pred.adresa, 30);
		validation.maxSize(pred.kontakt, 20);
		validation.maxSize(pred.sifra, 25);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		pred.save();
		show("add",pred.id);
	}	
	
	public static void edit(Preduzece pred)
	{
		validation.required(pred.naziv);
		validation.required(pred.adresa);
		validation.required(pred.kontakt);
		validation.required(pred.sifra);
		validation.maxSize(pred.naziv, 30);
		validation.maxSize(pred.adresa, 30);
		validation.maxSize(pred.kontakt, 20);
		validation.maxSize(pred.sifra, 25);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		pred.save();
		show("edit",pred.id);
	}
	
	public static void delete(Long id)
	{
		Preduzece pred = Preduzece.findById(id);
		pred.delete();
		show("edit",pred.id-1);
	}
	
	public static void filter(Preduzece pred)
	{
		List<Preduzece> preduzeceee = Preduzece.find("bySifraLikeAndNazivLike", "%"+pred.sifra+"%", "%"+pred.naziv+"%").fetch();
		String mode = "edit";
		renderTemplate("Preduzeca/show.html", preduzeceee, mode);
	}
}
