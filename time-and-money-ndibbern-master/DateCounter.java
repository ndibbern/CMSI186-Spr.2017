import java.time.LocalDate;

public class DateCounter {
    /**
     * Returns today's date as a three-element integer array in year-month-day order.
     */
     public static int[] today() {
         LocalDate now = LocalDate.now();
         return new int[] { now.getYear(), now.getMonth().getValue(), now.getDayOfMonth() };
     }

     public static boolean isLeapYear(int year) {
         return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
     }

     public static int daysInMonth(int year, int month) {
         int numDays = 0;
        //  check that this initialization is correct
         switch (month) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                numDays = 31;
                break;
            case 4: case 6:
            case 9: case 11:
                numDays = 30;
                break;
            case 2:
                if (isLeapYear(year)) numDays = 29;
                else numDays = 28;
                break;
        }

         return numDays;
     }

     public static boolean isValidDate (int year, int month, int day) {
        int maxDaysInMonth = daysInMonth(year, month);
        return !(day < 1 || day > maxDaysInMonth|| year < 0 || month < 1 || month > 12);
     }

     public static int daysBetween (int year0, int month0, int day0, int year1, int month1, int day1) {
        // days in between should work no matter which one I put first.
         //If date1 < date0, swap those
        if(!dateIsInOrder(year0, month0, day0, year1, month1, day1)) {
            int tempYear = year0, tempMonth = month0, tempDay = day0;
            year0 = year1; month0 = month1; day0 = day1;
            year1 = tempYear; month1 = tempMonth; day1 = tempDay;
        }
         int difference = 0;
         int deltYear = year1 - year0;
         int deltMonth = month1 - month0;
        // When there are complete years to count
        if(deltYear > 1) {
            for(int i = 1; i < deltYear ; i++) {
                difference += isLeapYear(year0 + i) ? 366 : 365;
            }
        }
        // When there are years to complete
        if(deltYear > 0) {
            if(month0 != 12) {
                for(int i = month0 + 1; i <= 12; i++) {
                    difference +=  daysInMonth(year0, i);
                }
                difference += daysInMonth(year0, month0) - day0;
            } else difference += daysInMonth(year0, month0) - day0;
            //add days to complete last year
            if(month1 != 1){
                for (int i = 1; i < month1; i++) {
    			difference +=  daysInMonth(year1, i);
    			}
                difference += day1;
            } else difference += day1;
        }
        //When the two dates are on the same year
        if(deltYear == 0) {
            if(deltMonth > 1) {
                for(int i = month0 + 1; i < month1; i++) {
                    //Add complete months
                    difference += daysInMonth(year0, i);
                }
                //Add days to finish current month + days of month1
                difference += daysInMonth(year0, month0) - day0 + day1;
            }
            //When the two dates are one month apart
            else if(deltMonth == 1) {
            difference += daysInMonth(year0, month0) - day0 + day1;
            }
            // When the two dates are on the same year and same month but different days
            else {
                if (day0 != day1) {
                    difference += day1 - day0;
                }
            }
        }
        return difference;
    }

     public static boolean dateIsInOrder(int year0, int month0, int day0, int year1, int month1, int day1){
     	//Will return true if date0 smaller than date 1, false otherwise
        if(year1 > year0) return true;
        else if (year1 < year0) return false;
        else if (month1 > month0) return true;
        else  if (month1 < month0) return false;
        else if (day1 > day0) return true;
        else if (day1 < day0) return false;
        else return true;
    }

     public static int ageInDays (int birthyear, int birthmonth, int birthday) {
         return daysBetween(birthyear, birthmonth, birthday, today()[0], today()[1], today()[2]);
     }

     public static void main(String[] args) {
         if(args.length == 0) System.out.println("Usage: java DateCounter <one or two dates in year-month-day order>");
         else if (args.length > 3){
             try {
                 int year0 = Integer.parseInt(args[0]);
		         int month0 = Integer.parseInt(args[1]);
		         int day0 = Integer.parseInt(args[2]);

                 int year1 = Integer.parseInt(args[3]);
    		     int month1 = Integer.parseInt(args[4]);
    		     int day1 = Integer.parseInt(args[5]);

		         if(isValidDate(year0, month0, day0) && isValidDate(year1, month1, day1)) {
				     System.out.println(daysBetween(year0, month0, day0, year1, month1, day1)+" days");
		         }else  System.out.println("One or more of the supplied dates is not valid.");
		          }catch (NumberFormatException ignore) {
                      System.out.println("One or more of the supplied dates is not valid.");
		          }catch (ArrayIndexOutOfBoundsException e) {
                      System.out.println("One or more of the supplied dates is not valid.");
                  }
         }else {
             try {
                 int birthyear = Integer.parseInt(args[0]);
                 int birthmonth = Integer.parseInt(args[1]);
                 int birthday = Integer.parseInt(args[2]);

                if(isValidDate(birthyear, birthmonth, birthday)) {
                   System.out.println(ageInDays(birthyear, birthmonth, birthday) + " days old");
               }else  System.out.println("One or more of the supplied dates is not valid");
                }catch (NumberFormatException ignore) {
                    System.out.println("One or more of the supplied dates is not valid");
                }catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("One or more of the supplied dates is not valid");
                }
        }
    }
}
