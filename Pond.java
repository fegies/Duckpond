import java.util.ArrayList;

public class Pond {
    ArrayList<Duck> all_ducks = new ArrayList<>();
    ArrayList<Fish> all_fish = new ArrayList<>();

    public Pond(int number_of_ducks, int number_of_fish) {
        for (int i = 0; i < number_of_ducks; i++) {
            all_ducks.add(new Duck());
        }
        for (int i = 0; i < number_of_fish; i++) {
            all_fish.add(new Fish(this));
        }
    }



    void simulate_mealtime(Duck duck) {
        int fish_to_eat = (int) (Math.random() * (all_fish.size() / all_ducks.size()));
        while (fish_to_eat > 0) {
            fish_to_eat--;
            int victimFish = (int) (Math.random() * all_fish.size());
            duck.eat(all_fish.get(victimFish));
        }
    }

    public void simulate_pondlife(int iterations) {
		// to avoid concurrent modification during iteration
        ArrayList<Duck> dead_ducks = new ArrayList<>();
        ArrayList<Duck> new_ducks = new ArrayList<>();

        while (iterations > 0) {
            System.out.println("---------------New Iteration!------------");
            iterations--;
            for (Duck duck : all_ducks) {
                System.out.println(duck);

                simulate_mealtime(duck);
                duck.burn_calories();

                if (duck.has_starved()) {
                    System.out.print("Duck " + duck.id + " has starved");
                    dead_ducks.add(duck);
                }
                else if (duck.can_reproduce())
                    new_ducks.add(duck.reproduce());
            }

            all_ducks.removeAll(dead_ducks);
            dead_ducks.clear();
            all_ducks.addAll(new_ducks);
            new_ducks.clear();

            for (int i = 0; i < 25; i++) {
                all_fish.add(new Fish(this));
            }
            System.out.println("Number of Ducks: " + all_ducks.size());
            System.out.println("Number of Fish: " + all_fish.size());
        }
    }

}

