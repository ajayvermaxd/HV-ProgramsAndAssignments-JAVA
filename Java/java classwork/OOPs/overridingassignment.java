package OOPs;
// //This Java program is a menu management system for a restaurant. 

// //It demonstrates object-oriented programming concepts such as inheritance, method overriding, and encapsulation to model a simple menu with dishes and beverages. The code is structured with base classes and subclasses to represent different types of menu items. 

// `MenuItem` class: 
// This is the base class for all menu items. 
// It encapsulates common properties such as the name and price of the item. 
// The `display()` method in this class provides a basic way to show item information.

// Dish class:
// A subclass of `MenuItem`, representing food dishes on the restaurant's menu. 
// It adds an extra property, `cuisineType`, to specify the type of cuisine the dish belongs 
// to. The `display()` method is overridden to provide detailed information about a dish, including its name, price, and cuisine type.

// Beverage class:
// Another subclass of `MenuItem`, representing beverages on the menu. 
// It includes a property `isAlcoholic` to indicate if the beverage is alcoholic or non-alcoholic. 
// The `display()` method in this class is also overridden to provide specific details about the beverage.

// The `overridingassignment` class serves as the entry point. 
// In the `main()` method, you can use the provided static methods in `Dish` and `Beverage` classes to create instances of these items and display their information using the `display()` method.
//  The goal of this code is to encourage understanding of inheritance and method overriding 
//  in a restaurant menu context.

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) { // Changed private to public as constructor is always public
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println("Item: " + name + " | Price: Rs." + price);
    }
}

class Dish extends MenuItem {
    private String cuisineType;

    public Dish(String name, double price, String cuisineType) { // Constructor name should be same as class name
        super(name, price); // call the baseclass constructor using super
        this.cuisineType = cuisineType; // to assign data to same class use this operator
    }

    public String getCuisineType() {
        return cuisineType;
    }

    @Override
    public void display() {
        // super.display(); // Calling superclass display method
        System.out.println(
                "Item: " + super.getName() + " | Price: Rs." + super.getPrice() + "|" + "Cuisine Type: " + cuisineType); // Customizing
                                                                                                                         // the
                                                                                                                         // display
                                                                                                                         // for
                                                                                                                         // Dish
                                                                                                                         // class
    }

}

class Beverage extends MenuItem { // add the name of base class
    private boolean isAlcoholic;

    public Beverage(String name, double price, boolean isAlcoholic) { // Changed private to public same as above
        super(name, price); // call the baseclass constructor using super
        this.isAlcoholic = isAlcoholic;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    @Override
    public void display() {
        super.display(); // Calling base class display method
        System.out.println("Alcoholic: " + (isAlcoholic ? "Yes" : "No")); // Hint: Customize the display for Beverage
    }
}

public class overridingassignment {
    public static void main(String[] args) {
        // Using the static methods to create and display instances
        Dish dish = new Dish("Pao Bhaji", 50.0, "Indian");
        Beverage beverage = new Beverage("Aam Ras", 20.0, false);
        dish.display();
        beverage.display();
    }
}
