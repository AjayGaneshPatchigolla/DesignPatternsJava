// This is simple factory method implementation which is not an actaul factory pattern. The main disadvantage for this pattern is every time a new class comes in we need to channge the factory class. so this violates open closed principle.
// interface Payment
// {
//     void pay(int amount);
// }
// class CreditCardPayment implements Payment
// {
//     @Override
//     public void pay(int amount)
//     {
//         System.out.println("Payment of: "+amount+" is done using Credit Card");
//     }
// }
// class DebitCardPayment implements Payment
// {
//     @Override
//     public void pay(int amount)
//     { 
//         System.out.println("Payment of: "+amount+" is done using Debit Card");
//     }
// }
// class UpiPayment implements Payment
// {
//     @Override
//     public void pay(int amount)
//     {
//         System.out.println("Payment of: "+amount+" is done using using UPI");
//     }
// }
// class PaymentFactory
// {
//     static Payment getPaymentType(String type)
//     {
//         switch(type)
//         {
//             case "CreditCard": 
//                 return new CreditCardPayment();
//             case "DebitCard":
//                 return new DebitCardPayment();
//             case "UPI":
//                 return new UpiPayment();
//             default:
//                 throw new RuntimeException("No Type is present for the given string");
//         }
//     }
// }
// public class FactoryPatternImplementation
// {
//     public static void main(String args[])
//     {
//         Payment payment=PaymentFactory.getPaymentType("UPI");
//         payment.pay(500);
//     }
// }

interface Payment
{
    void Pay(int amount);
}

abstract class PaymentFactory
{
    abstract Payment createPayment();
}
class CreditCardPaymentFactory extends PaymentFactory
{
    public Payment createPayment()
    {
        return new CreditCardPayment();
    }
}
class CreditCardPayment implements Payment
{
    @Override
    public void Pay(int amount)
    {
        System.out.println("Payment of: "+amount+" is done using Debit Card");
    }
}