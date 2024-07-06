import java.util.*;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author mapninora
 */
public class Main1 {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the position of the employee (1) - Teacher & (2) - NTP: ");
        int position = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter gender (M/F): ");
        char gender = scanner.next().charAt(0);
        scanner.nextLine();  // Consume newline

        System.out.print("Enter birthdate (MM-DD-YYYY): ");
        String birthdateString = scanner.nextLine();
        LocalDate birthdate = parseDate(birthdateString);

        if (birthdate == null) {
            System.out.println("Invalid birthdate format. Exiting.");
            return;
        }

        if (position == 1) {
            System.out.print("Enter Teacher's ID: ");
            String teacherId = scanner.nextLine();

            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();

            System.out.print("Enter Status (Full Time/Part Time): ");
            String status = scanner.nextLine();

            Teacher teacher = new Teacher(firstName, lastName, gender, birthdate, teacherId, specialization, status);
            displayTeacherInfo(teacher);
        } else if (position == 2) {
            System.out.print("Enter NTP's ID: ");
            String ntpId = scanner.nextLine();

            System.out.print("Enter Position: ");
            String ntpPosition = scanner.nextLine();

            System.out.print("Enter Office: ");
            String office = scanner.nextLine();

            NTP ntp = new NTP(firstName, lastName, gender, birthdate, ntpId, ntpPosition, office);
            displayNTPInfo(ntp);
        } else {
            System.out.println("Invalid position entered.");
        }
    }

    private static LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use MM-DD-YYYY.");
            return null;
        }
    }

    private static void displayTeacherInfo(Teacher teacher) {
        String genderPrefix = (teacher.getGender() == 'M' || teacher.getGender() == 'm') ? "Mr." : "Ms.";
        String genderPronoun = (teacher.getGender() == 'M' || teacher.getGender() == 'm') ? "He" : "She";

        System.out.println("\nTeacher Information:");
        System.out.println("ID: " + teacher.getTeacherId());
        System.out.println("Name: " + genderPrefix + " " + teacher.getFirstName() + " " + teacher.getLastName());
        System.out.println("Gender: " + teacher.getGender());
        System.out.println("Birthdate: " + teacher.getBirthdate());
        System.out.println("Age: " + teacher.getAge());
        System.out.println(genderPrefix + " " + teacher.getFirstName() + ", specialization is " + teacher.getSpecialization() +
                            " and currently working " + teacher.getStatus() + ". " + genderPronoun + " has a salary of " + teacher.getSalary());
    }

    private static void displayNTPInfo(NTP ntp) {
        String genderPrefix = (ntp.getGender() == 'M' || ntp.getGender() == 'm') ? "Mr." : "Ms.";

        System.out.println("\nNTP Information:");
        System.out.println("ID: " + ntp.getNtpId());
        System.out.println("Name: " + genderPrefix + " " + ntp.getFirstName() + " " + ntp.getLastName());
        System.out.println("Gender: " + ntp.getGender());
        System.out.println("Birthdate: " + ntp.getBirthdate());
        System.out.println("Age: " + ntp.getAge());
        System.out.println(genderPrefix + " " + ntp.getFirstName() + ", is working on the " + ntp.getOffice() + " as a " + ntp.getPosition());
    }
}