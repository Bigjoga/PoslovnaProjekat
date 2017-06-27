package controllers;

import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.PoslovnaGodina;
import models.PoslovniPartner;
import models.UlaznaFaktura;
import models.ZatvaranjeUlazneFakture;
import play.mvc.Controller;
import xmlModels.FosterHome;

//SYNC POGLEDATI ZA DATUM FAKTURE I VALUTE!
//SVE OSTALO RADI!

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
	
	public static void create(UlaznaFaktura ulaznaFaktura, Long poslovniPartner, Long poslovnaGodina)
	{
		validation.required(ulaznaFaktura.brojFakture);
		validation.required(ulaznaFaktura.ukupanRabat);
		validation.required(ulaznaFaktura.ukupanIznosBezPDV);
		validation.required(ulaznaFaktura.ukupanPDV);
		validation.required(ulaznaFaktura.ukupnoZaPlacanje);
		validation.required(ulaznaFaktura.preostaliIznos);
		validation.required(ulaznaFaktura.IDfakture);
		validation.maxSize(ulaznaFaktura.brojFakture, 5);
		validation.maxSize(ulaznaFaktura.ukupanRabat, 3);
		validation.maxSize(ulaznaFaktura.ukupanIznosBezPDV, 20);
		validation.maxSize(ulaznaFaktura.ukupanPDV, 3);
		validation.maxSize(ulaznaFaktura.ukupnoZaPlacanje, 20);
		validation.maxSize(ulaznaFaktura.preostaliIznos, 20);
		validation.maxSize(ulaznaFaktura.IDfakture, 25);
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		PoslovniPartner partner = PoslovniPartner.findById(poslovniPartner);
		PoslovnaGodina godina = PoslovnaGodina.findById(poslovnaGodina);
		ulaznaFaktura.poslovniPartner = partner;
		ulaznaFaktura.poslovnaGodina = godina;

		ulaznaFaktura.save();
		show("add",ulaznaFaktura.id);
	}	
	
	public static void edit(UlaznaFaktura ulaznaFaktura, Long poslovniPartner)
	{
		validation.required(ulaznaFaktura.brojFakture);
		validation.required(ulaznaFaktura.ukupanRabat);
		validation.required(ulaznaFaktura.ukupanIznosBezPDV);
		validation.required(ulaznaFaktura.ukupanPDV);
		validation.required(ulaznaFaktura.ukupnoZaPlacanje);
		validation.required(ulaznaFaktura.preostaliIznos);
		validation.required(ulaznaFaktura.IDfakture);
		validation.maxSize(ulaznaFaktura.brojFakture, 5);
		validation.maxSize(ulaznaFaktura.ukupanRabat, 3);
		validation.maxSize(ulaznaFaktura.ukupanIznosBezPDV, 20);
		validation.maxSize(ulaznaFaktura.ukupanPDV, 3);
		validation.maxSize(ulaznaFaktura.ukupnoZaPlacanje, 20);
		validation.maxSize(ulaznaFaktura.preostaliIznos, 20);
		validation.maxSize(ulaznaFaktura.IDfakture, 25);
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
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
	
	public static void pickAFile() throws JAXBException, ParseException{

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML and TXT files", "txt", "xml");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }	

		JAXBContext jc = JAXBContext.newInstance(FosterHome.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        FosterHome fosterHome = (FosterHome) unmarshaller.unmarshal(new File(chooser.getSelectedFile().getPath()));//"xmlModels\\ulazneFakture.txt"));
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+---");
        
        for(int j=0;j<fosterHome.getFamilies1().size();j++){
        	System.out.println(fosterHome.getFamilies1().get(j).getBrojFakture());
        	System.out.println(fosterHome.getFamilies1().get(j).getDatumFakture());
        	System.out.println(fosterHome.getFamilies1().get(j).getDatumValute());
        	System.out.println(fosterHome.getFamilies1().get(j).getUkupanRabat());
        	System.out.println(fosterHome.getFamilies1().get(j).getUkupanIznosBezPDV());
        	System.out.println(fosterHome.getFamilies1().get(j).getUkupanPDV());
        	System.out.println(fosterHome.getFamilies1().get(j).getUkupnoZaPlacanje());
        	System.out.println(fosterHome.getFamilies1().get(j).getPreostaliIznos());
        	System.out.println(fosterHome.getFamilies1().get(j).getIDfakture());
        	System.out.println(fosterHome.getFamilies1().get(j).getPoslovnaGodina());
        	System.out.println(fosterHome.getFamilies1().get(j).getPoslovniPartner());
        	
        	Date datumFakture = java.sql.Date.valueOf(fosterHome.getFamilies1().get(j).getDatumFakture());
        	Date datumValute = java.sql.Date.valueOf(fosterHome.getFamilies1().get(j).getDatumValute());
        	
        	PoslovnaGodina pg = null;
        	PoslovniPartner pp = null;
        	List<PoslovnaGodina> svePoslovneGodine = PoslovnaGodina.findAll();
        	List<PoslovniPartner> sviPoslovniPartneri = PoslovniPartner.findAll();
        	
        	for(int i=0; i<svePoslovneGodine.size();i++){
        		if(svePoslovneGodine.get(i).IDgodine.toString().equals(fosterHome.getFamilies1().get(j).getPoslovnaGodina())){
        			pg=svePoslovneGodine.get(i);
        			System.out.println("pokupio");
        			System.out.println(pg.godina);
        		}
        	}
        	
        	for(int i=0; i<sviPoslovniPartneri.size();i++){
        		if(sviPoslovniPartneri.get(i).id.toString().equals(fosterHome.getFamilies1().get(j).poslovniPartner)){
        			pp=sviPoslovniPartneri.get(i);
        			System.out.println("pokupio");
        			System.out.println(pp.preduzece);
        		}
        		
        		
        	}
        	
        	UlaznaFaktura ul= new UlaznaFaktura(
        			pg,
        			pp, 
        			fosterHome.getFamilies1().get(j).getIDfakture(), 
        			datumFakture, 
        			datumValute, 
        			fosterHome.getFamilies1().get(j).getUkupanRabat(), 
        			fosterHome.getFamilies1().get(j).getUkupanIznosBezPDV(), 
        			fosterHome.getFamilies1().get(j).getUkupanPDV(), 
        			fosterHome.getFamilies1().get(j).getUkupnoZaPlacanje(), 
        			fosterHome.getFamilies1().get(j).getPreostaliIznos(), 
        			fosterHome.getFamilies1().get(j).getIDfakture().toString());
        	
        	ul.save();       	
        }
        show("add", null);
	}
	
	public static void zatvaranje(UlaznaFaktura ulaznaFaktura, Long poslovniPartner){
		
		
		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
	    Date datumFakture = java.sql.Date.valueOf(timeNow.toString());
	    
		ZatvaranjeUlazneFakture zatvaranje= new ZatvaranjeUlazneFakture(datumFakture, ulaznaFaktura);
				
		System.out.println("-------------------------->>");
		System.out.println(zatvaranje.ulaznaFaktura.IDfakture);
		
		
		zatvaranje.save();
		show("zatvaranje", null);
		
		
	}
	/*
	public static void importFromXML() throws JAXBException, ParseException{
		JAXBContext jc = JAXBContext.newInstance(FosterHome.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        FosterHome fosterHome = (FosterHome) unmarshaller.unmarshal(new File("xmlModels\\ulazneFakture.txt"));
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+---");
        
        for(int j=0;j<fosterHome.getFamilies1().size();j++){
        	System.out.println(fosterHome.getFamilies1().get(j).getBrojFakture());
        	System.out.println(fosterHome.getFamilies1().get(j).getDatumFakture());
        	System.out.println(fosterHome.getFamilies1().get(j).getDatumValute());
        	System.out.println(fosterHome.getFamilies1().get(j).getUkupanRabat());
        	System.out.println(fosterHome.getFamilies1().get(j).getUkupanIznosBezPDV());
        	System.out.println(fosterHome.getFamilies1().get(j).getUkupanPDV());
        	System.out.println(fosterHome.getFamilies1().get(j).getUkupnoZaPlacanje());
        	System.out.println(fosterHome.getFamilies1().get(j).getPreostaliIznos());
        	System.out.println(fosterHome.getFamilies1().get(j).getIDfakture());
        	System.out.println(fosterHome.getFamilies1().get(j).getPoslovnaGodina());
        	System.out.println(fosterHome.getFamilies1().get(j).getPoslovniPartner());
        	
        	Date datumFakture = java.sql.Date.valueOf(fosterHome.getFamilies1().get(j).getDatumFakture());
        	Date datumValute = java.sql.Date.valueOf(fosterHome.getFamilies1().get(j).getDatumValute());
        	
        	PoslovnaGodina pg = null;
        	PoslovniPartner pp = null;
        	List<PoslovnaGodina> svePoslovneGodine = PoslovnaGodina.findAll();
        	List<PoslovniPartner> sviPoslovniPartneri = PoslovniPartner.findAll();
        	
        	for(int i=0; i<svePoslovneGodine.size();i++){
        		if(svePoslovneGodine.get(i).IDgodine.toString().equals(fosterHome.getFamilies1().get(j).getPoslovnaGodina())){
        			pg=svePoslovneGodine.get(i);
        			System.out.println("pokupio");
        			System.out.println(pg.godina);
        		}
        	}
        	
        	for(int i=0; i<sviPoslovniPartneri.size();i++){
        		if(sviPoslovniPartneri.get(i).id.toString().equals(fosterHome.getFamilies1().get(j).poslovniPartner)){
        			pp=sviPoslovniPartneri.get(i);
        			System.out.println("pokupio");
        			System.out.println(pp.preduzece);
        		}
        		
        		
        	}
        	
        	UlaznaFaktura ul= new UlaznaFaktura(
        			pg,
        			pp, 
        			fosterHome.getFamilies1().get(j).getIDfakture(), 
        			datumFakture, 
        			datumValute, 
        			fosterHome.getFamilies1().get(j).getUkupanRabat(), 
        			fosterHome.getFamilies1().get(j).getUkupanIznosBezPDV(), 
        			fosterHome.getFamilies1().get(j).getUkupanPDV(), 
        			fosterHome.getFamilies1().get(j).getUkupnoZaPlacanje(), 
        			fosterHome.getFamilies1().get(j).getPreostaliIznos(), 
        			fosterHome.getFamilies1().get(j).getIDfakture().toString());
        	
        	ul.save();
    		
        	
        }
        show("add", null);
	}
	*/

}













