public class ItemToPurchase {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;
    
    public ItemToPurchase() {
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
        itemDescription = "none";
    }
    
    //mutators and accessors
    public void setName(String name) {
        itemName = name;
    }
    
    public String getName() {
        return itemName;
    }
    
    public void setPrice(int price) {
        itemPrice = price;
    }
    
    public int getPrice() {
        return itemPrice;
    }
    
    public void setQuantity(int quantity) {
        itemQuantity = quantity;
    }
    
    public int getQuantity() {
        return itemQuantity;
    }

    public void setDescription(String description) {
        itemDescription = description;
    }

    public String getDescription() {
        return itemDescription;
    }
    
    public void printItemCost(ItemToPurchase item) {
        System.out.print(item.getName() + " " + item.getQuantity() + " @ $" + item.getPrice() + " = $" + (item.getQuantity() * item.getPrice()));
    }

    public void printItemDescription(ItemToPurchase item) {
        System.out.print(item.getName() + ": " + item.getDescription());
    }

    public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
    
}
