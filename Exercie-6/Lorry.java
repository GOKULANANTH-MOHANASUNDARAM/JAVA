package exercise6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lorry {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting date in yyyy-mm-dd format: ");
        String startdate = scanner.nextLine();
        System.out.print("Enter the travel distance in km: ");
        int distance = scanner.nextInt();
        System.out.print("Enter the speed in km/h: ");
        int speed = scanner.nextInt();
        System.out.print("Enter the starting time in hh:mm format (24-hour clock): ");
        String starttime = scanner.next();
        
        LocalDate startDate = LocalDate.parse(startdate);
        LocalTime startTime = LocalTime.parse(starttime);
        
        int totalHours = distance / speed;
        int totalDays = totalHours / 8;
        
        if (totalHours % 8 != 0) {
            totalDays++;
        }
        
        List<LocalDate> holidays = Arrays.asList(
            LocalDate.of(startDate.getYear(), Month.JANUARY, 1), 
            LocalDate.of(startDate.getYear(), Month.AUGUST, 15), 
            LocalDate.of(startDate.getYear(), Month.JANUARY, 26) 
        );
        
        List<DayOfWeek> weekends = Arrays.asList(
            DayOfWeek.SUNDAY, 
            DayOfWeek.SATURDAY 
        );
        
        LocalDateTime currentDateTime = LocalDateTime.of(startDate, startTime);
        LocalDate currentDate = currentDateTime.toLocalDate();
        LocalTime currentTime = currentDateTime.toLocalTime();
        
        for (int i = 0; i < totalDays; i++) {
        	// Check if current date is a holiday or weekend
            if (holidays.contains(currentDate) || weekends.contains(currentDate.getDayOfWeek())) {
                // Skip this day
                currentDate = currentDate.plusDays(1);
                continue;
            }
            
            // Calculate the number of hours left in the current day
            int remainingHours = 8 - currentTime.getHour();
            
            // If this is the last day, adjust the remaining hours
            if (i == totalDays - 1 && totalHours % 8 != 0) {
                remainingHours = totalHours % 8;
            }
            
            // Calculate the time the lorry will reach the destination on this day
            LocalTime destinationTime = currentTime.plusHours(remainingHours);
            
            // If the lorry will reach the destination after 8pm, adjust the time to 8pm
            if (destinationTime.isAfter(LocalTime.of(20, 0))) {
                destinationTime = LocalTime.of(20, 0);
            }
            
            // Calculate the date the lorry will reach the destination on this day
            LocalDate destinationDate = currentDate.plusDays(i);
            
            // Create a LocalDateTime object for the destination date and time
            LocalDateTime destinationDateTime = LocalDateTime.of(destinationDate, destinationTime);
            
            // Print the destination date and time
            System.out.println("The lorry will reach the destination on " + destinationDateTime);
            
            // Update the current date and time for the next day
            currentDate = destinationDate.plusDays(1);
            currentTime = LocalTime.of(8, 0);
        }
        scanner.close();
    }
    
}
