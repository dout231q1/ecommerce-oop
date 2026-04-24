import java.time.LocalDate;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();
        cart.addProduct(new Product("Keyboard", 80));
        cart.addProduct(new Product("Mouse", 50));
        cart.addProduct(new Food("Frozen Pizza", 50, LocalDate.of(2026, 5, 10)));
        cart.displayProducts();

        cart.removeProduct("Keyboard");
        System.out.println("\nAfter remove:");
        cart.displayProducts();
        System.out.println("\n");
        cart.clearCart();
        cart.isEmpty();
    }
}
