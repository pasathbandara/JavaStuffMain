package test;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        System.out.print("Dog before: ");
        dog.makeSound();
        System.out.print("Cat before: ");
        cat.makeSound();

        Animal temp;
        temp = dog;
        dog = cat;
        cat = temp;

        System.out.print("Dog After: ");
        dog.makeSound();
        System.out.print("Cat After: ");
        cat.makeSound();

    }

}
