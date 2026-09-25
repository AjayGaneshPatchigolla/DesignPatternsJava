enum ProductType
{
    ELECTRONICS, FASHION, GROCERY;
}
class Product
{
    // Make Product members immutable
    private final int productId;
    private final int productPrice;
    private final String productName;
    private final ProductType productType;
    private Product(Builder builder)
    {
        this.productId=builder.productId;
        this.productPrice=builder.productPrice;
        this.productName=builder.productName;
        this.productType=builder.productType;
    }

    @Override
    public String toString()
    {
        return "Product Details:\n"+"ProductId: "+this.productId+"\nProductPrice: "+this.productPrice+"\nProductName: "+this.productName+"\nProductType: "+this.productType;
    }

    static class Builder
    {
        private int productId;
        private int productPrice;
        private String productName;
        private ProductType productType;
        Builder()
        {

        }

        public Builder withProductId(int productId)
        {
            this.productId=productId;
            return this;
        }

        public Builder withProductPrice(int productPrice)
        {
            this.productPrice=productPrice;
            return this;

        }

        public Builder withProductName(String productName)
        {
            this.productName=productName;
            return this;

        }

        public Builder withProductType(ProductType productType)
        {
            this.productType=productType;
            return this;

        }

        public Product build()
        {
            if(productName==null)
                throw new IllegalStateException("Prodcutname cannot be null");
            if(productPrice<=0)
                throw new IllegalStateException("Price cannot be zero or negative");
            return new Product(this);
        }
    }
}
public class BuilderPatternImplementation
{
    public static void main(String args[])
    {
        Product product=new Product.Builder()
                                           .withProductId(1)
                                           .withProductName("Iphone 17 Pro Max")
                                           .withProductPrice(150000)
                                           .withProductType(ProductType.ELECTRONICS)
                                           .build();
        System.out.println(product);
    }
}