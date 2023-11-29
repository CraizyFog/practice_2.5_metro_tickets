import exceptions.RegularPassNotEnoughMoneyException;
import exceptions.SchoolPassOverdueException;
import exceptions.SchoolPassTripFinishedException;
import exceptions.StudentPassOverdueException;
import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

public class Turnstile {
    public void validateEntryPermition(MetroPass metroPass)throws
            SchoolPassOverdueException, StudentPassOverdueException,
            SchoolPassTripFinishedException, RegularPassNotEnoughMoneyException {
        if(metroPass instanceof SchoolPass SP){
            if(SP.getMonth().isBefore(YearMonth.now())){
                KyivSmartCard.addProhibition();
                throw new SchoolPassOverdueException(SP);
            } else if (SP.getCountOfTrip() == 0) {
                KyivSmartCard.addProhibition();
                throw new SchoolPassTripFinishedException(SP);
            }else{
                KyivSmartCard.addPermition();
                SP.setCountOfTrip(SP.getCountOfTrip()-1);
                System.out.println("Subtract 1 one trip");
            }
        }
        if(metroPass instanceof StudentPass STP){
            if(STP.getMonth().isBefore(YearMonth.now())){
                KyivSmartCard.addProhibition();
                throw new StudentPassOverdueException(STP);
            }else {
                KyivSmartCard.addPermition();
                System.out.println("cheater");
            }
        }
        if(metroPass instanceof RegularPass RP){
            if(RP.getAmountOfMoney() < KyivSmartCard.FARE){
                KyivSmartCard.addProhibition();
                throw new RegularPassNotEnoughMoneyException(RP);
            }else{
                KyivSmartCard.addPermition();
                KyivSmartCard.subtractFair(RP);
                System.out.println("Privat24: subtract "+ KyivSmartCard.FARE + " UAN" );
            }

        }



    }
}
