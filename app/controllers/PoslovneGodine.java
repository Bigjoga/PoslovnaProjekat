package controllers;

import java.util.List;

import models.Drzava;
import models.NaseljenoMesto;
import models.PoslovnaGodina;
import models.Preduzece;
import play.mvc.Controller;

//POSLOVNE GODINE KOMPLETNO ODRADJENE, SVE RADI!

public class PoslovneGodine  extends Controller{
	
	public static void show(String mode, Long selectedId)
	{
		List<Preduzece> preduzece = Preduzece.findAll();
		List<PoslovnaGodina> poslovneGodine = PoslovnaGodina.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(preduzece,poslovneGodine,mode,selectedId);
	}
	
	public static void create(PoslovnaGodina poslovnaGodina, Long preduzece)
	{
		validation.required(poslovnaGodina.IDgodine);
		validation.required(poslovnaGodina.godina);
		validation.required(poslovnaGodina.zakljucena);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		Preduzece pred = Preduzece.findById(preduzece);
		System.out.println("Drzava je -------> " + preduzece);
		poslovnaGodina.preduzece=pred;
		poslovnaGodina.save();
		show("add",poslovnaGodina.id);
	}
	
	public static void edit(PoslovnaGodina poslovnaGodina, Long preduzece)
	{
		validation.required(poslovnaGodina.IDgodine);
		validation.required(poslovnaGodina.godina);
		validation.required(poslovnaGodina.zakljucena);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		Preduzece pred = Preduzece.findById(preduzece);
		poslovnaGodina.preduzece = pred;
		poslovnaGodina.save();
		show("edit", poslovnaGodina.id);
	}
	
	public static void delete(Long id)
	{
		PoslovnaGodina poslovnagodina = PoslovnaGodina.findById(id);
		poslovnagodina.delete();
		show("edit",poslovnagodina.id-1);
	}

}
