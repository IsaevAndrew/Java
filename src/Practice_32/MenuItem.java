package Practice_32;

import java.io.Serializable;
public class MenuItem extends Dish implements Serializable {
    private int cost;
    private String name;
    private String description;

    public MenuItem(double cost, String name, String description) {
        super(cost, name, description);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void print() {};
}
