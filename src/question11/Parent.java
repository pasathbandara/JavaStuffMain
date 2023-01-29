package question11;

public class Parent {
    Parent() {
        System.out.println("Parent");
    }
}

class child extends Parent {
    child() {
        System.out.println("Child ");

    }
}

class GrandChild extends child{
    GrandChild(){
        System.out.println("grand child");
    }
    GrandChild(int x){}
}

class Q14{
    public static void main(String[] args) {
        Parent p = new GrandChild();
        Parent p2 = new GrandChild(5);
        System.out.println();
    }
}
