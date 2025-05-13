package src;

import java.util.ArrayList;

/**
 * 产品基类
 */
public class Product {

    private String code;
    private String description;
    private double price;

    /**
     * 默认构造函数
     */
    public Product() {
        this.code = null;
        this.description = null;
        this.price = 0.0;
    }

    /**
     * 带参数的构造函数
     */
    public Product(String initialCode, String initialDescription, double initialPrice) {
        this.code = initialCode;
        this.description = initialDescription;
        this.price = initialPrice;
    }

    /**
     * 获取产品代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取产品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 获取产品价格
     */
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (object == this) {
            return true;
        } else if (object instanceof Product) {
            Product product = (Product) object;
            return this.code.equals(product.code);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return code + "_" + description + "_" + price;
    }

    /**
     * 获取产品数据字段
     */
    public ArrayList<DataField> getDataFields() {
        ArrayList<DataField> dataFields = new ArrayList<DataField>();
        dataFields.add(new DataField("Code", code));
        dataFields.add(new DataField("Description", description));
        dataFields.add(new DataField("Price", String.valueOf(price)));
        return dataFields;
    }
} 