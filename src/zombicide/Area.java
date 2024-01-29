package zombicide;

public abstract class Area {
	
	private int posX;
	private int posY;
//	private List<Survivor> survivors;
//	private List<Zombie> zombies;
	private int noise;
	
	/**
	 * Constructor of area
	 * @param posX - int - the position X of this Cell
	 * @param posY - int - the position Y of this Cell
	 */
	public Area(int posX, int posY) {
		this.posX = posX;
		this.posY = pos		// TODO Auto-generated method stubY;
//		this.survivors = new ArrayList<Survivor>();
//		this.zombies = new Arraylist<Zombie>();
		this.noise = 0;
	}
	
	/**
	 * Get the position X
	 * @return int 
	 */
	public int getX() {
		return this.posX;
	}
	
	/**
	 * Get the position		// TODO Auto-generated method stub Y
	 * @return int 
	 */
	public int getY() {
		return this.posY;
	}
	
	/**
	 * the cell accepts the fight or not
	 * @return true if there can be a fight no otherwise
	 */
	public boolean canFight() {
		return true;
	}

	protected void display() {	
	}
}
