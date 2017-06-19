package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.PoslovnaGodina;
import models.PoslovniPartner;
import models.UlaznaFaktura;
import play.mvc.Controller;

public class UlazneFakture extends Controller {
	
	public static void show(String mode, Long selectedIndex)
	{
		List<PoslovniPartner> poslovniPartner = PoslovniPartner.findAll();
		List<PoslovnaGodina> poslovnaGodina = PoslovnaGodina.findAll();
		List<UlaznaFaktura> ulaznaFaktura = UlaznaFaktura.findAll();		
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(ulaznaFaktura,poslovniPartner,mode,selectedIndex,poslovnaGodina);
	}
	/*
	public static void nextMehanizam(Long id)
	{	 
		PoslovniPartner poslovniPartner = PoslovniPartner.findById(id);
		List<PoslovniPartner> poslovniPartneri = PoslovniPartner.findAll();
		List<UlaznaFaktura> ulFaktura = UlaznaFaktura.findAll();
		List<UlaznaFaktura> ulFakturaZaPrikaz = new ArrayList<UlaznaFaktura>();
		
		for(UlaznaFaktura fkt : ulFaktura)
		{
			if(fkt.poslovniPartner.id == poslovniPartner.id)
			{
				ulFakturaZaPrikaz.add(fkt);
			}
		}
		
		String mode = "edit";
		ulFaktura.clear();
		ulFaktura.addAll(ulFakturaZaPrikaz);
		
		Long idZaPrikaz = id;
		renderTemplate("UlazneFakture/show.html",poslovniPartneri,ulFaktura,mode,0,idZaPrikaz);	
	}
	*/
	
	public static void create(UlaznaFaktura ulaznaFaktura, Long poslovniPartner, Long poslovnaGodina)
	{
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		PoslovnaGodina godina = PoslovnaGodina.findById(poslovnaGodina);
		ulaznaFaktura.poslovniPartner = partner;
		ulaznaFaktura.poslovnaGodina = godina;
		
		// uneti datum u formatu "godina-mesec-dan". npr. 2017-9-25 ili 1914-6-3

		ulaznaFaktura.save();
		show("add",ulaznaFaktura.id);
	}	
	
	public static void edit(UlaznaFaktura ulaznaFaktura, Long poslovniPartner)
	{
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		ulaznaFaktura.poslovniPartner = partner;
		ulaznaFaktura.save();
		show("edit",ulaznaFaktura.id);
	}
	
	public static void delete(Long id)
	{
		UlaznaFaktura ulFaktura = UlaznaFaktura.findById(id);
		ulFaktura.delete();
		show("edit", ulFaktura.id-1);
	}
	
	public static void filter(UlaznaFaktura ulFaktura)
	{
		List<UlaznaFaktura> ulaznaFaktura = UlaznaFaktura.find("byBrojFaktureLike"/*, "%"+bank1.sifra+"%"*/, "%"+ulFaktura.brojFakture+"%").fetch();
		String mode = "edit";
		renderTemplate("Bank1/show.html", ulaznaFaktura, mode);
	}

}
