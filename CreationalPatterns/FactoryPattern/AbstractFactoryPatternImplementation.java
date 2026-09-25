
interface Payment
{
    void pay(int amount);
}
interface Notification
{
    void sendNotification();
}
interface RefundProcessor
{
    void initiateRefund();
}

class RazorPay implements Payment
{
    @Override
    public void pay(int amount)
    {
        System.out.println("Payment initiated via RazorPay");
    }
}

class Stripe implements Payment
{
    @Override
    public void pay(int amount)
    {
        System.out.println("Payment initiated via Stripe");
    }
}

class RazorpayNotification implements Notification
{
    public void sendNotification()
    {
        System.out.println("Notification is send via SMS");
    }
}

class StripeNotification implements Notification
{
    public void sendNotification()
    {
        System.out.println("Notification is send via Email");
    }
}

class RazorpayRefundProcessor implements RefundProcessor
{
    @Override
    public void initiateRefund()
    {
        System.out.println("Refund initiated via Razorpay");
    }
}

class StripeRefundProcessor implements RefundProcessor
{
    @Override
    public void initiateRefund()
    {
        System.out.println("Refund initiated via Stripe");
    }
}

abstract class PaymentGateWayFactory
{
    abstract Payment createPayment();
    abstract Notification createNotification();
    abstract RefundProcessor createRefundProcessor();
}

class FactoryProducer
{
    static PaymentGateWayFactory getFactory(String country)
    {
        switch(country)
        {
            case "India":
                return new RazorPayFactory();

            case "US":
                return new StripeFactory();

            default:
                throw new IllegalArgumentException();
        }
    }
}

class RazorPayFactory extends PaymentGateWayFactory
{
    public Payment createPayment()
    {
        return new RazorPay();
    }

    public Notification createNotification()
    {
        return new RazorpayNotification();
    }

    public RefundProcessor createRefundProcessor()
    {
        return new RazorpayRefundProcessor();
    }
}

class StripeFactory extends PaymentGateWayFactory
{
    public Payment createPayment()
    {
        return new Stripe();
    }

    public Notification createNotification()
    {
        return new StripeNotification();
    }

    public RefundProcessor createRefundProcessor()
    {
        return new StripeRefundProcessor();
    }
}

public class AbstractFactoryPatternImplementation {
    public static void main(String args[])
    {
        PaymentGateWayFactory paymentFactory=FactoryProducer.getFactory("India");
        Payment payment=paymentFactory.createPayment();
        payment.pay(100);
        Notification notification=paymentFactory.createNotification();
        notification.sendNotification();
        RefundProcessor validation=paymentFactory.createRefundProcessor();
        validation.initiateRefund();
    }
}
