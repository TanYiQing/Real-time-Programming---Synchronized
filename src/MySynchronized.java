import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySynchronized {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        int i;
        Task t=new Task();
        System.out.print("Please input i:");
        i=scan.nextInt();
        t.setStartPoint(i);

        System.out.println();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        executorService1.execute(t);
        executorService2.execute(t);
        executorService3.execute(t);
        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Total = "+ t.getCount());
    }
}

class Task implements Runnable{
    private static int i;
    private static int count;

    @Override
    public void run() {
        for(int j=1;j<=i;j++){
            System.out.println(Thread.currentThread().getName()+": "+j);
            count();
        }
    }

    public void setStartPoint(int i){
        Task.i =i;
    }

    public int getCount(){
        return count;
    }

    private static synchronized void count(){
        count++;
    }

}







