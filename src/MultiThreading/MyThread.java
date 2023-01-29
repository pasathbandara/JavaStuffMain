package MultiThreading;

public class MyThread extends Thread {


    private int[] array;

    public MyThread(String name, int[] array) {

        super(name);
        this.array = array;
    }

    @Override
    public void run() {
        for (int i : array) {

            System.out.println("Thread name : " + Thread.currentThread().getName() + " " + "Square of i : " + Math.pow(i, 2));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
