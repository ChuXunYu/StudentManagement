package src;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 表示订单的类
 */
public class Order implements Iterable<OrderItem> {
    
    private ArrayList<OrderItem> items;
    
    /**
     * 构造函数
     */
    public Order() {
        items = new ArrayList<OrderItem>();
    }
    
    /**
     * 添加订单项
     * @param orderItem 订单项
     */
    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }
    
    /**
     * 获取订单项数量
     * @return 订单项数量
     */
    public int getNumberOfItems() {
        return items.size();
    }
    
    /**
     * 获取订单总价值
     * @return 订单总价值
     */
    public double getTotalCost() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getValue();
        }
        return total;
    }
    
    @Override
    public Iterator<OrderItem> iterator() {
        return items.iterator();
    }
    
    @Override
    public String toString() {
        return "Order with " + getNumberOfItems() + " items.";
    }
} 