package zombicide.item;

import zombicide.City;
import zombicide.Door;
import zombicide.actor.survivor.Survivor;
import zombicide.util.Direction;

import java.util.List;

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

	}

	public List<Door> doorsArround(){
		for(Direction d : Direction.values()){
			int i = d.getX();
			int j = d.getY();

			int x = survivor.getArea().getX();
			int y = survivor.getArea().getY();

			int rx = d.getReversex();
			int ry = d.getReversey();


		}
	}
}
