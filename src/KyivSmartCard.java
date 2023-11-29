import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KyivSmartCard {
    public static final int COUNT_OF_SCHOOL_TRIP_PER_MONTH = 64;
    public static final int FARE = 8;
    private static ArrayList<MetroPass> internalCardStorage;
    private static int countOfPermitions;
    private static int countOfProhibitions;
    public static MetroPass createPass(PassType passType) {
        internalCardStorage = new ArrayList<>();
        switch (passType) {
            case SCHOOL_PASS -> {
                SchoolPass schoolPass = new SchoolPass(0);
                internalCardStorage.add(schoolPass);
                return schoolPass;
            }
            case STUDENT_PASS -> {
                StudentPass studentPass = new StudentPass();
                internalCardStorage.add(studentPass);
                return studentPass;
            }
            case REGULAR_PASS -> {
                RegularPass regularPass = new RegularPass();
                internalCardStorage.add(regularPass);
                return  regularPass;
            }
        }
        return null;
    }
    public static void addPermition(){
        countOfPermitions++;
    }
    public static void addProhibition(){
        countOfProhibitions++;
    }

    public int getCountOfPermitions() {
        return countOfPermitions;
    }

    public int getCountOfProhibitions() {
        return countOfProhibitions;
    }
    public void addFounds(RegularPass RP, int a){
        RP.setAmountOfMoney(RP.getAmountOfMoney()+ a);
    }

    public int getCOUNT_OF_SCHOOL_TRIP_PER_MONTH() {
        return COUNT_OF_SCHOOL_TRIP_PER_MONTH;
    }
    public static void subtractFair(RegularPass RP){
         RP.setAmountOfMoney(RP.getAmountOfMoney()-FARE);
    }
}
