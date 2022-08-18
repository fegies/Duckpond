public class Duck {
    static int id_source = 0;
    int id;
    int weight = 7;

    public Duck() {
        id = id_source++;
    }

    void eat(Fish prey) {
        System.out.println("Fish " + prey.id + " was eaten by duck " + id);
        prey.die();
        weight++;
    }

	boolean has_starved() {
		return weight <= 5;
	}
	boolean can_reproduce() {
		return weight > 10;
	}

    public void burn_calories() {
        weight -= 2;
    }

    public String toString() {
        return "Duck " + id + ", Weight: " + weight;
    }

	public Duck reproduce() {
		System.out.println("Duck " + id + " produced a new duck!");
		burn_calories();
		return new Duck();
	}
}
