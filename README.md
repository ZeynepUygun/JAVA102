# ( JAVA102 Homework )
1-ADVENTURE GAME 

2-My Own List Class

3-The-Book-Sorter

4-Fixture-Builder

5-PatikaStore

6-Sigorta Yönetim Sistemi

7-Race Threads

8-Book List


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

## Sigorta Yönetim Sistemi

Sigorta firması için bir yazılım yaptığınızı düşünün. Sigorta firmasının "Bireysel" (Individual) ve "Kurumsal" (Enterprise) olmak üzere iki tip müşteri profili bulunmaktadır. Müşteri profili için "Account" isminde soyut sınıf (abstract class) tasarlayınız. Account sınıfı müşterinin sisteme giriş sonrasında tüm bilgilerinin tutulduğu hesap bilgisidir. "Account" sınıfı içinde "User" tipinde bir nesne referansı bulunur. (Aggeration ilişkisi olarak)



"User" sınıfı müşterinin kişi bilgilerini ifade eder. "User" sınıfında müşterinin



isim (String),


soyisim (String),


email (String),


şifre (String),


meslek (String),


yaş (int),


adres listesi (ArrayList<Address>)


sisteme son giriş tarihi (Date)


bilgileri bulunur. Ayrıca, "User" sınıfında ArrayList tipinde adreslerinin tutulduğu bir liste vardır. Adres bilgisi iki tiptir. Ev adresi ("HomeAddress") ve İş adresi ("BusinessAddress") olmak üzere iki tane sınıf tasarlayınız. Bu adres sınıfları "Address" isimli bir interface'den kalıtım alacaktır. Fakat, bu interface'de hangi fonksiyonların olması gerektiğine siz karar vereceksiniz.



Müşteri adreslerinin ekleyip çıkarılma sorumluluğunu üstlenmiş olan "AddressManager" isminde bir sınıf tasarlayınız. Bu sınıfın içinde "User" nesnesinin adres listesine eleman ekleme-çıkarma yapabilen iki tane static fonksiyon tanımlayınız. Bu fonksiyon isimlerini siz belirleyiniz.



"Account" sınıfında müşteri bilgilerini ekrana yazdıran "final" tipinde, değer döndürmeyen ve ismi "showUserInfo" bir fonksiyon tanımlayınız.



"Account" sınıfında müşterilerin yaptırdıkları sigortaları liste halinde saklayınız. Sigortayı temsil eden "Insurance" isminde bir soyut sınıf tasarlayınız. Bu soyut sınıf içinde



sigortanın ismi (String),


sigortanın ücreti (double)


sigortanın başlangıç-bitiş tarihi (Date)


gibi değişkenlere sahip olacaktır. Ayrıca "calculate" isminde soyut bir fonksiyon tanımlanacaktır. Bu soyut fonksiyon aşağıda kalıtım alınan sınıflarda doldurulacaktır.



Bu soyut sınıftan türeyen



"HealthInsurance" (özel sağlık sigortasu),


"ResidenceInsurance" (konut sigortası),


"TravelInsurance" (seyahat sigortası),


"CarInsurance" (otomobil sigortası)


4 tane alt sınıf tasarlayınız. Her alt sınıf "calculate" isimli soyut fonksiyonu override ederek, sigorta ücretini kendine göre hesaplayacaktır.



Yukarıdaki tanımları dikkate aldığımızda soyut sınıf olan "Account" sınıfında aşağıdakiler yer almalıdır.



kullanıcının login olma durumu (AuthenticationStatus)


kullanıcı nesnesi (User)


kullanıcının yaptırmış olduğu sigortaların listesi (ArrayList)


AuthenticationStatus tipinde bir enum tanımlayınız. Enum içinde SUCCESS ve FAIL isminde iki tane sabit tanımlayın. SUCCESS login işlemi başarılı ise kullanılacaktır. FAIL ise login olmamışsa kullanılacaktır.


