package zombicide.item;

import zombicide.actor.survivor.Survivor;
import zombicide.city.City;

public class Map implements Item {
	public boolean isNoisy = true;

	private Survivor survivor;

	public Map(Survivor s) {
		this.survivor = s;
	}

	public String toString(){
		return "map";
	}

	@Override
	public void use() {
		City city = this.survivor.getCity();
		city.display();
	}
}
