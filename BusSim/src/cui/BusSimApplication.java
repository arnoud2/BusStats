package cui;

import java.util.InputMismatchException;
import java.util.Scanner;

import domein.DomeinController;

public class BusSimApplication {
    
    private Scanner input = new Scanner(System.in);
    private DomeinController dm;
    
    public BusSimApplication(DomeinController dm) {
        this.dm = dm;
    }

    public void Start() {
        int option;

        while (true) {
            choices();
            
            try {
                System.out.print("Choose an option: ");
                option = input.nextInt();
                
                switch (option) {
                    case 1 -> dm.showData();
                    case 2 -> dm.addBuyer();
                    case 3 -> dm.addSeller();
                    case 4 -> dm.removeBuyer();
                    case 5 -> dm.removeSeller();
                    case 6 -> {
                        System.out.println("Quitting");
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

    private void choices() {
        String[] choiceLines = {
            "1. Show sales", 
            "2. Add a new buyer", 
            "3. Add a new seller", 
            "4. Remove buyer", 
            "5. Remove seller", 
            "6. Quit"
        };
        
        for (String choice : choiceLines) {
            System.out.println(choice);
        }       
    }
}