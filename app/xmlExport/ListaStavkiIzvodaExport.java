package xmlExport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listaStavkiIzvoda")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListaStavkiIzvodaExport 
{
    @XmlElement(name = "stavkaIzvoda")
    private List<StavkaIzvodaExport> employees = null;
 
    public List<StavkaIzvodaExport> getEmployees() {
        return employees;
    }
 
    public void setEmployees(List<StavkaIzvodaExport> employees) {
        this.employees = employees;
    }
}