package controllers;

import java.util.List;

import models.IzlaznaFaktura;
import models.PoslovnaGodina;
import models.PoslovniPartner;
import models.StavkaIzvoda;
import models.ZatvaranjeIzlazneFakture;
import play.mvc.Controller;

public class ZatvaranjeIzlaznihFaktura  extends Controller{
	
	
	public static void show(String mode, Long selectedIndex)
	{
		List<IzlaznaFaktura> izlaznafaktura = IzlaznaFaktura.findAll();
		List<StavkaIzvoda> stavka = StavkaIzvoda.findAll();
		List<ZatvaranjeIzlazneFakture> zatvaranje = ZatvaranjeIzlazneFakture.findAll();	
		
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(zatvaranje,stavka,izlaznafaktura, mode,selectedIndex);
	}
	
	public static void delete(Long id)
	{
		ZatvaranjeIzlazneFakture izlazna=ZatvaranjeIzlazneFakture.findById(id);
		izlazna.delete();
		show("edit", izlazna.id-1);
	}
	

}
