# ( JAVA102 Homework )
1-ADVENTURE GAME 

2-My Own List Class

3-The-Book-Sorter
## ADVENTURE GAME 
![My image](https://github.com/ZU1234/JAVA102/blob/main/AdvantureGame/Oyun%C3%96zellikleri.png?raw=true "Optional Title")

**---> Kural 1**

Oyunu bitirebilmek için savaş bölgelerindeki tüm düşmanlar temizlendikten sonra bölgeye özel ödülü oyunucun envanterine eklenmelidir. Eğer oyuncu tüm ödülleri toplayıp "Güvenli Eve" dönebilirse oyunu kazanır. Ayrıca ödül kazanılan bölgeye tekrar giriş yapılamaz.


***Bölge Ödülleri :***

Mağara => Yemek (Food)

Orman => Odun (Firewood)

Nehir => Su (Water)


**---> Kural 2**

Oyuncu bir canavarla karşılaştığında ilk hamleyi kimin yapacağını, %50 şans ile belirlenmesi.


**---> Kural 3** 
Yeni bir savaş bölgesi eklenmeli. Bu bölgenin amacı yenilen rakiplerden rastgele para, silah veya zırh kazanma ihtimali olması.


**Bölge Adı : Maden**

Canavar : Yılan (1-5 Adet)

Özellik : Savaş ve Ganimet

Eşya : Para, Silah veya Zırh


**Yılan Özellikleri :**
ID : 4

HASAR : Rastgele (3 ve 6 arası)

SAĞLIK :12

PARA : Yok (Onun yerine eşya kazanma ihtimali)


**Yenilen bir rakiplerden düşen eşyalar :**

***-Silah Kazanma İhtimali : 15%***

Tüfek Kazanma İhtimali : 20%

Kılıç Kazanma İhtimali : 30%

Tabanca Kazanma İhtimali : 50%

***-Zırh Kazanma İhtimali : 15%***

Ağır Zırh Kazanma İhtimali : 20%

Orta Zırh Kazanma İhtimali : 30%

Hafif Zırh Kazanma İhtimali : 50%

***-Para Kazanma İhtimali : 25%***

10 Para Kazanma İhtimali: 20%

5 Para Kazanma İhtimali: 30%

1 Para Kazanma İhtimali: 50%

***-Hiç birşey kazanamama ihtimali : 45%***

## My Own List Class
Java'da generic yapısını kullanarak verileri tuttuğumuz bir sınıf tasarlıyoruz.

Sınıfın amacı içerisinde dinamik bir Array (Dizi) tutması ve veri tipini dinamik olarak alması. Bunun için generic bir sınıf oluşturulması gerekli.

***Sınıf özellikleri :***



***Sınıf içerisindeki dizinin varsayılan boyutu 10 ve dizinin eleman sayısı ihtiyaç duydukça 2 katı şeklinde artmalı.


***Sınıfa ait iki tür constructor metot bulunmalı.***


***MyList() :*** Boş contructor kullanılırsa dizinin başlangıç boyutu 10 olmalıdır.


***MyList(int capacity) :*** Dizinin başlangıç değeri capacity parametresinden alınmalıdır.


***size() :*** dizideki eleman sayısını verir.


***getCapacity() :*** dizinin kapasite değerini verir.


***add(T data) :*** sınıfa ait diziye eleman eklemek için kullanılmalıdır. Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.

***get(int index):*** verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.


***remove(int index):*** verilen indisteki veriyi silmeli ve silinen indis sonrasında ki verileri sol doğru kaydırmalı. Geçersiz indis girilerse null döndürür.


***set(int index, T data) :*** verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır. Geçersiz indis girilerse null döndürür.


***String toString() :*** Sınıfa ait dizideki elemanları listeleyen bir metot.

***int indexOf(T data) :*** Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.


***int lastIndexOf(T data) :*** Belirtilen öğenin listedeki son indeksini söyler. Nesne listede yoksa -1 değerini verir.


***boolean isEmpty() :*** Listenin boş olup olmadığını söyler.


***T[] toArray() :*** Listedeki öğeleri, aynı sırayla bir array haline getirir.


***clear() :*** Listedeki bütün öğeleri siler, boş liste haline getirir.


***MyList<T> sublist(int start,int finish) :*** Parametrede verilen indeks aralığına ait bir liste döner.


***boolean contains(T data) :*** Parametrede verilen değerin dizide olup olmadığını söyler.
  
## The-Book-Sorter
  
  Book isminde bir sınıf tasarlayınız. Bu sınıf Comparable interface'den kalıtım alıp "compareTo" metodunu override ediniz. Bu metodun içinde kitabı A'dan Z'ye isme göre sıralayan kodu yazınız. Bu sınıftan 5 tane nesne oluşturun ve nesneleri Set tipinde bir yapısında saklayınız. Sonra ikinci kez Set tipinden bir veri yapısı kullanın ve kitapları sayfa sayısına göre sıralamasını sağlayınız.

Book sınıfı kitap ismi, sayfa sayısı, yazarın ismi, yayın tarihi değişkenlerinden oluşmaktadır.

## Fixture-Builder

Java ile girilen takımlar için rastgele maç fikstürü oluşturan
bir sınıf yazılmalı.

***Kurallar :***

Çift Devreli Lig usülü uygulanacaktır.
Her takım diğer takımlarla kendi evinde ve deplasmanda olmak üzere
iki maç yapacaktır.

Listenin sol tarafı ev sahibini sağ tarafı deplasman takımını gösterir.

Eğer tek sayıda takım listesi girilirse, çift sayıya tamamlanacak şekilde "Bay" adında bir takım daha eklenmeli.
Bay ile eşleşen takımlar o hafta maç yapmayacağı anlamına gelir.

## PatikaStore


Patika ekibi elektronik eşyaların satıldığı bir sanal bir mağaza açmaya karar verdi ve bu mağazanın ürün yönetim sistemini siz patika gönüllülerinden yapmasını ekliyor.



-Sanal Mağazanın adı "PatikaStore" olacaktır.


-Mağazada Markalar oluşturulacak ve ürünler bu markalar ile eşleşecektir.


-id : Markanın sistemde kayıtlı benzersiz numarası


-name : Markanın adı


-Markalar listelenirken her zaman alfabe sırasıyla listelenmelidir.


-Markalar statik olarak kod blokları içerisinden aşağıdaki sıra ile eklenmelidir.


-Markalar : Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster


-Mağazada şuan için 2 tür ürün grubu satılması planlanmaktadır : Cep Telefonları, Notebook


-Daha sonrasında farklı ürün gruplarını eklenebilir olmalıdır.


**Cep Telefonu ürünlerinin özellikleri :**


-Ürünün sistemde kayıtlı benzersiz numarası


-Birim fiyatı


-İndirim oranı


-Stok miktarı


-Ürün adı


-Marka bilgisi (Sistemde ekli olan markalar kullanılacaktır)


-Telefonun hafıza bilgisi (128 GB, 64 GB)


-Ekran Boyutu (6.1 Inc)


-Pil Gücü (4000)


-RAM (6 MB)


-Renk (Siyah,Kırmızı,Mavi)


**Notebook ürünlerinin özellikleri :**


-Ürünün sistemde kayıtlı benzersiz numarası


-Birim fiyatı


-İndirim oranı


-Stok miktarı


-Ürün adı


-Marka bilgisi (Sistemde ekli olan markalar kullanılacaktır)


-Ram (8 GB)


-Depolama (512 SSD)


-Ekran Boyutu (14 inç)


-Kullanıcı sistem üzerinden ilgili kategorideki (Notebook, Cep Telefonları vb.) ürünleri listeyebilimeli


-Ürünler listelenirken tablo şeklinde konsol ekranında gösterilmeli (System.out.format() kullanılabilir).


-Kullanıcı ürün ekleyebilmeli ve ürünün grubunu (Cep Telefonu, Notebook vb.) seçebilmeli.


-Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli.


-Kullanıcı ürünlerin benzersiz numaralarına ve markalarına göre filtreleyip listeleyebilmeli.
