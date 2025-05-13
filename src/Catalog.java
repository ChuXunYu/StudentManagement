package src;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 表示产品目录的类
 */
public class Catalog implements Iterable<Product> {

    private ArrayList<Product> products;

    /**
     * 构造函数
     */
    public Catalog() {
        products = new ArrayList<Product>();
    }

    /**
     * 添加产品到目录
     * @param product 要添加的产品
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * 根据产品代码获取产品
     * @param code 产品代码
     * @return 找到的产品，如果不存在返回null
     */
    public Product getProduct(String code) {
        for (Product product : products) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    /**
     * 获取目录中的产品数量
     * @return 产品数量
     */
    public int getNumberOfProducts() {
        return products.size();
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
} 