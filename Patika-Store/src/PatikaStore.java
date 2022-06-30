import java.util.Scanner;

public class PatikaStore {

    public PatikaStore() {

        Phone.phones();
        Notebook.notebooks();
        int select;

        Scanner input = new Scanner(System.in);
        do {

            System.out.println("""
                    \nPatikaStore Urun Yonetim Paneli !
                    1 - Notebook Islemleri
                    2 - Cep Telefonu Islemleri
                    3 - Marka Listele
                    0 - Cikis Yap
                    """);
            System.out.print("Tercihiniz : ");
            select = input.nextInt();

            switch (select) {
                case 1 -> {


                    int selected;
                    do {

                        System.out.println("""
                                \nNOTEBOOK ISLEMLERI
                                1 - Listeleme
                                2 - Markaya Gore Listeleme
                                3 - Silme Islemi
                                4 - Urun ekleme
                                0 - Notebook Islemlerinden Cikis Yap
                                """);
                        System.out.print("Seciminiz : ");
                        selected = input.nextInt();
                        switch (selected) {
                            case 1 -> {
                                System.out.println("---------------------\n\nNOTEBOOK");
                                //Telefonları ekrana bastık.
                                Notebook.notebookPrint();
                            }
                            case 2 -> Notebook.notebookBrandForComparator();
                            case 3 -> {
                                if (Notebook.notebookList.size() != 0) {
                                    System.out.print("\n silmek istenilen ID'yi giriniz.");
                                    int delete = input.nextInt();
                                    Notebook.notebookDelete(delete);
                                } else {
                                    System.out.println("\n\nHic Urun yok.");
                                }
                            }
                            case 4 -> {
                                System.out.println("""

                                        -----------------------
                                        !!  Ilk harfi Buyuk Yaziniz. Siralamanin dogru olmasi icin ilk harfleri buyuk yaziniz. !!
                                        -------------------------------
                                        """);
                                Scanner al = new Scanner(System.in);
                                String[] ad = {"Birim Fiyati : ", "Indirim Orani : ", "Stok : ", "", "Marka : ", "Ekran" +
                                        " : ", "RAM : ", "Depolama : "};
                                int[] sayisal = new int[3];
                                String[] dizi = new String[ad.length];

                                for (int i = 0; i < ad.length; i++) {
                                    if (i < 3) {
                                        System.out.print(ad[i]);
                                        sayisal[i] = al.nextInt();
                                        dizi[i] = String.valueOf(sayisal[i]);

                                    } else {

                                        System.out.print(ad[i]);

                                        dizi[i] = al.nextLine();

                                    }
                                }
                                System.out.println("Urun adi : ");
                                dizi[3] = al.nextLine();


                                Notebook.notebooksAdd(Notebook.notebookList.size() + 1, sayisal[0], sayisal[1], sayisal[2],
                                        dizi[3],
                                        dizi[4], dizi[5], dizi[6], dizi[7]);

                            }

                        }


                    } while (selected != 0);
                }
                case 2 -> {


                    int selected;
                    do {

                        System.out.println("""
                                \nTELEFON ISLEMLERI
                                1 - Listeleme
                                2 - Markaya Gore Listeleme
                                3 - Silme Islemi
                                4 - Urun ekleme
                                0 - Telefon Islemlerinden Cikis Yap
                                """);
                        System.out.print("Seciminiz : ");
                        selected = input.nextInt();
                        switch (selected) {
                            case 1 -> {
                                System.out.println("---------------------\n\nTELEFONLAR");
                                //Telefonları ekrana bastık.
                                Phone.phonesPrint();
                            }
                            case 2 -> Phone.phonesBrandForComparator();
                            case 3 -> {
                                if (Phone.phoneList.size() != 0) {
                                    System.out.print("\n silmek istenilen ID'yi giriniz.");
                                    int delete = input.nextInt();
                                    Phone.phonesDelete(delete);
                                } else {
                                    System.out.println("\n\nHic Urun yok.");
                                }
                            }
                            case 4 -> {
                                System.out.println("""

                                        -----------------------
                                        !!  Ilk harfi Buyuk Yaziniz. Siralamanin dogru olmasi icin ilk harfleri buyuk yaziniz. !!
                                        -------------------------------
                                        """);
                                Scanner al = new Scanner(System.in);
                                String[] ad = {"Birim Fiyati : ", "Indirim Orani : ", "Stok : ", "", "Marka : ", "Ekran" +
                                        " : ", "RAM : ", "Depolama : ", "Batarya : ", "Renk : "};
                                int[] sayisal = new int[3];
                                String[] dizi = new String[ad.length];

                                for (int i = 0; i < ad.length; i++) {
                                    if (i < 3) {
                                        System.out.print(ad[i]);
                                        sayisal[i] = al.nextInt();
                                        dizi[i] = String.valueOf(sayisal[i]);

                                    } else {

                                        System.out.print(ad[i]);

                                        dizi[i] = al.nextLine();

                                    }
                                }
                                System.out.println("Urun adi : ");
                                dizi[3] = al.nextLine();


                                Phone.phonesAdd(Phone.phoneList.size() + 1, sayisal[0], sayisal[1], sayisal[2], dizi[3],
                                        dizi[4], dizi[5], dizi[6], dizi[7], dizi[8], dizi[9]);

                            }

                        }


                    } while (selected != 0);
                }
                case 3 -> {
                    System.out.println("---------------------\nMarkalarimiz");
                    //Markaları ekrana bastık.
                    Brands.brandPrint();

                }

            }
        } while (select != 0);


    }


}
