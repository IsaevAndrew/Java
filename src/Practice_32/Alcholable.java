package Practice_32;

import java.io.Serializable;
 class Alcholable extends Drink implements Serializable {
    public Alcholable(double cost, String name, String description) {
        super(cost, name, description);
    }

    public boolean isAlcoholicDrink(Drink drink) {
        return true;
    }

    public double getAlcoholVol(Drink drink){
        return drink.getAlcoholVol();
    }
}
