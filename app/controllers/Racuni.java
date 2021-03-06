package controllers;

import java.util.ArrayList;
import java.util.List;

import com.sun.prism.RenderTarget;

import models.Banka1;
import models.Racun;
import play.mvc.Controller;

//RACUNI KOMPLETNO ODRADJENI, SVE RADI!

public class Racuni extends Controller{

	public static void show(String mode, Long selectedIndex)
	{
		List<Banka1> banka1 = Banka1.findAll();
		List<Racun> racuni = Racun.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(banka1,racuni,mode,selectedIndex);
	}
	
	public static void nextMehanizam(Long id)
	{
		Banka1 bnc = Banka1.findById(id);
		List<Racun> racuni = Racun.findAll();
		List<Racun> racuniZaPrikaz = new ArrayList<Racun>();
		List<Banka1> banka1 = Banka1.findAll();
		
		for(Racun rac : racuni)
		{
			if(rac.banka1.id == bnc.id)
			{
				racuniZaPrikaz.add(rac);
			}
		}
		String mode = "edit";
		racuni.clear();
		racuni.addAll(racuniZaPrikaz);
		Long idZaPrikaz = id;
		renderTemplate("Racuni/show.html",banka1,racuni,mode,0,idZaPrikaz);	
	}
	
	public static void create(Racun racun, Long banka1)
	{
		validation.required(racun.IDracuna);
		validation.required(racun.datumOtvaranja);
		validation.required(racun.datumZatvaranja);
		validation.maxSize(racun.IDracuna, 18);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		Banka1 banka = Banka1.findById(banka1);
		System.out.println("Banka je --------> " + banka.sifra);
		racun.banka1=banka;
		racun.save();
		show("add",racun.id);
	}	
	
	public static void edit(Racun racun, Long banka1)
	{
		validation.required(racun.IDracuna);
		validation.required(racun.datumOtvaranja);
		validation.required(racun.datumZatvaranja);
		validation.maxSize(racun.IDracuna, 18);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		Banka1 banka = Banka1.findById(banka1);
		racun.banka1=banka;
		racun.save();
		show("add",racun.id);
	}
	
	
	public static void filter(Racun racun)
	{
		List<Racun> racuni = Racun.find("byIDracunaLike", "%"+racun.IDracuna+"%").fetch();
		String mode = "edit";
		renderTemplate("Racuni/show.html", racuni, mode);
	}
	
	public static void delete(Long id)
	{
		Racun rac = Racun.findById(id);
		rac.delete();
		show("edit",rac.id-1);
	}
}
