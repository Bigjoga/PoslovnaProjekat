package controllers;

import java.util.List;

import models.Banka1;
import models.Drzava;
import play.mvc.Controller;

public class Bank1 extends Controller{
	
	public static void show(String mode, Long selectedIndex)
	{
		List<Banka1> banka1 = Banka1.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		render(banka1,mode,selectedIndex);
	}
	
	public static void create(Banka1 banka1)
	{
		banka1.save();
		show("add",banka1.id);
	}	
	
	public static void delete(Long id)
	{
		Banka1 banka = Banka1.findById(id);
		banka.delete();
		show("edit", banka.id-1);
	}
	
	public static void edit(Banka1 banka1)
	{
		banka1.save();
		show("edit",banka1.id);
	}
	
	public static void filter(Banka1 banka1) //OOVO ISPRAVITI
	{
		List<Banka1> bank1 = Banka1.find("bySifraLikeAndNazivLike", "%"+banka1.sifra+"%", "%"+banka1.naziv+"%").fetch();
		String mode = "edit";
		renderTemplate("Bank1/show.html", bank1, mode );
	}
}
