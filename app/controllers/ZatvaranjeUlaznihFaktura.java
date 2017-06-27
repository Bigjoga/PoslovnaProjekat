package controllers;

import java.util.List;

import models.IzlaznaFaktura;
import models.StavkaIzvoda;
import models.UlaznaFaktura;
import models.ZatvaranjeIzlazneFakture;
import models.ZatvaranjeUlazneFakture;
import play.mvc.Controller;

public class ZatvaranjeUlaznihFaktura  extends Controller{
	
	public static void show(String mode, Long selectedIndex)
	{
		List<UlaznaFaktura> ulazna = UlaznaFaktura.findAll();
		List<StavkaIzvoda> stavka = StavkaIzvoda.findAll();
		List<ZatvaranjeUlazneFakture> zatvaranje = ZatvaranjeUlazneFakture.findAll();	
		
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(zatvaranje,stavka,ulazna, mode,selectedIndex);
	}

	
	public static void delete(Long id)
	{
		ZatvaranjeUlazneFakture izlazna=ZatvaranjeUlazneFakture.findById(id);
		izlazna.delete();
		show("edit", izlazna.id-1);
	}
	
}
