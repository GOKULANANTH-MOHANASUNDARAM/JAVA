package exercise6;

import java.time.*;

public class Lorry {
	public static void main(String[] args) {
		double speed = 60;

        // Distance to travel in km
        double distance = 1000;

        // Date and time of departure
        LocalDate date = LocalDate.of(2023, Month.MARCH, 1);
        LocalTime time = LocalTime.of(8, 0);

        // Calculate the estimated time of arrival
        LocalDateTime currentDateTime = LocalDateTime.of(date, time);
        Duration timeTaken = Duration.ofMinutes((long) ((distance / speed) * 60));
        LocalDateTime estimatedDateTime = currentDateTime.plus(timeTaken);

        // Check for holidays and working hours
        while (!isWorkingDay(estimatedDateTime.toLocalDate())) {
            estimatedDateTime = estimatedDateTime.plusDays(1);
        }
        if (estimatedDateTime.getHour() >= 20) {
            estimatedDateTime = estimatedDateTime.plusHours(12);
        } else if (estimatedDateTime.getHour() < 8) {
            estimatedDateTime = estimatedDateTime.withHour(8);
        }

        // Print the estimated date and time of arrival
        System.out.println("Estimated date of arrival: " + estimatedDateTime.toLocalDate());
        System.out.println("Estimated time of arrival: " + estimatedDateTime.toLocalTime());
    }
	
	// Check if a given date is a working day or not
    public static boolean isWorkingDay(LocalDate date) {
        // Check for Sunday and second Saturday holiday
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SUNDAY) {
            return false;
        } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            int dayOfMonth = date.getDayOfMonth();
            if (dayOfMonth >= 8 && dayOfMonth <= 14) {
                return false;
            }
        }

        // Check for other holidays
        MonthDay holiday1 = MonthDay.of(Month.JANUARY, 1);
        MonthDay holiday2 = MonthDay.of(Month.AUGUST, 15);
        MonthDay holiday3 = MonthDay.of(Month.JANUARY, 26);
        if (date.getMonth().equals(holiday1) || date.getMonth().equals(holiday2) || date.getMonth().equals(holiday3)) {
            return false;
        }
        return true;
    }
}
