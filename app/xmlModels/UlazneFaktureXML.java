package xmlModels;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import models.UlaznaFaktura;

@XmlRootElement(name="UlazneFaktureXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class UlazneFaktureXML {

	@XmlElementWrapper(name="UlazneFaktureXML")
	@XmlElement(name="UlaznaFaktura")
	public List<UlaznaFaktura> ulazneFakture;

	public List<UlaznaFaktura> getUlazneFakture() {
		return ulazneFakture;
	}

	public void setUlazneFakture(List<UlaznaFaktura> ulazneFakture) {
		this.ulazneFakture = ulazneFakture;
	}
}
