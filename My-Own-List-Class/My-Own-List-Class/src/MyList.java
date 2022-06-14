import java.util.Scanner;

public class MyList <T>{

    private T[] array;
    private int size;
    private int capacity;


    public MyList() {
        // Default Constructor
        //Dizinin var sayılan başlangıç boyutu
        this.capacity = 10;

        /* Objectclass, tüm Java sınıflarının üst sınıfıdır.
        Tüm Java sınıfları bu sınıftan miras alınır. Bu,tüm Java sınıflarında
        bulunan yöntemlere sahip olmamızı mümkün kılar.
        Object sınıfı ile array nesnesi ürettik.*/

        this.array = (T[]) new Object[this.capacity];
    }

    public MyList(int capacity) {

        //Dizinin başlangıç değeri capacity parametresinden alınır.
        // Constructor with initial capacity

        this.capacity = capacity;
        this.array = (T[]) new Object[this.capacity];
    }

    public T add(T date){

        //sınıfa ait diziye eleman eklemek için kullanılmalıdır.
        // Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.


        if(size() != this.capacity-1) {
            //Diziye yeni eleman ekleniyor.
            array[size]=date;
        }else {
            int length=this.capacity;


            this.capacity = 2*capacity; //Kapasite 2 Katina çıkıyor.

            T[] backup = (T[]) new Object[length]; //Yedek dizi oluşturuluyor.

            //yedek diziye kopyalanıyor.
            for(int l=0; l<length-1; l++){
                backup[l]=array[l];
            }


            this.array = (T[]) new Object[this.capacity]; //Dizinin kapasitesi yenileniyor.

            //Kapasitesi yenilenmiş diziye eski veriler kopyalanıyor.
            for(int l=0; l<length-1; l++){
                array[l]=backup[l];
            }


            array[size()]=date; //Diziye yeni eleman ekleniyor.

        }
        return date;
    }

    public int size(){

        //dizideki eleman sayısını verir.
        int count = 0;
        for (int k=0 ; k<=capacity-1 ; k++){
            if(array[k] != null){
                count++;
            }
        }
        this.size=count;
        return this.size;
    }

    public int getCapacity(){
        //dizinin kapasite değerini verir.
        return this.capacity;
    }

    public T get(int index){
        //verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.

        if(index >= 0 && index < size()) {
            return this.array[index];
        }
        else {
            return null;
        }
    }

    public T remove(int index){
        //verilen indisteki veriyi silmeli ve silinen indis sonrasında
        // ki verileri sol doğru kaydırmalı. Geçersiz indis girilerse null döndürür.


        if(index >= 0 && index < size()) {

            for (int i = index; i < size() ; i++) {
                this.array[index] = array[index + 1];


            }
          return array[index];

        }else{
         return null;
        }
    }

    public T set(int index, T data){
        //verilen indisteki veriyi yenisi ile değiştirme
        // işlemini yapmalıdır. Geçersiz indis girilerse null döndürür.
        if(index >= 0 && index < size()) {
            return array[index]=data;
        }else {
            return null;
        }

    }
    @Override
    public String toString(){
        //Sınıfa ait dizideki elemanları listeleyen bir metot.
        System.out.print("[");
        for(int p=0; p<size();p++){
            System.out.print(array[p]);
            if(p<size-1){
                System.out.print(",");
            }
        }return "]";
    }

    public int indexOf(T data){
        //Parametrede verilen nesnenin
        // listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.
            boolean isResult=false;
            int x=0;
            for (int k = 0; k < size() - 1; k++) {
                if (array[k] == data) {
                    isResult=true;
                    x=k;
                    break;
                }
            }
            if(isResult){
                return x;
            }else {
                return -1;
            }

    }

    public int lastIndexOf(T data){
        //Belirtilen öğenin listedeki son indeksini söyler.
        // Nesne listede yoksa -1 değerini verir.
        boolean isResult=false;
        int x=0;
        for (int k = size()-1; 0 <= k; k--) {
            if (array[k] == data) {
                isResult=true;
                x=k;
                break;
            }
        }
        if(isResult){
            return x;
        }else {
            return -1;
        }

    }

    public boolean isEmpty(){
        //Listenin boş olup olmadığını söyler.

        if(size()==0){

            return true;
        }else {

            return false;
        }

    }
    public T[] toArray(){
        //Listedeki öğeleri, aynı sırayla bir array haline getirir.

        T[] array2 = (T[]) new Object[this.capacity];
        for(int l=0; l<capacity; l++){
            array2[l]=array[l];
        }
        return array2;
    }

    public void clear(){
        //Listedeki bütün öğeleri siler, boş liste haline getirir.
        this.array = (T[]) new Object[this.capacity];

    }
    public  MyList<T> subList(int start,int finish){
        //Parametrede verilen indeks aralığına ait bir liste döner.
        MyList<T> array = new MyList<>();
        int length=finish-start+1;
        while ((start<0 || finish >= size()) || start>=size() || finish<=0) {
            System.out.println("Hatali aralik");
            Scanner input =new Scanner(System.in);
            System.out.print("Start value : ");
            start=input.nextInt();
            System.out.print("Finish value : ");
            finish=input.nextInt();
        }

            for (int l = start; l < finish; l++) {

                array.add(this.array[l]);

            }
            return array;





    }

    public boolean contains(T data){
        //Parametrede verilen değerin dizide olup olmadığını söyler.
        if(indexOf(data) == -1){
            return false;
        }else{
            return true;
        }

    }




}
