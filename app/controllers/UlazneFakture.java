package controllers;

import java.sql.Date;
import java.text.ParseException;
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
	
	public static void create(UlaznaFaktura ulaznaFaktura, Long poslovniPartner, Long poslovnaGodina, int datumFakture, int datumValute)
	{
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		PoslovnaGodina godina = PoslovnaGodina.findById(poslovnaGodina);
		ulaznaFaktura.poslovniPartner = partner;
		ulaznaFaktura.poslovnaGodina = godina;
		
		/*	imao sam neki kod pomocu kojeg sam uspeo da dodam red u tabelu
		 *  to sam obrisao odavde jer jednostavno ne radi to sto treba (dodaje samo neku 1969. ili 1970. god)
		 *  zato sto ovaj parametar datumFakture nije ispravan nikad
		 *  ako sad pokrenes ovaj kod, videces u terminalu da ti iznad greske ispisuje ovo iz 65. i 67. reda:
		 *  datumFakture1.1 = 0 i datumFakture1.2 = 0
		 * */
		
		// ne radi jer je datumFakture uvek jednak nuli
		/*
		System.out.println("datumFakture1.1 = "+datumFakture);
		String datumF = Integer.toString(datumFakture);
		System.out.println("datumFakture1.2 = "+datumF);
		int danF = Integer.parseInt(datumF.substring(0,2));
		int mesecF = Integer.parseInt(datumF.substring(3,5));
		int godinaF = Integer.parseInt(datumF.substring(6,10));
		Date datumF1 = new Date(godinaF,mesecF,danF);
		Date datumV1 = new Date(godinaF,mesecF,danF);
		//
		
		ulaznaFaktura.datumFakture = datumF1;
		ulaznaFaktura.datumValute = datumF1;	// trebalo bi odraditi za datumValute sve kao i datumFakture...
		*/
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
