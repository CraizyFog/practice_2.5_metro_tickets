package exceptions;

import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

public class StudentPassOverdueException extends PassWithTermException {
    private StudentPass pass;
    public StudentPassOverdueException(StudentPass pass) {
        this.pass = pass;
    }
    public int calculateTermOfOverdue(){
        return YearMonth.now().getMonth().minus((long)this.pass.getMonth().getMonthValue()).getValue();
    }
    @Override
    public String toString() {
        return "StudentPassOverdueException:" +" the pass has been overdue " + calculateTermOfOverdue() + " month ago" ;
    }
}
