package controllers;

import java.util.List;

import models.PoslovniPartner;
import models.Preduzece;
import play.mvc.Controller;

public class PoslovniPartneri extends Controller{

	public static void show(String mode, Long selectedIndex)
	{
		List<Preduzece> preduzeca = Preduzece.findAll();
		List<PoslovniPartner> partneri = PoslovniPartner.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(preduzeca,partneri,mode,selectedIndex);
	}
	
	public static void create(PoslovniPartner poslovnipartner, Long preduzece)
	{
		Preduzece pred = Preduzece.findById(preduzece);
		poslovnipartner.preduzece=pred;
		poslovnipartner.save();
		show("add",poslovnipartner.id);
	}
	
	public static void edit(PoslovniPartner poslovnipartner, Long preduzece)
	{
		System.out.println("-----------------> " + poslovnipartner.id);
		Preduzece pred = Preduzece.findById(preduzece);
		poslovnipartner.preduzece=pred;
		poslovnipartner.save();
		show("edit",poslovnipartner.id);
	}
	
	public static void delete(Long id)
	{
		PoslovniPartner poslovni = PoslovniPartner.findById(id);
		poslovni.delete();
		show("edit",poslovni.id-1);
	}
}
