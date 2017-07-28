public class Animal {
    int numberOfLegs; // <---instance variables
    String name;

public Animal (String name) { // <--- constructor definition
    this.name = name;        // <--- "this" is a special word referring to the instance
}
    public String greet() { // <--- instance method
        return "Hi, I'm " + name;
    }
}
