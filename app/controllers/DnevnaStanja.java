package controllers;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.DnevnoStanje;
import models.Racun;
import play.mvc.Controller;
import xmlModels.DnevnoStanjeXML;

public class DnevnaStanja extends Controller{

	public static void show(String mode, Long selectedId)
	{
		List<Racun> racuni = Racun.findAll();
		List<DnevnoStanje> dnevnaStanja = DnevnoStanje.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(racuni,dnevnaStanja,mode,selectedId);
	}
	
	public static void create(DnevnoStanje dnevnoStanje, Long racuni)
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
		Racun racunii = Racun.findById(racuni);
		dnevnoStanje.racun = racunii;
		dnevnoStanje.save();
		show("add",dnevnoStanje.id);
	}
	
	public static void importFromXML() throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(DnevnoStanjeXML.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        DnevnoStanjeXML fosterHome = (DnevnoStanjeXML) unmarshaller.unmarshal(new File("xmlModels\\dnevnoStanje.xml"));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(fosterHome, System.out);
	}
}





















