import java.util.ArrayList;
import java.util.List;

enum PizzaSize{
    SMALL, MEDIUM, LARGE, EXTRALARGE
}
enum PizzaCrust
{
    THIN, THICK, SQUARE, CRISPY
}
class Pizza
{
    private final PizzaSize pizzaSize;
    private final PizzaCrust pizzaCrust;
    private final List<String> toppings;
    private final boolean cheese;
    private final boolean sauce;

    private Pizza(Builder builder)
    {
        this.pizzaSize=builder.pizzaSize;
        this.pizzaCrust=builder.pizzaCrust;
        this.toppings=builder.toppings;
        this.cheese=builder.cheese;
        this.sauce=builder.sauce;
    }

    @Override
    public String toString()
    {
                StringBuilder sb = new StringBuilder();
                sb.append("Pizza{")
                    .append("size=").append(pizzaSize)
                    .append(", crust=").append(pizzaCrust)
                    .append(", toppings=");
                if (toppings == null || toppings.isEmpty()) {
                        sb.append("[]");
                } else {
                        sb.append(toppings);
                }
                sb.append(", cheese=").append(cheese)
                    .append(", sauce=").append(sauce)
                    .append("}");
                return sb.toString();
    }

    static class Builder
    {
        PizzaSize pizzaSize;
        PizzaCrust pizzaCrust;
        List<String> toppings;
        boolean cheese;
        boolean sauce;

        public Builder()
        {
            // default values
            toppings=new ArrayList<>();
            cheese=false;
            sauce=false;
        }
        public Builder withPizzaSize(PizzaSize pizzaSize)
        {
            this.pizzaSize=pizzaSize;
            return this;
        }

        public Builder withPizzaCrust(PizzaCrust pizzaCrust)
        {
            this.pizzaCrust=pizzaCrust;
            return this;
        }

        public Builder withToppings(String topping)
        {
            this.toppings.add(topping);
            return this;
        }

        public Builder withCheese(boolean cheese)
        {
            this.cheese=cheese;
            return this;
        }

        public Builder withSauce(boolean sauce)
        {
            this.sauce=sauce;
            return this;
        }

        public Pizza build()
        {
            return new Pizza(this);
        }
    }
}
public class PizzaOrderingSystem {
    public static void main(String args[])
    {
        Pizza pizza=new Pizza.Builder()
                        .withPizzaSize(PizzaSize.EXTRALARGE)
                        .withPizzaCrust(PizzaCrust.THIN)
                        .withToppings("olives")
                        .withToppings("corn")
                        .withToppings("mushroom")
                        .withCheese(true)
                        .withSauce(false)
                        .build();
        System.out.println(pizza);
    }
}
