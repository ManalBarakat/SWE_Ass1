import java.util.Scanner;
import java.util.ArrayList;

class PRODUCT {
    private String NAME;
    private int PRICE;

    public PRODUCT(String NAME, int PRICE) {
        if (PRICE < 0)  System.out.println("Price cannot be negative");
        this.NAME = NAME;
        this.PRICE = PRICE;
    }

    public String getNAME() {return NAME;}
    public int getPRICE() {return PRICE;}
    public void setPRICE(int PRICE) {this.PRICE = PRICE;}
}

class CARTitem{
    private PRODUCT product;
    private int quantity;

    public CARTitem(PRODUCT product , int quantity){
        if(quantity<0)  System.out.println("Quantity cannot be negative");
        this.product = product;
        this.quantity = quantity;
    }
    public String getNAME() {return product.getNAME();}
    public double GetTotalPrice(){return (int)product.getPRICE() * quantity;}
    public String toString(){
        return String.format("║ %-15s ║ %-10d ║ %-10d ║", getNAME(), quantity, (int)GetTotalPrice());    }
}

class Store{
    private ArrayList<PRODUCT> products = new ArrayList<>() ;
    public Store() {
        products.add(new PRODUCT("Milk", 40));
        products.add(new PRODUCT("Bread", 5));
        products.add(new PRODUCT("Rice", 25));
        products.add(new PRODUCT("Sugar", 20));
        products.add(new PRODUCT("Oil", 50));
        products.add(new PRODUCT("Macaroni",30));
        products.add(new PRODUCT("Flour",30));
        products.add(new PRODUCT("Mango",30));
        products.add(new PRODUCT("Strawberry",45));}

    public void DisplayProducts(){
        System.out.println("\n\t      🛒  Products  🛒       ");
        System.out.println("╔═══════════════════════╦══════════════╗");
        System.out.printf("║ %-21s ║ %-12s ║\n", "PRODUCT NAME", "PRICE (EGP)");
        System.out.println("╠═══════════════════════╬══════════════╣");

        for (PRODUCT p : products) {
            System.out.printf("║ %-21s ║ %-12d ║\n",
                    p.getNAME(),
                    p.getPRICE()); }
        System.out.println("╚═══════════════════════╩══════════════╝");
    }

    public void addProduct(String name, int price) {
        products.add(new PRODUCT(name, price));
    }

    public PRODUCT findProduct(String NAME){
        for (PRODUCT p : products) {
            if (p.getNAME().equalsIgnoreCase(NAME))
                return p; }
        return null; }
}
class Cart {
    private ArrayList<CARTitem> items = new ArrayList<>();
    private int deliveryFee = 0;
    private String orderType = "Pickup";

    public void setOrderType(int choice) {
        if (choice == 1) {
            this.orderType = "Delivery";
            this.deliveryFee = 40; }
        else {
            this.orderType = "Pickup";
            this.deliveryFee = 0;}
    }

    public void addItem(PRODUCT product, int quantity) {
        CARTitem item = new CARTitem(product, quantity);
        items.add(item);
        System.out.println(product.getNAME() + " (x" + quantity + ") Added to Cart.");
    }

    public void removeItem(String name) {
        boolean removed = false;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNAME().equalsIgnoreCase(name)) {
                items.remove(i);
                removed = true;
                System.out.println("Removed successfully.");
                break;}
        }

        if (!removed)
            System.out.println("Product not found in cart."); }

    public void viewCart() {
        if (items.isEmpty()) { System.out.println("Cart is Empty!"); return; }
        System.out.println("╔═════════════════╦════════════╦════════════╗");
        System.out.println("║ Product         ║ Quantity   ║ Subtotal   ║");
        System.out.println("╠═════════════════╬════════════╬════════════╣");
        for (CARTitem item : items) System.out.println(item);
        System.out.println("╚═════════════════╩════════════╩════════════╝");
    }

    public void checkout() {
        int total = 0;
        for (CARTitem item : items)
            total += item.GetTotalPrice();

        double discount = 0;
        if (total > 1000)
            discount = total * 0.10;
        double finalTotal = total - discount + deliveryFee;

        System.out.println("\n******* FINAL RECEIPT *******");
        System.out.println("Order Type: " + orderType);
        System.out.println("Items Total: " + total + " EGP");
        System.out.println("Discount:    -" +discount + " EGP");
        System.out.println("Delivery:    +" + deliveryFee + " EGP");
        System.out.println("-----------------------------");
        System.out.println("NET TOTAL:   " + finalTotal + " EGP");
        System.out.println("*****************************");}
}

public class Main {
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Store store = new Store();
    Cart cart = new Cart();
    String adminPass = "2006";
    int choice;

    do {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       WELCOME TO OUR SUPERMARKET       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  [1] Show Products                     ║");
        System.out.println("║  [2] Add Product to Cart               ║");
        System.out.println("║  [3] Remove Product from Cart          ║");
        System.out.println("║  [4] View Cart                         ║");
        System.out.println("║  [5] Checkout (Shipping/Pickup)        ║");
        System.out.println("║  [6] Admin Settings (Password Required)║");
        System.out.println("║  [7] Exit                              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("➤ Choose option: ");

         choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                store.DisplayProducts();
                break;

            case 2:
                System.out.println("Enter product name: ");
                String name = input.nextLine();
                PRODUCT product = store.findProduct(name);

                if (product == null) {
                    System.out.println("Product not available.");
                    break; }

                System.out.println("Enter quantity: ");
                int quantity = input.nextInt();
                input.nextLine();

                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative!");
                    break; }
                cart.addItem(product, quantity);
                break;

            case 3:
                System.out.print("Enter product name to remove: ");
                String removeName = input.nextLine();
                cart.removeItem(removeName);
                break;

            case 4:
                cart.viewCart();
                break;

            case 5:
                System.out.println("How do you want to receive your order?");
                System.out.println("1- Delivery (+40 EGP)");
                System.out.println("2- Pickup from Store (Free)");
                System.out.print("➤ Choice: ");
                cart.setOrderType(input.nextInt());
                cart.checkout();
                break;

            case 6:
                System.out.print("Enter Admin Password: ");
                String pass = input.nextLine();

                if (pass.equals(adminPass)) {
                    System.out.println("\n--- ️ Welcome Admin ---");
                    System.out.println("1- Change Product Price");
                    System.out.println("2- Add New Product to Store");
                    System.out.print("➤ Choice: ");
                    int adminChoice = input.nextInt();
                    input.nextLine();

                    if (adminChoice == 1) {
                        System.out.print("Enter product name to change its price: ");
                        String pName = input.nextLine();
                        PRODUCT p = store.findProduct(pName);

                        if (p != null) {
                            System.out.print("Enter new price for " + p.getNAME() + ": ");
                            int newPrice = input.nextInt();
                            p.setPRICE(newPrice);
                            System.out.println("Price updated successfully!");
                        } else {
                            System.out.println("Product not found!");
                        }

                    } else if (adminChoice == 2) {
                        System.out.print("Enter new product name: ");
                        String newName = input.nextLine();

                        if (store.findProduct(newName) != null) {
                            System.out.println("This product already exists!");
                        } else {
                            System.out.print("Enter price for " + newName + ": ");
                            int newP = input.nextInt();
                            store.addProduct(newName, newP);
                            System.out.println(newName + " added to store!");}
                    }
                } else {
                    System.out.println("Wrong password! Access Denied.");}
                break;

            case 7:
                System.out.println("Thank You, Visit Us Anytime!");
                break;

            default:
                System.out.println("Invalid Choise.");}
    }
        while (choice != 7);
        input.close();}
     }
