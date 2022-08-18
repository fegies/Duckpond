
public class Fish {
	static int id_source =0;
	int id;
	public Pond pond;
	
	public Fish(Pond pond){
		id= id_source++;
		this.pond = pond;
	}

	public void die() {
		pond.all_fish.remove(this);
	}
	public String toString() {
		return "Fish "+id;
	}
	

}
