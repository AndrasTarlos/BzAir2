import java.time.LocalDate;

public class Airplane {
    private Passenger[][] passengers;
    private String name;

    public Airplane(String name, int column, int row) {
        this.name = name;
        passengers = new Passenger[row][column];
    }

    public void addPassenger(int column, int row, String firstName, String lastName, int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        passengers[column][row] = new Passenger(firstName, lastName, date);
    }



    public String getName() {
        return name;
    }

    public int getLengthPassengersColumn() {
        return passengers[0].length - 1;
    }
    public int getLengthPassengersRow() {
        return passengers.length - 1;
    }

    public Passenger getPassenger(int column, int row) {
        return passengers[column][row];
    }

    public void setPassengers(Passenger[][] passengers) {
        this.passengers = passengers;
    }

    public void setName(String name) {
        this.name = name;
    }
}