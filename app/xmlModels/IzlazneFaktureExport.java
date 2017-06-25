package xmlModels;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import play.db.jpa.JPABase;
import models.IzlaznaFaktura;

@XmlRootElement(name = "IzlaznaFakturaXML")
@XmlAccessorType (XmlAccessType.FIELD)
public class IzlazneFaktureExport {

	@XmlElementWrapper(name="IzlazneFaktureExport")
	@XmlElement(name="IzlaznaFaktura")
    public List<IzlaznaFaktura> izlaznaFaktura;

	public List<IzlaznaFaktura> getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(List<IzlaznaFaktura> izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}
}
