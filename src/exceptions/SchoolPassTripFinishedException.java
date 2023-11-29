package exceptions;

import passes.SchoolPass;

import java.time.YearMonth;

public class SchoolPassTripFinishedException extends PassWithTermException{
    private SchoolPass pass;

    public SchoolPassTripFinishedException(SchoolPass pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "SchoolPassTripFinishedException:" + "school pass with id "+ pass.getUid() + " has no more trip";
    }
    public int calculateTermOfOverdue(){
        return YearMonth.now().getMonth().minus((long)this.pass.getMonth().getMonthValue()).getValue();
    }


}
