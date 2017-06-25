package xmlModels;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FosterHome")
@XmlAccessorType(XmlAccessType.FIELD)
public class FosterHome {

    

    @XmlElementWrapper(name="spisakDnevhihStanja")
    @XmlElement(name="DnevnoStanje")
    private List<Family> families;
    
    @XmlElementWrapper(name="spisakUlaznihFaktura")
    @XmlElement(name="UlaznaFaktura")
    private List<Family1> families1;
    
	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	public List<Family1> getFamilies1() {
		return families1;
	}

	public void setFamilies1(List<Family1> families1) {
		this.families1 = families1;
	}
}