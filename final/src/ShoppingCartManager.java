import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        // Prompt user for customer name
        System.out.print("Enter customer name: ");
        String customerName = scnr.nextLine();
        
        // Prompt user for today's date
        System.out.print("Enter today's date (e.g. January 1, 2022): ");
        String currentDate = scnr.nextLine();
        
        // Output customer name and date
        System.out.println("Customer name: " + customerName);
        System.out.println("Today's date: " + currentDate);
        
        // Create ShoppingCart object
        ShoppingCart cart = new ShoppingCart(customerName, currentDate);
        
        char choice = ' ';
        while (choice != 'q') {
            printMenu();
            System.out.println("Choose an option:");
            choice = scnr.nextLine().charAt(0);
            executeMenu(choice, cart, scnr);
        }
    }

    public static void printMenu() {
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println("q - Quit");
        System.out.println();
    }

    public static void executeMenu(char choice, ShoppingCart cart, Scanner scnr) {
        switch (choice) {
            case 'o':
                System.out.println("OUTPUT SHOPPING CART");
                cart.printTotal();
                break;
            case 'i':
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                cart.printDescriptions();
                break;
            case 'a':
                System.out.println("ADD ITEM TO CART");
                System.out.println("Enter the item name:");
                String itemName = scnr.nextLine();
                System.out.println("Enter the item description:");
                String itemDescription = scnr.nextLine();
                System.out.println("Enter the item price:");
                int itemPrice = scnr.nextInt();
                System.out.println("Enter the item quantity:");
                int itemQuantity = scnr.nextInt();
                scnr.nextLine(); // Consume the new line character
                System.out.println("Item added.");
                ItemToPurchase newItem = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
                cart.addItem(newItem);
                break;
            case 'd':
                System.out.println("REMOVE ITEM FROM CART");
                System.out.println("Enter name of item to remove:");
                String itemNameToRemove = scnr.nextLine();
                cart.removeItem(itemNameToRemove);
                System.out.println("Item removed.");
                break;
            case 'c':
                System.out.println("CHANGE ITEM QUANTITY");
                System.out.println("Enter the item name:");
                String itemNameToModify = scnr.nextLine();
                System.out.println("Enter the new quantity:");
                int itemQuantityToModify = scnr.nextInt();
                scnr.nextLine(); // Consume the new line character
                ItemToPurchase itemToModify = new ItemToPurchase(itemNameToModify, "", 0, itemQuantityToModify);
                cart.modifyItem(itemToModify);
                break;
            case 'q':
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
        System.out.println();
    }
}
