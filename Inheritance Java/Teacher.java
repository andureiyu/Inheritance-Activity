import java.time.*;
/**
 *
 * @author mapninora
 */
public class Teacher extends Person {
   private String teacherID;
    private String specialization;
    private String status;

    public Teacher(String firstName, String lastName, char gender, LocalDate birthdate, String teacherID, String specialization, String status) {
        super(firstName, lastName, gender, birthdate);
        this.teacherID = teacherID;
        this.specialization = specialization;
        this.status = status;
    }

    public String getTeacherId() {
        return teacherID;
    }

    public void setTeacherId(String teacherId) {
        this.teacherID = teacherId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalary() {
        if (status.equalsIgnoreCase("Full Time")) {
            return "20,000 per month";
        } else if (status.equalsIgnoreCase("Part Time")) {
            return "10,000 per month";
        } else {
            return "N/A";
        }
    }
}