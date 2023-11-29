package exceptions;

import passes.SchoolPass;

import java.time.YearMonth;

public class SchoolPassOverdueException extends Exception{
    private SchoolPass pass;

    public SchoolPassOverdueException(SchoolPass pass) {
        this.pass = pass;
    }
    public int calculateTermOfOverdue() {
        return (YearMonth.now().getMonth().minus(pass.getMonth().getMonthValue())).getValue();
    }

    @Override
    public String toString() {
        return "SchoolPassOverdueException" +" the pass has been overdue " + calculateTermOfOverdue() + " month ago";
    }


}
