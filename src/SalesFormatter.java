package src;

/**
 * 销售数据格式化器接口
 */
public interface SalesFormatter {
    /**
     * 格式化销售数据
     * @param sales 销售数据
     * @return 格式化后的字符串
     */
    public String formatSales(Sales sales);
} 