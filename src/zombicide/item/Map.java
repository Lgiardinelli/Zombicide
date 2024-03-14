package zombicide.item;

import zombicide.actor.survivor.Survivor;
import zombicide.city.City;

public class Map implements Item {
	public boolean isNoisy = true;

	private Survivor survivor;

	public Map() {
		this.survivor = null;
	}

	public String toString(){
		return "map";
	}

	public void setSurvivor(Survivor s){
		this.survivor =s;
	}

	@Override
	public void use() {
		City city = this.survivor.getCity();
		System.out.println("Affichage de la map 'Action map' :");
		city.display();
	}
}
