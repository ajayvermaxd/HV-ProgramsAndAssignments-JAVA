import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Order {
    private static int orderIdCounter = 1;
    private int orderId;
    private List<OrderItem> items;
    private String status;

    public Order() {
        this.orderId = orderIdCounter++;
        this.items = new ArrayList<>();
        this.status = "Received";
    }

    public void addItem(MenuItem menuItem, int quantity) {
        items.add(new OrderItem(menuItem, quantity));
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class Restaurant {
    List<Order> orders;
    Map<String, MenuItem> menu;

    public Restaurant() {
        this.orders = new ArrayList<>();
        this.menu = new HashMap<>();
        initializeMenu();
    }

    public void receiveOrder(Order order) {
        orders.add(order);
    }

    public void prepareOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.setStatus("Preparing");
                break;
            }
        }
    }

    public void completeOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.setStatus("Ready for Pickup/Delivery");
                break;
            }
        }
    }

    public void displayMenu() {
        for (Map.Entry<String, MenuItem> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue().getPrice());
        }
    }

    private void initializeMenu() {
        menu.put("Burger", new MenuItem("Burger", 8.99));
        menu.put("Pizza", new MenuItem("Pizza", 10.99));
        menu.put("Pasta", new MenuItem("Pasta", 12.99));
        // Add more menu items here
    }
}

public class ManagerRole {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Order order1 = new Order();
        order1.addItem(restaurant.menu.get("Burger"), 2);
        order1.addItem(restaurant.menu.get("Pizza"), 1);
        restaurant.receiveOrder(order1);

        Order order2 = new Order();
        order2.addItem(restaurant.menu.get("Pasta"), 3);
        restaurant.receiveOrder(order2);

        // Simulate order processing
        restaurant.prepareOrder(1);
        restaurant.completeOrder(1);

        restaurant.prepareOrder(2);
        restaurant.completeOrder(2);

        System.out.println("Orders:");
        for (Order order : restaurant.orders) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Items:");
            for (OrderItem item : order.getItems()) {
                System.out.println(item.getMenuItem().getName() + " x" + item.getQuantity());
            }
            System.out.println("------------------------");
        }
    }
}
