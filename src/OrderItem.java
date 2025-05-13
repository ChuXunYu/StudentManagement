package src;

/**
 * 表示订单项的类
 */
public class OrderItem {
    
    private Product product;
    private int quantity;
    
    /**
     * 构造函数
     * @param product 产品
     * @param quantity 数量
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    /**
     * 获取产品
     * @return 产品
     */
    public Product getProduct() {
        return product;
    }
    
    /**
     * 获取数量
     * @return 数量
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * 获取订单项的价值
     * @return 价值（价格*数量）
     */
    public double getValue() {
        return product.getPrice() * quantity;
    }
    
    @Override
    public String toString() {
        return quantity + " " + product;
    }
} 