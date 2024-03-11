package zombicide.item;

import zombicide.City;
import zombicide.Door;
import zombicide.action.SurvivorAction;
import zombicide.action.survivor.DoorAction;
import zombicide.actor.survivor.Survivor;
import zombicide.listchooser.RandomListChooser;
import zombicide.util.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MasterKey implements Item {
	public boolean isNoisy = false;

	public Survivor survivor;
	public City city;

	public MasterKey(Survivor s, City c) {
		this.survivor=s;
		this.city = c;
	}

	public String toString(){
		return "master key";
	}

	@Override
	public void use() {
		DoorAction d = new DoorAction(survivor,city);
		d.openTheDoor();
	}


}
