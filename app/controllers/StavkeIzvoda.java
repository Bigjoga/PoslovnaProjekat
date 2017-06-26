package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import models.DnevnoStanje;
import models.PoslovniPartner;
import models.StavkaIzvoda;
import play.mvc.Controller;
import xmlExport.StavkaIzvodaExport;
import xmlExport.ListaStavkiIzvodaExport;

public class StavkeIzvoda extends Controller{

	public static void show(String mode, Long selectedIndex)
	{
		List<PoslovniPartner> poslovniPartner = PoslovniPartner.findAll();
		List<DnevnoStanje> dnevnoStanje = DnevnoStanje.findAll();
		List<StavkaIzvoda> stavkaIzvoda = StavkaIzvoda.findAll();
		
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(stavkaIzvoda, poslovniPartner, dnevnoStanje, mode, selectedIndex);
	}
	
	
	public static void exportXML(){
		
		
		ArrayList<StavkaIzvodaExport> sveStavke= new ArrayList<StavkaIzvodaExport>();
		List<StavkaIzvoda> stavka= StavkaIzvoda.findAll();
		
		for(int i=0; i<stavka.size();i++){
			System.out.println(stavka.get(i).brojStavke.toString());
			
			DnevnoStanje ds= DnevnoStanje.findById(stavka.get(i).dnevnoStanje.id);
			System.out.println(ds.datumIzvoda.toString());
			
			PoslovniPartner pp= PoslovniPartner.findById(stavka.get(i).poslovniPartner.id);
			System.out.println(pp.preduzece.naziv);
			
			
			StavkaIzvodaExport s= new StavkaIzvodaExport(
					ds.datumIzvoda.toString(),
					pp.preduzece.naziv.toString(),
					stavka.get(i).brojStavke, 
					stavka.get(i).DuznikNalagodavac,
					stavka.get(i).svrhaPlacanja, 
					stavka.get(i).PoverilacPrimalac, 
					stavka.get(i).datumPrijema.toString(),
					stavka.get(i).datumValute.toString(),
					stavka.get(i).modelZaduzenja, 
					stavka.get(i).pozivNaBrojZaduzenja, 
					stavka.get(i).racunPoverioca,
					stavka.get(i).modelOdobrenja,
					stavka.get(i).pozivNaBrojOdobrenja,
					stavka.get(i).hitno, 
					stavka.get(i).iznos,
					stavka.get(i).tipGreske, 
					stavka.get(i).status);
					
			sveStavke.add(s);
		}
		
		
		ListaStavkiIzvodaExport epl= new ListaStavkiIzvodaExport();
		epl.setEmployees(sveStavke);
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ListaStavkiIzvodaExport.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the employees list in console
		    jaxbMarshaller.marshal(epl, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(epl, new File("xmlModels\\export-file.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
