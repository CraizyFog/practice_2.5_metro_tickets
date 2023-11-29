import exceptions.RegularPassNotEnoughMoneyException;
import exceptions.SchoolPassOverdueException;
import exceptions.SchoolPassTripFinishedException;
import exceptions.StudentPassOverdueException;
import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Turnstile turnstile = new Turnstile();
        var pass = KyivSmartCard.createPass(PassType.REGULAR_PASS);
        RegularPass regularPass = (RegularPass) pass;
        regularPass.setAmountOfMoney(10);
        try {
            turnstile.validateEntryPermition(regularPass);
        } catch (SchoolPassOverdueException | SchoolPassTripFinishedException | StudentPassOverdueException |
                 RegularPassNotEnoughMoneyException e){
            e.printStackTrace();
        }
    }
}