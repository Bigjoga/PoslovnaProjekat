package xmlModels;
import java.io.File;
import java.sql.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    
	public static void main(String[] args) throws Exception {
    	
        JAXBContext jc = JAXBContext.newInstance(FosterHome.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        FosterHome fosterHome = (FosterHome) unmarshaller.unmarshal(new File("xmlModels\\proba.txt"));

        
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.marshal(fosterHome, System.out);
        
        
        for(int i =0; i<fosterHome.getFamilies().size();i++){ 
	        System.out.println(fosterHome.getFamilies().get(i).getDatumIzvoda());
	        System.out.println(fosterHome.getFamilies().get(i).getNovoStanje());
	        System.out.println(fosterHome.getFamilies().get(i).getPrethodnoStanje());
	        System.out.println(fosterHome.getFamilies().get(i).getRezervisano());
	        System.out.println(fosterHome.getFamilies().get(i).getStanjeNaTeret());
	        System.out.println(fosterHome.getFamilies().get(i).getStanjeUKorist());
	        System.out.println(fosterHome.getFamilies().get(i).getRacun());
	        System.out.println("------------------------------------------------>>");
        }
        
        
        
		 
		 /*
		 Date datum= java.sql.Date.valueOf("2017-06-24");
		 System.out.println(datum);
		 */
		 
		
    }

}