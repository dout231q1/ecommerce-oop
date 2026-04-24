public class Clothing extends Product {
    private String clothingSize;

    public Clothing(String name, double price, String clothingSize) {
        super(name, price);
        this.clothingSize = clothingSize;
    }

    public String getClothingSize() {
        return clothingSize;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Price: " + "$" + getPrice() + ", Clothing Size: " + getClothingSize();
    }
}