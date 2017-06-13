package controllers;

import models.DnevnoStanje;
import models.Racun;
import play.mvc.Controller;

import java.util.List;

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
		Racun racunii = Racun.findById(racuni);
		dnevnoStanje.racun = racunii;
		dnevnoStanje.save();
		show("add",dnevnoStanje.id);
	}
}
