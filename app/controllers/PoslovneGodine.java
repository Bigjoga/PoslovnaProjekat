package controllers;

import java.util.List;

import models.Drzava;
import models.NaseljenoMesto;
import models.PoslovnaGodina;
import models.Preduzece;
import play.mvc.Controller;

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
		Preduzece pred = Preduzece.findById(preduzece);
		System.out.println("Drzava je -------> " + preduzece);
		poslovnaGodina.preduzece=pred;
		poslovnaGodina.save();
		show("add",poslovnaGodina.id);
	}
	
	public static void edit(PoslovnaGodina poslovnaGodina, Long preduzece)
	{
		Preduzece preduceq = Preduzece.findById(preduzece);
		poslovnaGodina.preduzece = preduceq;
		poslovnaGodina.save();
		show("edit",poslovnaGodina.id);
	}
	
	public static void delete(Long id)
	{
		PoslovnaGodina poslovnagodina = PoslovnaGodina.findById(id);
		poslovnagodina.delete();
		show("edit",poslovnagodina.id-1);
	}

}
