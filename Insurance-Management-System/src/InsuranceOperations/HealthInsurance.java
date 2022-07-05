package InsuranceOperations;

import java.util.Date;

public class HealthInsurance extends Insurance{
    /*InsuranceOperations isminde oluşturmuş olduğumuz pakete sınıfı dahil ettik..
  Insurance sınıfından kalıtım yaptık.*/

    public HealthInsurance(String insuranceType) {
        /*
        Sağlık sigortası hesabı yaptırdık.
        */
        super("Sağlık sigortası", new Date(), new Date());
        calculate(insuranceType);
    }
    @Override
    public void calculate(String insuranceType) {
        /*
        Sigortanın kurumsal yada bireysel olarak hesabı yapılır.
         */
        double price=999.99;
        if(insuranceType.equals("Individual"))
        {
            setPrice(price);
        }
        if(insuranceType.equals("Enterprise")){
            setPrice(price*0.9);
        }

    }

}
