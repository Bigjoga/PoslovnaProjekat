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
	
	public static void XMLexport()
	{
		List<IzlaznaFaktura> listaIzlaznihFaktura = IzlaznaFaktura.findAll();
		ArrayList<Family2> pravaLista = new ArrayList<Family2>();
		
		for(int i=0; i<listaIzlaznihFaktura.size(); i++)
		{
			Family2 fam = new Family2(
					listaIzlaznihFaktura.get(i).brojFakture, 
					listaIzlaznihFaktura.get(i).datumFakture.toString(), 
					listaIzlaznihFaktura.get(i).datumValute.toString(), 
					listaIzlaznihFaktura.get(i).ukupanRabat, 
					listaIzlaznihFaktura.get(i).ukupanIznosBezPDV, 
					listaIzlaznihFaktura.get(i).ukupanPDV, 
					listaIzlaznihFaktura.get(i).ukupnoZaPlacanje, 
					listaIzlaznihFaktura.get(i).preostaliIznos, 
					listaIzlaznihFaktura.get(i).IDfakture, 
					listaIzlaznihFaktura.get(i).poslovnaGodina.godina, 
					listaIzlaznihFaktura.get(i).poslovniPartner.preduzece.naziv);
			
			pravaLista.add(fam);
		}
		
		/*
		IzlazneFaktureExport izlaznaFaktura = new IzlazneFaktureExport();
		//izlaznaFaktura.setIzlaznaFaktura(IzlaznaFaktura.findAll());
		//employees.setEmployees(new ArrayList<Employee>());
		izlaznaFaktura.setIzlaznaFaktura(IzlaznaFaktura.findAll());
		
		System.out.println("----------------------------------------");
		System.out.println(izlaznaFaktura.getIzlaznaFaktura());
		*/
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(IzlaznaFaktura.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			System.out.println("PROSAO ================ 1");
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    System.out.println("PROSAO ================ 2");
		    //Marshal the employees list in console
		    jaxbMarshaller.marshal(pravaLista, System.out);
		    System.out.println("PROSAO ================ 3");
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(pravaLista, new File("xmlModels\\export-file.xml"));
		    System.out.println("PROSAO ================ 4");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}



