kullanıcının hesabına login olabilmesi için bir fonksiyon tanımlanacaktır. Bu fonksiyon email ve şifre bilgisi alacak ve gelen email şifre bilgisini User sınıfındaki email ve şifre ile kıyaslayacaktır. Eğer girilen bilgiler doğruysa giriş işlemi başarılı olacaktır. Ve kullanıcının login olma durumu SUCCESS'e çekilecektir. Giriş işlemi başarısız ise "InvalidAuthenticationException" tipinde bir hata fırlatacaktır. Bu hata sınıfını Exception isimli Java sınıfından kalıtım alarak sizin yazmanız gerekecektir.


kullanıcının adreslerine ekleme yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır. kullanıcının adreslerinden çıkartma yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır. kullanıcının login olma durumunu veren değer döndüren fonksiyon tanımlanacaktır.


kullanıcının sigorta poliçesi ekleyebilmesi için soyut (abstract) bir fonksiyon tanımlanacaktır. Bu soyut sınıf "Individual" ve "Enterprise" isimli alt sınıflarda override edilerek doldurulacaktır. Çünkü, bireysel ve kurumsal müşterilerin ekledikleri paketlerin fiyatlarına uygulanan kar marjı farklı olacaktır.


"Individual" ve "Enterprise" sınıfları "Account" sınıfından kalıtım alacaktır.



AccountManager isminde bir sınıf tasarlayınız. Bu sınıf içinde TreeSet tipinde bir veri listesi tutsun. Oluşturduğunuz bireysel ve kurumsal hesapları bu listede saklayınız. bu sınıf içinde login isminde bir fonksiyon tanımlayınız. Bu fonksiyon dışarıdan verilen email ve şifre bilgisini alıp Account listesi üzerinde dolaşıp uygun bir giriş işlemi bulursa Account nesnesini çağrıldığı yere dönecektir. Bu fonksiyon Account nesnesi üzerindeki "login" olma fonksiyonunu çağıracaktır. Unutmayın bu fonksiyon "InvalidAuthenticationException" tipinde hata fırlatabiliyordu. Bu nedenle burada try-catch mekanizması kurmayı unutmayınız.



"Account" sınıfından nesneleri TreeSet içinde tutacağımız için "Comparable" interface'den kalıtım almış olmasına dikkat edin. Ayrıca, "Account" sınıfının "hashCode" ve "equals" fonksiyonlarını doldurmayı unutmayın.



Klavyeden email ve şifre bilgisini alan bir sınıf tasarlayınız. Klavyeden alınan email ve şifre bilgisi ile AccountManager sınıfındaki "login" fonksiyonunu çağırın. Eğer geçerli bir kullanıcı ile giriş yapmışsanız bu fonksiyon size Account tipinde bir nesne dönecektir.

## Race Threads

1'den 10000 (10 bin)'e kadar olan sayılardan oluşan bir ArrayList oluşturunuz. Ardından, bu ArrayList'teki 10 bin elemanı 2500 eleman olacak şekilde 4 eşit parçaya ayırınız. Bu 4 ayrı 2500 elemanlık ArrayList'ler içinde tek ve çift sayıları bulan 4 ayrı Thread tasarlayınız.



4 Thread bulduğu çift sayıları ortak bir ArrayList'e ekleyecektir.


4 Thread bulduğu tek sayıları ortak bir ArrayList'e ekleyecektir.


Tek ve çift sayıları tutan ArrayList'ler ilk oluşturulduklarında boş olacaklardır. Ve iki tane ArrayList olacaklardır.


4 Thread kendine ait 2500 elemanlık ArrayList'i işlemeye başlayınca tek ve çift sayı ArrayList'lerini dolduracaktır.

## Book List


Book sınıfı kitap ismi, sayfa sayısı, yazarın ismi, yayın tarihi değişkenlerinden oluşmaktadır.

Book sınıfından 10 tane nesne üretip bunu bir ArrayList yapısında saklayınız. stream yapısını ve lambda ifadelerini kullanarak kitap isminin karşısında yazar ismi olacak şekilde yeni bir Map<String, String> oluşturacak şekilde yazınız.



Bu 10 elemanlık Book listesinden sayfa sayısı 100'den fazla olan kitapları filtreleyen ve yeni bir liste olarak verecek geliştirmeyi yapınız. (Stream ve Lambda ifadeleri kullanabilirsiniz.)


