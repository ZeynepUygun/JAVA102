package AccountOperations;

import InsuranceOperations.CarInsurance;
import InsuranceOperations.HealthInsurance;
import InsuranceOperations.ResidenceInsurance;
import InsuranceOperations.TravelInsurance;
import UserOperations.User;

public class Individual extends Account{
    private final String individual="Individual";
    public Individual(User user) {
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
        switch (scanner.nextInt()){
            case 1:
                getUser().setInsurance(new HealthInsurance(individual));
                getUser().setInsuranceList(getUser().getInsurance());
                System.out.println("Sigortanız yapılmıştır.");
                break;
            case 2:
                getUser().setInsurance(new ResidenceInsurance(individual));
                getUser().setInsuranceList(getUser().getInsurance());
                System.out.println("Sigortanız yapılmıştır.");
                break;
            case 3:
                getUser().setInsurance(new TravelInsurance(individual));
                getUser().setInsuranceList(getUser().getInsurance());
                System.out.println("Sigortanız yapılmıştır.");
                break;
            case 4:
                getUser().setInsurance(new CarInsurance(individual));
                getUser().setInsuranceList(getUser().getInsurance());
                System.out.println("Sigortanız yapılmıştır.");
                break;
            default:
                System.out.println("Geçersiz veri girdiniz!");
                break;
        }
    }

    @Override
    public int compareTo(Account o) {
        return this.getUser().getFirstName().compareTo(o.getUser().getFirstName());
    }
}