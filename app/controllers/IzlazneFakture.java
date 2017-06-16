package controllers;

import java.util.ArrayList;
import java.util.List;

import models.PoslovniPartner;
import models.IzlaznaFaktura;
import models.PoslovnaGodina;
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
	
	
	public static void create(IzlaznaFaktura izlFaktura, Long poslovniPartner)
	{
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		izlFaktura.poslovniPartner = partner;
		izlFaktura.save();
		show("add",izlFaktura.id);
	}	
	
	public static void edit(IzlaznaFaktura izlFaktura, Long poslovniPartner)
	{
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		izlFaktura.poslovniPartner = partner;
		izlFaktura.save();
		show("edit",izlFaktura.id);
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
