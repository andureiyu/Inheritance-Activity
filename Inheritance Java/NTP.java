import java.time.LocalDate;

/**
 *
 * @author mapninora
 */
public class NTP extends Person {
    private String ntpID;
    private String position;
    private String office;

    public NTP(String firstName, String lastName, char gender, LocalDate birthdate, String ntpID, String position, String office) {
        super(firstName, lastName, gender, birthdate);
        this.ntpID = ntpID;
        this.position = position;
        this.office = office;
    }
    public String getNtpId() {
        return ntpID;
    }

    public void setNtpId(String ntpId) {
        this.ntpID = ntpId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}