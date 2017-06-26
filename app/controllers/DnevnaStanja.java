package controllers;

import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.DnevnoStanje;
import models.Racun;
import play.mvc.Controller;
import xmlModels.FosterHome;

public class DnevnaStanja extends Controller{

	public static void show(String mode, Long selectedIndex)
	{
		List<Racun> racuni = Racun.findAll();
		List<DnevnoStanje> dnevnaStanja = DnevnoStanje.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(racuni,dnevnaStanja,mode,selectedIndex);
	}
	
	public static void create(DnevnoStanje dnevnoStanje, Long racun)
	{
		validation.required(dnevnoStanje.datumIzvoda);
		validation.required(dnevnoStanje.prethodnoStanje);
		validation.required(dnevnoStanje.stanjeUKorist);
		validation.required(dnevnoStanje.stanjeNaTeret);
		validation.required(dnevnoStanje.novoStanje);
		validation.required(dnevnoStanje.rezervisano);
		validation.maxSize(dnevnoStanje.prethodnoStanje, 20);
		validation.maxSize(dnevnoStanje.stanjeUKorist, 20);
		validation.maxSize(dnevnoStanje.stanjeNaTeret, 20);
		validation.maxSize(dnevnoStanje.novoStanje, 20);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				System.out.println(error.message());
				validation.keep();
				show("add",null);
			}
		}
		
		Racun racuni = Racun.findById(racun);
		dnevnoStanje.racun = racuni;
		dnevnoStanje.save();
		show("add",dnevnoStanje.id);
	}
	
	
	
	public static void importFromXML() throws JAXBException, ParseException{
		JAXBContext jc = JAXBContext.newInstance(FosterHome.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        FosterHome fosterHome = (FosterHome) unmarshaller.unmarshal(new File("xmlModels\\proba.txt"));
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        
        System.out.println("------------------------------>>");
        
        
        for(int j=0;j<fosterHome.getFamilies().size();j++){
        	
        	 System.out.println(fosterHome.getFamilies().get(j).getDatumIzvoda());
             System.out.println(fosterHome.getFamilies().get(j).getNovoStanje());
             System.out.println(fosterHome.getFamilies().get(j).getPrethodnoStanje());
             System.out.println(fosterHome.getFamilies().get(j).getRezervisano());
             System.out.println(fosterHome.getFamilies().get(j).getStanjeNaTeret());
             System.out.println(fosterHome.getFamilies().get(j).getStanjeUKorist());
             System.out.println(fosterHome.getFamilies().get(j).getRacun());
            
             
		        Date datum= java.sql.Date.valueOf(fosterHome.getFamilies().get(j).getDatumIzvoda());
		        Racun rac=null;
		        List<Racun> sviracuni=Racun.findAll();
		        for(int i =0 ;i<sviracuni.size();i++){
		        	
		        	if(sviracuni.get(i).IDracuna.toString().equals(fosterHome.getFamilies().get(j).getRacun().toString()) ){
		        		System.out.println(sviracuni.get(i)+" = " + fosterHome.getFamilies().get(j).getRacun());
		        		rac=sviracuni.get(i);
		        		System.out.println(rac.IDracuna);
		        		
		        		DnevnoStanje ds= new DnevnoStanje
				        		(rac,
				        		datum,
				        		fosterHome.getFamilies().get(j).getPrethodnoStanje(), 
				        		fosterHome.getFamilies().get(j).getStanjeUKorist(),
				        		fosterHome.getFamilies().get(j).getStanjeNaTeret(),
				        		fosterHome.getFamilies().get(j).getNovoStanje(), 
				        		fosterHome.getFamilies().get(j).getRezervisano());
				       
				        ds.save();
				        System.out.println("dodao sam ");
				        
		        	}
		        	
		        }
        }		
        show("add",null);   
	}
}





















