public class CreditCardPayment implements PaymentMethod{

    @Override
    public double pay(double amount){
        double taxRate = 0.05;
        double taxAmount = amount * taxRate;
        double amountAfterTax = amount + taxAmount;
                System.out.println("Calculating credit card tax...");
                System.out.println("Tax amount: " + "$" + taxAmount + " plus product's total: " + "$" + amount);
                System.out.println("Done!\n" + "$" + amountAfterTax + " payment made via Credit Card.");
                return amountAfterTax;
    }
}
