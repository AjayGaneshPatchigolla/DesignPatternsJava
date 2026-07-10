enum ProductType
{
    ELECTRONICS, FASHION, GROCERY;
}
class Product
{
    private int productId;
    private int productPrice;
    private String productName;
    private ProductType ProductType;
    private Product(Builder builder)
    {
        this.productId=builder.productId;
        this.productPrice=builder.productPrice;
        this.productName=builder.productName;
        this.ProductType=builder.productType;
    }

    @Override
    public String toString()
    {
        return "Product Details:\n"+"ProductId: "+this.productId+"\nProductPrice: "+this.productPrice+"\nProductName: "+this.productName+"\nProductType: "+this.ProductType;
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