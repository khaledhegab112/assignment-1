import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
    private String name;
    private ArrayList<MenuItem> menuItems;
    private ArrayList<MenuItem> orders;

    public CoffeeShop(String name, ArrayList<MenuItem> menuItems, ArrayList<MenuItem> orders) {
        this.name = name;
        this.menuItems = menuItems;
        this.orders = orders;
    }

    public String addOrder(String itemName) {
        for (MenuItem item : menuItems) {
            if (itemName.equals(item.itemName)) {
                orders.add(item);
                return item.itemName + " added to orders";
            }
        }
        return "This item is currently unavailable";
    }

    public String fulfillOrder() {
        if (!orders.isEmpty()) {
            return "The " + orders.get(0).itemName + " is ready";
        } else {
            return "All orders have been fulfilled";
        }
    }

    public List<MenuItem> listOrders() {
        return orders;
    }

    public double dueAmount() {
        double total = 0;
        for (MenuItem i : orders) {
            total += i.price;
        }
        return total;
    }

    public String cheapestItem() {
        MenuItem minimum = menuItems.get(0);
        for (MenuItem i : menuItems) {
            if (i.price < minimum.price) {
                minimum = i;
            }
        }
        return minimum.itemName;
    }

    public List<String> drinksOnly() {
        ArrayList<String> drinks = new ArrayList<>();
        for (MenuItem i : menuItems) {
            if (i.type.equals("drink")) {
                drinks.add(i.itemName);
            }
        }
        return drinks;
    }

    public List<String> foodOnly() {
        List<String> food = new ArrayList<>();
        for (MenuItem i : menuItems) {
            if (i.type.equals("food")) {
                food.add(i.itemName);
            }
        }
        return food;
    }
}

class MenuItem {
    String itemName;
    String type;
    double price;

    public MenuItem(String itemName, String type, double price) {
        this.itemName = itemName;
        this.type = type;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}