import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){

    // 1. build the store
        List<Product> store = new ArrayList<>();
        store.add(new Product("Keyboard", 80));
        store.add(new Product("Mouse", 60));
        store.add(new Electronics("TV", 200, 24));
        store.add(new Electronics("PC", 2500, 12));
        store.add(new Clothing("T-Shirt", 25, "G"));
        store.add(new Clothing("Jeans", 55, "M"));
        store.add(new Food("Frozen Pizza", 7, LocalDate.of(2026, 5, 10)));
        store.add(new Food("Doritos", 12, LocalDate.of(2026, 6, 15)));

    // 2. display available products
        System.out.println("=== Products Display ===");
        for(Product p : store) System.out.println(p);

    // 3. create user and add to cart
        User user = new User("Joao", 500);
        user.addToCart("Keyboard", store);
        user.addToCart("Mouse", store);
        user.addToCart("T-Shirt", store);

    // 4. display cart and total price
        System.out.println("\n=== Cart ===");
        user.getCart().displayProducts();
        user.getCart().getTotalPrice();

        // 5. checkout
        System.out.println("\n=== Payment ===");
        System.out.println("Balance: $" + user.getBalance());
        user.checkout(new CreditCardPayment());
        System.out.println("Remaining balance: $" + user.getBalance());
    }
}