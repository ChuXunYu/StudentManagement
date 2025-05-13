package src;

import java.text.NumberFormat;

/**
 * 纯文本格式的销售数据格式化器
 */
public class PlainTextSalesFormatter implements SalesFormatter {
    
    private static PlainTextSalesFormatter singletonInstance;
    
    /**
     * 私有构造函数（单例模式）
     */
    private PlainTextSalesFormatter() {
    }
    
    /**
     * 获取单例实例
     * @return 单例实例
     */
    public static synchronized PlainTextSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new PlainTextSalesFormatter();
        }
        return singletonInstance;
    }
    
    @Override
    public String formatSales(Sales sales) {
        StringBuilder result = new StringBuilder();
        
        result.append("----------------------------\n");
        result.append("Number of orders: ").append(sales.getNumberOfOrders()).append("\n");
        
        double totalSales = 0.0;
        for (Order order : sales) {
            totalSales += order.getTotalCost();
        }
        
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        result.append("Total sales: ").append(currencyFormatter.format(totalSales)).append("\n");
        result.append("----------------------------\n");
        
        return result.toString();
    }
} 