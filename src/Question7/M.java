//package Question7;
//
//public class M {
//    int x;
//    static int y = 1;
//    M(int x){
//        this.x = x;
//        ++y;
//    }
//}
//Class StaticQ12{
//public static void main(String[]args){
//        M m1 = new M(10);
//        M m2 = new M(20);
//
//        m2.y++;
//        m1.x++;
//
//        System.out.println(m1.x+ " "+ m2.x+ " "+ m1.y+" "+m2.y);
//
//        }
//        }

/*This code creates two instances of the class M, m1 and m2, with the constructor being passed values of 10 and 20
respectively for the instance variable x. The static variable y is incremented by 1 each time a new instance of M is
created, so its value is 2 after m1 and m2 are created. Then the value of the instance variable x of m1 is
incremented by 1, and the static variable y of m2 is incremented by 1. When the values of x, y, m1, and m2 are
printed, the output will be "11 20 2 3".*/


