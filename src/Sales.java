package src;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 表示销售记录的类
 */
public class Sales implements Iterable<Order> {
    
    private ArrayList<Order> orders;
    
    /**
     * 构造函数
     */
    public Sales() {
        orders = new ArrayList<Order>();
    }
    
    /**
     * 添加订单到销售记录
     * @param order 订单
     */
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    /**
     * 获取订单数量
     * @return 订单数量
     */
    public int getNumberOfOrders() {
        return orders.size();
    }
    
    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }
} 