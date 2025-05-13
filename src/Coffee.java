package src;

import java.util.ArrayList;

/**
 * 表示咖啡产品的类
 */
public class Coffee extends Product {

    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    /**
     * 默认构造函数
     */
    public Coffee() {
        super();
        this.origin = null;
        this.roast = null;
        this.flavor = null;
        this.aroma = null;
        this.acidity = null;
        this.body = null;
    }

    /**
     * 带参数的构造函数
     */
    public Coffee(String initialCode, String initialDescription, double initialPrice,
                  String initialOrigin, String initialRoast, String initialFlavor,
                  String initialAroma, String initialAcidity, String initialBody) {
        super(initialCode, initialDescription, initialPrice);
        this.origin = initialOrigin;
        this.roast = initialRoast;
        this.flavor = initialFlavor;
        this.aroma = initialAroma;
        this.acidity = initialAcidity;
        this.body = initialBody;
    }

    /**
     * 获取咖啡产地
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 获取咖啡烘焙程度
     */
    public String getRoast() {
        return roast;
    }

    /**
     * 获取咖啡风味
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * 获取咖啡香气
     */
    public String getAroma() {
        return aroma;
    }

    /**
     * 获取咖啡酸度
     */
    public String getAcidity() {
        return acidity;
    }

    /**
     * 获取咖啡醇厚度
     */
    public String getBody() {
        return body;
    }

    @Override
    public ArrayList<DataField> getDataFields() {
        ArrayList<DataField> dataFields = super.getDataFields();
        dataFields.add(new DataField("Origin", origin));
        dataFields.add(new DataField("Roast", roast));
        dataFields.add(new DataField("Flavor", flavor));
        dataFields.add(new DataField("Aroma", aroma));
        dataFields.add(new DataField("Acidity", acidity));
        dataFields.add(new DataField("Body", body));
        return dataFields;
    }
} 