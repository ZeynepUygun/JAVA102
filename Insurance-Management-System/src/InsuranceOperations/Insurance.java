package InsuranceOperations;
/*InsuranceOperations isminde oluşturmuş olduğumuz pakete sınıfı dahil ettik.

*/

import java.util.Calendar;
import java.util.Date;

public abstract class Insurance {
    /*Sigortalar için abstract sınıfını yazdık. */
    Calendar calendar=Calendar.getInstance();
    private String name;
    private double price;
    private Date startDate;
    private Date finishDate;
    public abstract void calculate(String insuranceType);

    public Insurance(String name,Date startDate,Date finishDate){
        this.name=name;
        this.startDate=startDate;
        this.finishDate=finishDate;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}
