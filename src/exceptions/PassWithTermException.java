package exceptions;

import java.time.YearMonth;

public class PassWithTermException extends Exception{
    @Override
    public String toString() {
        return "PassWithTermException";
    }
    public int calculateTermOfOverdue(){return -1;}
}
