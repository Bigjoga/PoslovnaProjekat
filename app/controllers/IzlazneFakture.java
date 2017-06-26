package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import models.IzlaznaFaktura;
import models.PoslovnaGodina;
import models.PoslovniPartner;
import play.mvc.Controller;
import xmlModels.Family2;
import xmlModels.IzlazneFaktureExport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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
	
	public static void edit(IzlaznaFaktura izlaznaFaktura, Long poslovniPartner)
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
		izlaznaFaktura.poslovniPartner = partner;
		izlaznaFaktura.save();
		show("edit",izlaznaFaktura.id);
	}
	
	public static void delete(Long id)
	{
		IzlaznaFaktura izlFaktura = IzlaznaFaktura.findById(id);
		izlFaktura.delete();
		show("edit", izlFaktura.id-1);
	}
	
	public static void filter(IzlaznaFaktura izlaznaFaktura)
	{
		List<IzlaznaFaktura> izlFaktura = IzlaznaFaktura.find("byBrojFaktureLike"/*, "%"+bank1.sifra+"%"*/, "%"+izlaznaFaktura.brojFakture+"%").fetch();
		String mode = "edit";
		renderTemplate("IzlazneFakture/show.html", izlFaktura, mode);
	}
	
}



























