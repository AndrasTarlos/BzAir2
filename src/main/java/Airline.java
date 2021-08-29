import com.github.javafaker.*;
import java.util.concurrent.ThreadLocalRandom;

public class Airline {
    private Reader rd;
    private Faker faker;
    private Airplane[] airplanes;

    public Airline() {
        faker = new Faker();
        System.out.println();
        rd = new Reader();
        airplanes = new Airplane[10];
        airplanes[0] = new Airplane("Vivek3000", 100, 6);
    }

    public static void main(String[] args) {
        Airline program = new Airline();
        program.run();
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            createPassengers(0);
            covidAction(0);
        }

    }

    public void createPassengers(int planeId) {
        // Create passengers
        for (int i = 0; i < airplanes[planeId].getLengthPassengersColumn(); i++) {
            for (int j = 0; j < airplanes[planeId].getLengthPassengersRow(); j++) {
                airplanes[planeId].addPassenger(i, j, faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(1900, 2021), faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 31));
            }
        }

        // Set Covid Victim
        int covidVictimColumn = ThreadLocalRandom.current().nextInt(0, airplanes[0].getLengthPassengersColumn());
        int covidVictimRow = ThreadLocalRandom.current().nextInt(0, airplanes[0].getLengthPassengersRow());
        airplanes[0].getPassenger(covidVictimColumn, covidVictimRow).setInfected(true);
    }

    public void covidAction(int planeId) {
        // Find covid victim
        for (int i = 0; i < airplanes[planeId].getLengthPassengersColumn(); i++) {
            for (int j = 0; j < airplanes[planeId].getLengthPassengersRow(); j++) {
                if (airplanes[planeId].getPassenger(i, j).isInfected()) {
                    System.out.println("\n" + airplanes[planeId].getPassenger(i, j).getFirstName() + " " + airplanes[planeId].getPassenger(i, j).getLastName() + " / " + airplanes[planeId].getPassenger(i, j).getBirthDate() + " - " + "is infected!");

                    // Check if position exists
                    System.out.println(airplanes[planeId].getPassenger(i, j).getFirstName() + " " + airplanes[planeId].getPassenger(i, j).getLastName() + " / " + airplanes[planeId].getPassenger(i, j).getBirthDate() + " - " + "has to go to quarantine!");
                    if (i + 1 < airplanes[planeId].getLengthPassengersColumn()) {
                        System.out.println(airplanes[planeId].getPassenger(i + 1, j).getFirstName() + " " + airplanes[planeId].getPassenger(i + 1, j).getLastName() + " / " + airplanes[planeId].getPassenger(i + 1, j).getBirthDate() + " - " + "has to go to quarantine!");
                    }
                    if (i + 1 < airplanes[planeId].getLengthPassengersColumn() && j + 1 < airplanes[planeId].getLengthPassengersRow()) {
                        System.out.println(airplanes[planeId].getPassenger(i + 1, j + 1).getFirstName() + " " + airplanes[planeId].getPassenger(i + 1, j + 1).getLastName() + " / " + airplanes[planeId].getPassenger(i + 1, j + 1).getBirthDate() + " - " + "has to go to quarantine!");
                    }
                    if (j + 1 < airplanes[planeId].getLengthPassengersRow()) {
                        System.out.println(airplanes[planeId].getPassenger(i, j + 1).getFirstName() + " " + airplanes[planeId].getPassenger(i, j + 1).getLastName() + " / " + airplanes[planeId].getPassenger(i, j + 1).getBirthDate() + " - " + "has to go to quarantine!");
                    }
                    if (0 <= i - 1 && j + 1 < airplanes[planeId].getLengthPassengersRow()) {
                        System.out.println(airplanes[planeId].getPassenger(i - 1, j + 1).getFirstName() + " " + airplanes[planeId].getPassenger(i - 1, j + 1).getLastName() + " / " + airplanes[planeId].getPassenger(i - 1, j + 1).getBirthDate() + " - " + "has to go to quarantine!");
                    }
                    if (0 <= i - 1) {
                        System.out.println(airplanes[planeId].getPassenger(i - 1, j).getFirstName() + " " + airplanes[planeId].getPassenger(i - 1, j).getLastName() + " / " + airplanes[planeId].getPassenger(i - 1, j).getBirthDate() + " - " + "has to go to quarantine!");
                    }
                    if (0 <= i - 1 && 0 <= j - 1) {
                        System.out.println(airplanes[planeId].getPassenger(i - 1, j - 1).getFirstName() + " " + airplanes[planeId].getPassenger(i - 1, j - 1).getLastName() + " / " + airplanes[planeId].getPassenger(i - 1, j - 1).getBirthDate() + " - " + "has to go to quarantine!");
                    }
                    if (0 <= j - 1) {
                        System.out.println(airplanes[planeId].getPassenger(i, j - 1).getFirstName() + " " + airplanes[planeId].getPassenger(i, j - 1).getLastName() + " / " + airplanes[planeId].getPassenger(i, j - 1).getBirthDate() + " - " + "has to go to quarantine!");
                    }
                    if (i + 1 < airplanes[planeId].getLengthPassengersColumn() && 0 <= j - 1) {
                        System.out.println(airplanes[planeId].getPassenger(i + 1, j - 1).getFirstName() + " " + airplanes[planeId].getPassenger(i + 1, j - 1).getLastName() + " / " + airplanes[planeId].getPassenger(i + 1, j - 1).getBirthDate() + " - " + "has to go to quarantine!");
                    }
                }
            }
        }
    }
}
