import java.util.ArrayList;

public class MyThread extends Thread {
    private ArrayList<Integer> doubleNum = new ArrayList<>();
    private ArrayList<Integer> singleNum = new ArrayList<>();
    private ArrayList<Integer> numbers = new ArrayList<>();


    public MyThread() {

        for(int i=1;i<=100;i++){
            this.numbers.add(i);
        }
    }

    @Override
    public void run() {
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)%2==0){
                doubleNum.add(numbers.get(i));
            }else {
                singleNum.add(numbers.get(i));
            }
        }
        printDoubleNum();
        printSingleNum();

    }
    public synchronized void printDoubleNum(){
        System.out.println(this.doubleNum);
    }
    public synchronized void printSingleNum(){
        System.out.println(this.singleNum);
    }
}
