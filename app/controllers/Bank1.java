package controllers;

import java.util.List;

import models.Banka1;
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
	
}
