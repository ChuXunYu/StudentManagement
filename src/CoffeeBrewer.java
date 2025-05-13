package src;

import java.util.ArrayList;

/**
 * 表示咖啡机产品的类
 */
public class CoffeeBrewer extends Product {

    private String model;
    private String waterSupply;
    private int numberOfCups;

    /**
     * 默认构造函数
     */
    public CoffeeBrewer() {
        super();
        this.model = null;
        this.waterSupply = null;
        this.numberOfCups = 0;
    }

    /**
     * 带参数的构造函数
     */
    public CoffeeBrewer(String initialCode, String initialDescription, double initialPrice,
                        String initialModel, String initialWaterSupply, int initialNumberOfCups) {
        super(initialCode, initialDescription, initialPrice);
        this.model = initialModel;
        this.waterSupply = initialWaterSupply;
        this.numberOfCups = initialNumberOfCups;
    }

    /**
     * 获取咖啡机型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 获取咖啡机供水方式
     */
    public String getWaterSupply() {
        return waterSupply;
    }

    /**
     * 获取咖啡机容量（杯数）
     */
    public int getNumberOfCups() {
        return numberOfCups;
    }

    @Override
    public ArrayList<DataField> getDataFields() {
        ArrayList<DataField> dataFields = super.getDataFields();
        dataFields.add(new DataField("Model", model));
        dataFields.add(new DataField("Water Supply", waterSupply));
        dataFields.add(new DataField("Number of Cups", String.valueOf(numberOfCups)));
        return dataFields;
    }
} 