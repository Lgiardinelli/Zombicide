package zombicide.item;

import zombicide.actor.survivor.Survivor;
import zombicide.util.Direction;

public class MasterKey implements Item {
	public boolean isNoisy = false;

	public Survivor survivor;


	public MasterKey(Survivor s) {
		this.survivor=s;
	}

	public String toString(){
		return "master key";
	}

	@Override
	public void use() {
		for(Direction d : Direction.values()){
			int i = d.getX();
			int j = d.getY();

			int x = survivor.getArea().getX();
			int y = survivor.getArea().getY();


		}
	}
}
