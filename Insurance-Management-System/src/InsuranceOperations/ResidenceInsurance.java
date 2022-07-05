package InsuranceOperations;

import java.util.Date;

public class ResidenceInsurance extends Insurance{

    public ResidenceInsurance(String insuranceType) {
         /*
        Konut sigortası hesabı yaptırdık.
        */
        super("Konut sigortası", new Date(), new Date());
        calculate(insuranceType);
    }
    @Override
    public void calculate(String insuranceType) {
        /*
        Sigortanın kurumsal yada bireysel olarak hesabı yapılır.
         */
        double price=526.99;
        if(insuranceType.equals("Individual"))
        {
            setPrice(price);
        }
        if(insuranceType.equals("Enterprise")){
            setPrice(price*0.9);
        }
    }
}
