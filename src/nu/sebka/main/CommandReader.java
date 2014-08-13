package nu.sebka.main;

import java.awt.event.KeyEvent;

import nu.sebka.instances.turrets.BlasterTurret;
import nu.sebka.instances.turrets.LaserTurret;
import nu.sebka.instances.turrets.Turret;
import nu.sebka.instances.turrets.WaterTurret;

public class CommandReader {
	public static boolean read(String input){
		String command = input.replace(">", "").replace("\n", "");
		String[] args = command.split(" ");

		if(args[0].equalsIgnoreCase("buy")){
			if(args[1].equalsIgnoreCase("laserturret")){
				if(Game.money >= PriceList.laserturret){
					Game.boughtObject = new LaserTurret(0,0);
					Game.money -= PriceList.laserturret;
					return false;
				}else{Terminal.write("NOT ENOUGH MONEY"); return true;}
			}
			else if(args[1].equalsIgnoreCase("waterturret")){
				if(Game.money >= PriceList.waterturret){
					Game.boughtObject = new WaterTurret(0,0);
					Game.money -= PriceList.waterturret;
					return false;
				}else{Terminal.write("NOT ENOUGH MONEY"); return true;}
			}
			else if(args[1].equalsIgnoreCase("blasterturret")){
				if(Game.money >= PriceList.blasterturret){
					Game.boughtObject = new BlasterTurret(0,0);
					Game.money -= PriceList.blasterturret;
					return false;
				}else{Terminal.write("NOT ENOUGH MONEY"); return true;}
			}
		}
		else if(args[0].equalsIgnoreCase("turrets")){
			if(args[1].equalsIgnoreCase("shoot")){
				Turret turret = null;
				for(int i = 0; i < Game.getCurrentScene().instances.size(); i++){
					Instance instance = Game.getCurrentScene().instances.get(i);
					if(instance instanceof Turret){
						turret = (Turret) instance;
						turret.shoot(turret.direction, turret.speed);
					}
				}
				
				if(turret == null){
					Terminal.write("No turrets in scene");
					return true;
				}else{
					return false;
				}
			}
		}
		else if(args[0].equalsIgnoreCase("cheat")){
			if(args[1].equalsIgnoreCase("money")){
				int money = Integer.parseInt(args[2]);
				Game.money += money;
				return false;
			}
		}
		Game.keys[KeyEvent.VK_ENTER] = false;
		Terminal.write("Unknown command.");
		return true;
	}
}
