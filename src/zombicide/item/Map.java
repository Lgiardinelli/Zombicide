package zombicide.item;

import zombicide.city.City;

public class Map implements Item {
	public boolean isNoisy = true;

	private City board;

	public Map(City c) {
		this.board = c;
	}

	public String toString(){
		return "map";
	}

	@Override
	public void use() {

	}
}
