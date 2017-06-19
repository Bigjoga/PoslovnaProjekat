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
	
	public static void create(IzlaznaFaktura izlaznaFaktura, Long poslovniPartner, Long poslovnaGodina, int datumFakture, int datumValute)
	{
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		PoslovnaGodina godina = PoslovnaGodina.findById(poslovnaGodina);
		izlaznaFaktura.poslovniPartner = partner;
		izlaznaFaktura.poslovnaGodina = godina;
		
		// uneti datum u formatu "godina-mesec-dan". npr. 2017-9-25 ili 1914-6-3

		izlaznaFaktura.save();
		show("add",izlaznaFaktura.id);
	}	
	
	public static void edit(IzlaznaFaktura izlfak, Long poslovniPartner)
	{
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
