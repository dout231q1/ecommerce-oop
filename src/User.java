import java.util.List;

public class User {
    private String name;
    private double balance;
    private Cart cart;

    public User(String name, double balance){
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public double getBalance(){
        return balance;
    }
    public Cart getCart(){
        return cart;
    }
    public void checkout(PaymentMethod payment){
        double total = cart.getTotalPrice();
        if(balance < total){
            System.out.println("You don't have enough money!");
            return;
        }
        double charged = payment.pay(total);
        balance -= charged;
    }
    public void addToCart(String name, List<Product> store){
        for(Product p : store){
            if(p.getName().equalsIgnoreCase(name)){
                cart.addProduct(p);
                return;
            }
        }
        System.out.println("Product not found!");
    }
}
