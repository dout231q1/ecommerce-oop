public class BoletoPayment implements PaymentMethod {
    @Override
    public double pay(double amount){
        System.out.println("$" + amount + " payment made via boleto.");
        return amount;
    }
}
