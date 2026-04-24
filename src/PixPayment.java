public class PixPayment implements PaymentMethod {
    @Override
    public double pay(double amount){
        System.out.println("$" + amount + " payment made via pix.");
        return amount;
    }
}
