package zombicide.item;

import zombicide.actor.survivor.Survivor;
import zombicide.city.City;

public class Map extends Item {
	public boolean isNoisy = true;

	private Survivor survivor;


	public String toString(){
		return "map";
	}


	public void use() {
		City city = this.survivor.getCity();
		System.out.println("Affichage de la map 'Action map' :");
		city.display();
	}
}
