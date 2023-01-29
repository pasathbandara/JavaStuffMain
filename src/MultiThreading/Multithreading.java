package MultiThreading;

public class Multithreading {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        //System.out.println(5/0);

        Thread myThread = new MyThread("myThread", new int[]{1, 2, 3, 4});
        System.out.println(myThread.getPriority());
        myThread.start();


        Thread myOtherThread = new MyThread("myOtherThread", new int[]{5, 6, 7, 8});
        System.out.println(myOtherThread.getPriority());
        myOtherThread.start();


        Runnable runnableThread = new RunnableThread(new int[]{13, 14, 15, 16});
        Thread thread = new Thread(runnableThread, "thread");
        System.out.println(thread.getPriority());
        thread.start();


        int[] anotherArray = {9, 10, 11, 12};
        for (int i : anotherArray) {
            System.out.println("Thread name : " + Thread.currentThread().getName() + "  :  " + i);
            System.out.println(myThread.getPriority());
            System.out.println("");
            Thread.sleep(200);
        }
    }
}
