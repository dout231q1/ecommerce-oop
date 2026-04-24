import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;

    public Cart(){
        products = new ArrayList<>();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public void removeProduct(String name){
        products.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }
    public void isEmpty(){
        if(products.isEmpty()){
            System.out.println("Cart is empty.");
        }
    }
    public void displayProducts(){
        for(Product product : products){
            System.out.println(product.toString());
        }
    }
    public double getTotalPrice(){
        double totalPrice = 0;
        for(Product product : products) {
            totalPrice += product.getPrice();
        }
        System.out.println("Total price: $" + totalPrice);
        return totalPrice;
    }
    public void clearCart(){
        products.clear();
        System.out.println("Cart cleared!");
    }
}
