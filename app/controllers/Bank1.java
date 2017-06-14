package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Banka1;
import models.Drzava;
import models.NaseljenoMesto;
import play.mvc.Controller;

public class Bank1 extends Controller{
	
	public static void show(String mode, Long selectedIndex)
	{
		List<Banka1> banka1 = Banka1.findAll();
		List<NaseljenoMesto> naseljenoMesto = NaseljenoMesto.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(banka1,naseljenoMesto,mode,selectedIndex);
	}
	/*
	public static void nextMehanizam(Long id)
	{	
		NaseljenoMesto nas = NaseljenoMesto.findById(id);
		List<Banka1> bank1 = Banka1.findAll();
		List<Banka1> bankeZaPrikaz = new ArrayList<Banka1>();
		List<NaseljenoMesto> naseljenoMesto = NaseljenoMesto.findAll();
		
		for(Banka1 bnk : bank1)
		{
			if(bnk.naseljenoMesto.id == nas.id)
			{
				bankeZaPrikaz.add(bnk);
			}
		}
		
		String mode = "edit";
		bank1.clear();
		bank1.addAll(bankeZaPrikaz);
		
		Long idZaPrikaz = id;
		renderTemplate("Bank1/show.html",naseljenoMesto,bank1,mode,0,idZaPrikaz);	
	}
	*/
	public static void create(Banka1 banka1, Long naseljenoMesto)
	{
		NaseljenoMesto naselje = NaseljenoMesto.findById(naseljenoMesto);
		banka1.naseljenoMesto = naselje;
		banka1.save();
		show("add",banka1.id);
	}	
	
	public static void edit(Banka1 banka1)
	{
		banka1.save();
		show("edit",banka1.id);
	}
	
	public static void delete(Long id)
	{
		Banka1 banka = Banka1.findById(id);
		banka.delete();
		show("edit", banka.id-1);
	}
	
	public static void filter(Banka1 banka1) //OOVO ISPRAVITI
	{
		List<Banka1> bank1 = Banka1.find("bySifraLikeAndNazivLike", "%"+banka1.sifra+"%", "%"+banka1.naziv+"%").fetch();
		String mode = "edit";
		renderTemplate("Bank1/show.html", bank1, mode);
	}
}
