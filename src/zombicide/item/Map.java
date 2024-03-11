package zombicide.item;

import zombicide.city.City;

public class Map implements Item {
	public boolean isNoisy = true;

	private City city;

	public Map(City c) {
		this.city = c;
	}

	public String toString(){
		return "map";
	}

	@Override
	public void use() {
		city.display();
	}
}
