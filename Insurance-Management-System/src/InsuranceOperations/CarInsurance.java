package InsuranceOperations;

/*InsuranceOperations isminde oluşturmuş olduğumuz pakete sınıfı dahil ettik..
  Insurance sınıfından kalıtım yaptık.*/

import java.util.Date;

public class CarInsurance extends Insurance {

    public CarInsurance(String insuranceType) {
         /*
        Araba sigortası hesabı yaptırdık.
        */
        super("Araba sigortası", new Date(), new Date());
        calculate(insuranceType);

    }
    @Override
    public void calculate(String insuranceType) {
        double price=526.99;
        if(insuranceType.equals("Individual"))
        {
            setPrice(price);
        }
        if(insuranceType.equals("Enterprise")){
            setPrice(price*0.9);
        }
        /*
        Sigortanın kurumsal yada bireysel olarak hesabı yapılır.
         */
    }
}
