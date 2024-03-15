package zombicide.item;

import zombicide.action.survivor.AreaAction;
import zombicide.actor.survivor.Survivor;
import zombicide.area.Area;
import zombicide.area.room.Room;
import zombicide.city.City;
import zombicide.util.Direction;

public class InfraredGlasses implements Item {
	public boolean isNoisy = false;

	private Survivor survivor;
	public InfraredGlasses() {
		this.survivor = null;
	}

	public String toString(){
		return "infrared glasses";
	}

	public void setSurvivor(Survivor s){
		this.survivor =s;
	}

	@Override
	public void use() {
		displayAreasAround();
	}
	private void displayAreasAround(){
		City city = this.survivor.getCity();
		for(Direction d : Direction.values()){
			System.out.print(d.name()+" :");
			int i = d.getX();
			int j = d.getY();

			int x = survivor.getArea().getX();
			int y = survivor.getArea().getY();

			Area a = city.getAreas()[y+j][x+i];

			a.displayActors();
			System.out.println();
			if(city.isARoom(a)){
				Room r = (Room) a;
				r.displayItems();
			}
			System.out.println();
		}
	}
}
