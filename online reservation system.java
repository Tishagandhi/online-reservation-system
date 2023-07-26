 import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ReservationSystem {
    private Map<String, Boolean> reservations;

    public ReservationSystem() {
        reservations = new HashMap<>();
    }

    public void makeReservation(String name) {
        if (reservations.containsKey(name)) {
            System.out.println("Sorry, the name is already reserved.");
        } else {
            reservations.put(name, true);
            System.out.println("Reservation for " + name + " has been made.");
        }
    }

    public void cancelReservation(String name) {
        if (reservations.containsKey(name)) {
            reservations.remove(name);
            System.out.println("Reservation for " + name + " has been canceled.");
        } else {
            System.out.println("No reservation found for " + name + ".");
        }
    }

    public void displayReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("Current reservations:");
            for (String name : reservations.keySet()) {
                System.out.println(name);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("\nOnline Reservation System");
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Display reservations");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name for reservation: ");
                    String name = scanner.nextLine();
                    reservationSystem.makeReservation(name);
                    break;
                case 2:
                    System.out.print("Enter the name to cancel reservation: ");
                    name = scanner.nextLine();
                    reservationSystem.cancelReservation(name);
                    break;
                case 3:
                    reservationSystem.displayReservations();
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using the Online Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
