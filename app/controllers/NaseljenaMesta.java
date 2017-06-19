package controllers;

import java.util.ArrayList;
import java.util.List;

import play.mvc.Controller;
import models.Drzava;
import models.NaseljenoMesto;

public class NaseljenaMesta extends Controller{

	public static void show(String mode, Long selectedIndex)
	{
		List<Drzava> drzave = Drzava.findAll();
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(drzave,naseljenaMesta,mode,selectedIndex);
	}
	
	public static void nextMehanizam(Long id)

	{

		Drzava drz = Drzava.findById(id);
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		List<NaseljenoMesto> mestaZaPrikaz = new ArrayList<NaseljenoMesto>();
		List<Drzava> drzave = Drzava.findAll();

		for(NaseljenoMesto nm : naseljenaMesta)
		{
			if(nm.drzava.id == drz.id)
			{
				mestaZaPrikaz.add(nm);
			}
		}
		String mode = "edit";
		naseljenaMesta.clear();
		naseljenaMesta.addAll(mestaZaPrikaz);
		Long idZaPrikaz = id;
		renderTemplate("NaseljenaMesta/show.html",drzave,naseljenaMesta,mode,0,idZaPrikaz);	
	}
	
	public static void create(NaseljenoMesto naseljenoMesto, Long drzava)
	{
		validation.required(naseljenoMesto.oznaka);
		validation.required(naseljenoMesto.naziv);
		validation.required(naseljenoMesto.postanskiBroj);
		validation.maxSize(naseljenoMesto.oznaka, 3);
		validation.maxSize(naseljenoMesto.naziv, 40);
		validation.maxSize(naseljenoMesto.postanskiBroj, 5);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		//System.out.println("CREATE: " + naseljenoMesto.naziv + "||" + naseljenoMesto.id);
		Drzava drzavax = Drzava.findById(drzava);
		naseljenoMesto.drzava=drzavax;
		naseljenoMesto.save();
		show("add",naseljenoMesto.id);
	}
	
	public static void edit(NaseljenoMesto naseljenoMesto, Long drzava)
	{
		validation.required(naseljenoMesto.oznaka);
		validation.required(naseljenoMesto.naziv);
		validation.required(naseljenoMesto.postanskiBroj);
		validation.maxSize(naseljenoMesto.oznaka, 3);
		validation.maxSize(naseljenoMesto.naziv, 10);
		validation.maxSize(naseljenoMesto.postanskiBroj, 5);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		Drzava drzavax = Drzava.findById(drzava);
		naseljenoMesto.drzava=drzavax;
		naseljenoMesto.save();
		show("edit",naseljenoMesto.id);
	}
	
	public static void filter(NaseljenoMesto naseljenoMesto)
	{
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.find("byOznakaLikeAndNazivLikeAndPostanskiBrojLike", "%"+naseljenoMesto.oznaka+"%", "%"+naseljenoMesto.naziv+"%", "%"+naseljenoMesto.postanskiBroj+"%").fetch();
		String mode = "edit";
		renderTemplate("NaseljenaMesta/show.html", naseljenaMesta, mode );
	}
	
	public static void delete(Long id)
	{
		NaseljenoMesto naseljenoMesto = NaseljenoMesto.findById(id);
		naseljenoMesto.delete();
		show("edit",naseljenoMesto.id-1);
	}
	
}
