import java.util.ArrayList;

public class ShoppingCart {
    private String customerName;
    private String currentDate;
    private ArrayList<ItemToPurchase> cartItems;
    
    public ShoppingCart() {
        customerName = "none";
        currentDate = "January 1, 2016";
        cartItems = new ArrayList<ItemToPurchase>();
    }
    
    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
        cartItems = new ArrayList<ItemToPurchase>();
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public String getDate() {
        return currentDate;
    }
    
    public void addItem(ItemToPurchase item) {
        cartItems.add(item);
    }
    
    public void removeItem(String itemName) {
        boolean found = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getName().equals(itemName)) {
                cartItems.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in cart. Nothing removed.");
        } else {
            System.out.println("Item quantity modified.");
        }
    }
    
    public void modifyItem(ItemToPurchase item) {
        boolean found = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getName().equals(item.getName())) {
                if (!item.getDescription().equals("none")) {
                    cartItems.get(i).setDescription(item.getDescription());
                }
                if (item.getPrice() != 0) {
                    cartItems.get(i).setPrice(item.getPrice());
                }
                if (item.getQuantity() != 0) {
                    cartItems.get(i).setQuantity(item.getQuantity());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in cart. Nothing modified.");
        }
    }
    
    public int getNumItemsInCart() {
        int numItems = 0;
        for (ItemToPurchase item : cartItems) {
            numItems += item.getQuantity();
        }
        return numItems;
    }
    
    public int getCostOfCart() {
        int totalCost = 0;
        for (ItemToPurchase item : cartItems) {
            totalCost += (item.getPrice() * item.getQuantity());
        }
        return totalCost;
    }
    
    public void printTotal() {
        int totalCost = getCostOfCart();
        if (cartItems.size() == 0) {
            System.out.println("SHOPPING CART IS EMPTY");
        } else {
            System.out.println(customerName + "'s Shopping Cart - " + currentDate);
            System.out.println("Number of Items: " + getNumItemsInCart());
            System.out.println();
            for (ItemToPurchase item : cartItems) {
                System.out.println(item.getName() + " " + item.getQuantity() + " @ $" + item.getPrice() + " = $" + (item.getQuantity() * item.getPrice()));
            }
            System.out.println();
            System.out.println("Total: $" + totalCost);
        }
    }
    
    public void printDescriptions() {
        System.out.println("Item Descriptions");
        for (ItemToPurchase item : cartItems) {
            System.out.println(item.getName() + ": " + item.getDescription());
        }
    }
}
    
