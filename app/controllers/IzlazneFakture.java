package controllers;

import java.util.List;

import models.IzlaznaFaktura;
import models.PoslovnaGodina;
import models.PoslovniPartner;
import play.mvc.Controller;

public class IzlazneFakture extends Controller {
	
	public static void show(String mode, Long selectedIndex)
	{
		List<PoslovniPartner> poslovniPartner = PoslovniPartner.findAll();
		List<PoslovnaGodina> poslovnaGodina = PoslovnaGodina.findAll();
		List<IzlaznaFaktura> izlaznaFaktura = IzlaznaFaktura.findAll();		
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(izlaznaFaktura,poslovniPartner,mode,selectedIndex,poslovnaGodina);
	}
	/*
	public static void nextMehanizam(Long id)
	{	 
		PoslovniPartner poslovniPartner = PoslovniPartner.findById(id);
		List<PoslovniPartner> poslovniPartneri = PoslovniPartner.findAll();
		List<IzlaznaFaktura> izlFaktura = IzlaznaFaktura.findAll();
		List<IzlaznaFaktura> izlFakturaZaPrikaz = new ArrayList<IzlaznaFaktura>();
		
		for(IzlaznaFaktura fkt : izlFaktura)
		{
			if(fkt.poslovniPartner.id == poslovniPartner.id)
			{
				izlFakturaZaPrikaz.add(fkt);
			}
		}
		
		String mode = "edit";
		izlFaktura.clear();
		izlFaktura.addAll(izlFakturaZaPrikaz);
		
		Long idZaPrikaz = id;
		renderTemplate("IzlazneFakture/show.html",poslovniPartneri,izlFaktura,mode,0,idZaPrikaz);	
	}
	*/
	
	public static void create(IzlaznaFaktura izlaznaFaktura, Long poslovniPartner, Long poslovnaGodina)//, int datumFakture, int datumValute)
	{
		validation.required(izlaznaFaktura.brojFakture);
		validation.required(izlaznaFaktura.ukupanRabat);
		validation.required(izlaznaFaktura.ukupanIznosBezPDV);
		validation.required(izlaznaFaktura.ukupanPDV);
		validation.required(izlaznaFaktura.ukupnoZaPlacanje);
		validation.required(izlaznaFaktura.preostaliIznos);
		validation.required(izlaznaFaktura.IDfakture);
		validation.maxSize(izlaznaFaktura.brojFakture, 5);
		validation.maxSize(izlaznaFaktura.ukupanRabat, 3);
		validation.maxSize(izlaznaFaktura.ukupanIznosBezPDV, 20);
		validation.maxSize(izlaznaFaktura.ukupanPDV, 3);
		validation.maxSize(izlaznaFaktura.ukupnoZaPlacanje, 20);
		validation.maxSize(izlaznaFaktura.preostaliIznos, 20);
		validation.maxSize(izlaznaFaktura.IDfakture, 25);
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		PoslovnaGodina godina = PoslovnaGodina.findById(poslovnaGodina);
		izlaznaFaktura.poslovniPartner = partner;
		izlaznaFaktura.poslovnaGodina = godina;

		izlaznaFaktura.save();
		show("add",izlaznaFaktura.id);
	}	
	
	public static void edit(IzlaznaFaktura izlfak, Long poslovniPartner)
	{
		validation.required(izlfak.brojFakture);
		validation.required(izlfak.ukupanRabat);
		validation.required(izlfak.ukupanIznosBezPDV);
		validation.required(izlfak.ukupanPDV);
		validation.required(izlfak.ukupnoZaPlacanje);
		validation.required(izlfak.preostaliIznos);
		validation.required(izlfak.IDfakture);
		validation.maxSize(izlfak.brojFakture, 5);
		validation.maxSize(izlfak.ukupanRabat, 3);
		validation.maxSize(izlfak.ukupanIznosBezPDV, 20);
		validation.maxSize(izlfak.ukupanPDV, 3);
		validation.maxSize(izlfak.ukupnoZaPlacanje, 20);
		validation.maxSize(izlfak.preostaliIznos, 20);
		validation.maxSize(izlfak.IDfakture, 25);
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		izlfak.poslovniPartner = partner;
		izlfak.save();
		show("edit",izlfak.id);
	}
	
	public static void delete(Long id)
	{
		IzlaznaFaktura izlFaktura = IzlaznaFaktura.findById(id);
		izlFaktura.delete();
		show("edit", izlFaktura.id-1);
	}
	
	public static void filter(IzlaznaFaktura izlFaktura)
	{
		List<IzlaznaFaktura> izlaznaFaktura = IzlaznaFaktura.find("byBrojFaktureLike"/*, "%"+bank1.sifra+"%"*/, "%"+izlFaktura.brojFakture+"%").fetch();
		String mode = "edit";
		renderTemplate("Bank1/show.html", izlaznaFaktura, mode);
	}

}
