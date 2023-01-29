package MultiThreading;

public class RunnableThread implements Runnable {

    private int[] array;

    public RunnableThread(int[] array) {
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
