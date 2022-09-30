package com.bp.cbe.util;

import com.bp.cbe.domain.Loan;
import com.bp.cbe.domain.enums.UserType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class LoanUtils {

    public static LocalDate returnDateForUserType(UserType userType) {
        LocalDate returnDate = LocalDate.now();
        switch (userType){
            case INVITED:
                returnDate = addDaysSkippingWeekends(returnDate, 30);
                break;
            case INTERN:
                returnDate = returnDate.plusDays(365);
                break;
            case EXTERN:
                returnDate = returnDate.plusDays(360);
                break;
        }

        return returnDate;
    }

    public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

    public static boolean reachedNumberOfCurrentLoans(List<Loan> currentLoans, UserType userType) {
        return (userType.equals(UserType.INTERN) && currentLoans.size() >= 2)
                || ((userType.equals(UserType.EXTERN)
                || userType.equals(UserType.INVITED))
                && currentLoans.size() == 1);
    }
}
