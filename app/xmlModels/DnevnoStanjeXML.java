package xmlModels;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import models.DnevnoStanje;

@XmlRootElement(name="DnevnoStanjeXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class DnevnoStanjeXML {
	
	@XmlElementWrapper(name="DnevnoStanjeXML")
	@XmlElement(name="DnevnoStanje")
	public List<DnevnoStanje> dnevnaStanja;
	
	
	public List<DnevnoStanje> getDnevnaStanja() {
		return dnevnaStanja;
	}

	public void setDnevnaStanja(List<DnevnoStanje> dnevnaStanja) {
		this.dnevnaStanja = dnevnaStanja;
	}
}

