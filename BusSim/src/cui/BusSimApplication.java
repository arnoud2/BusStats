package cui;

import java.util.InputMismatchException;
import java.util.Scanner;
import domein.DomeinController;

public class BusSimApplication {
    
    private final Scanner input = new Scanner(System.in);
    private final DomeinController dm;

    public BusSimApplication(DomeinController dm) {
        this.dm = dm;
    }

    public void Start() {
        int option;

        while (true) {
            displayMenu();
            
            try {
                System.out.print("Choose an option: ");
                option = input.nextInt();
                
                switch (option) {
                    case 1 -> runSimulation();
                    case 2 -> dm.showData();
                    case 3 -> addBuyer();
                    case 4 -> addSeller();
                    case 5 -> removeBuyer();
                    case 6 -> removeSeller();
                    case 7 -> {
                        System.out.println("Quitting...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                input.next();
            }
        }
    }

    private void runSimulation() {
        System.out.print("Enter surplus value: ");
        int surplus = input.nextInt();
        System.out.print("Enter number of days: ");
        int daysInLoop = input.nextInt();

        System.out.println("\n--- Initial Market Data ---");
        dm.showData();  

        for (int i = 0; i < daysInLoop; i++) {
            dm.simulateMarket(surplus);
        }

        System.out.println("\n--- Final Market Data ---");
        dm.showData();  
    }

    private void addBuyer() {
        System.out.print("Enter spending range: ");
        int spendingRange = input.nextInt();
        dm.addBuyer(spendingRange);
    }

    private void addSeller() {
        System.out.print("Enter product count: ");
        int productCount = input.nextInt();
        System.out.print("Enter price range: ");
        int priceRange = input.nextInt();
        dm.addSeller(productCount, priceRange);
    }

    private void removeBuyer() {
        System.out.print("Enter buyer ID to remove: ");
        int idB = input.nextInt();
        dm.removeBuyer(idB);
    }

    private void removeSeller() {
        System.out.print("Enter seller ID to remove: ");
        int idS = input.nextInt();
        dm.removeSeller(idS);
    }

    private void displayMenu() {
        System.out.println("\n============================");
        System.out.println("       MARKET SIMULATOR");
        System.out.println("============================");
        System.out.println("1. Run Simulation");
        System.out.println("2. Show Market Data");
        System.out.println("3. Add a Buyer");
        System.out.println("4. Add a Seller");
        System.out.println("5. Remove a Buyer");
        System.out.println("6. Remove a Seller");
        System.out.println("7. Quit");
        System.out.println("============================");
    }
}
