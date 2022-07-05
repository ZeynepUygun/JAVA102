package AccountOperations;

import InsuranceOperations.*;
import UserOperations.User;

public class Enterprise extends Account{
    private final String enterprise="Enterprise";
    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addPolicy() {
        System.out.println("Sigorta Türlerimiz");
        System.out.println("1- Sağlık Sigortası\n" +
                "2- Konut Sigortası\n" +
                "3- Seyahat Sigortası\n" +
                "4- Araba Sigortası");
        System.out.print("Yapmak istediğiniz sigorta çeşidinin numarasını giriniz : ");
        switch (scanner.nextInt()) {
            case 1:
                if (checkInsurance(new HealthInsurance(enterprise))){
                    getUser().setInsurance(new HealthInsurance(enterprise));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                }else System.out.println("Bu sigorta sizde mevcut.");

                break;
            case 2:
                if(checkInsurance(new ResidenceInsurance(enterprise))){
                    getUser().setInsurance(new ResidenceInsurance(enterprise));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");

                }else System.out.println("Bu sigorta sizde mevcut.");
                break;
            case 3:
                if(checkInsurance(new TravelInsurance(enterprise))){
                    getUser().setInsurance(new TravelInsurance(enterprise));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                }else System.out.println("Bu sigorta sizde mevcut.");

                break;
            case 4:
                if(checkInsurance(new CarInsurance(enterprise))){
                    getUser().setInsurance(new CarInsurance(enterprise));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                }else System.out.println("Bu sigorta sizde mevcut.");

                break;
            default:
                System.out.println("Geçersiz veri girdiniz!");
                break;
        }
    }

    private boolean checkInsurance(Insurance insurance) {
        for(Insurance i:getUser().getInsuranceList()){
            if(i.getName().equals(insurance.getName())){
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Account o) {
        return this.getUser().getFirstName().compareTo(o.getUser().getFirstName());
    }
}