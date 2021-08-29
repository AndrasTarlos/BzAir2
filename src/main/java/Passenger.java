import java.time.LocalDate;

public class Passenger {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean infected;

    public Passenger(String firstName, String lastName, LocalDate birthDate) {
        infected = false;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
