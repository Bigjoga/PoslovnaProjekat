package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Banka1;
import models.Drzava;
import models.NaseljenoMesto;
import play.mvc.Controller;

//BANKA KOMPLETNO ODRADJENA, SVE RADI!

public class Bank1 extends Controller{
	
	public static void show(String mode, Long selectedIndex)
	{
		List<NaseljenoMesto> naseljenoMesto = NaseljenoMesto.findAll();
		List<Banka1> banka1 = Banka1.findAll();		
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(banka1,naseljenoMesto,mode,selectedIndex);
	}
	
	public static void nextMehanizam(Long id)
	{	 
		NaseljenoMesto naseljenoMesto = NaseljenoMesto.findById(id);
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		List<Banka1> banka1 = Banka1.findAll();
		List<Banka1> bank1ZaPrikaz = new ArrayList<Banka1>();
		
		for(Banka1 bnk : banka1)
		{
			if(bnk.naseljenoMesto.naziv.equals(naseljenoMesto.naziv))
			{
				System.out.println("USAOOOOOOOOOOOOOOOOOOOOOOOOO");
				bank1ZaPrikaz.add(bnk);
			}
		}
		
		String mode = "edit";
		banka1.clear();
		banka1.addAll(bank1ZaPrikaz);
		
		Long idZaPrikaz = id;
		renderTemplate("Bank1/show.html",naseljenaMesta,banka1,mode,0,idZaPrikaz);	
	}
	
	public static void create(Banka1 bank1, Long naseljenoMesto)
	{
		validation.required(bank1.sifra);
		validation.required(bank1.naziv);
		validation.maxSize(bank1.sifra, 3);
		validation.maxSize(bank1.naziv, 30);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		NaseljenoMesto naselje = NaseljenoMesto.findById(naseljenoMesto);
		bank1.naseljenoMesto = naselje;
		bank1.save();
		show("add",bank1.id);
	}	
	
	public static void edit(Banka1 bank1, Long naseljenoMesto)
	{
		validation.required(bank1.sifra);
		validation.required(bank1.naziv);
		validation.maxSize(bank1.sifra, 3);
		validation.maxSize(bank1.naziv, 30);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		NaseljenoMesto naselje = NaseljenoMesto.findById(naseljenoMesto);
		bank1.naseljenoMesto = naselje;
		bank1.save();
		show("edit",bank1.id);
	}
	
	public static void delete(Long id)
	{
		Banka1 banka = Banka1.findById(id);
		banka.delete();
		show("edit", banka.id-1);
	}
	
	public static void filter(Banka1 bank1)
	{
		List<Banka1> banka1 = Banka1.find("byNazivLike"/*, "%"+bank1.sifra+"%"*/, "%"+bank1.naziv+"%").fetch();
		String mode = "edit";
		renderTemplate("Bank1/show.html", banka1, mode);
	}
}
