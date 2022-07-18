import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService execute = Executors.newFixedThreadPool(4);
        MyThread myThread =new MyThread();
        execute.execute(myThread);

    }
}