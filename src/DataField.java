package src;

/**
 * 表示名称-值对的数据字段
 */
public class DataField {

    private String name;
    private String value;

    /**
     * 构造函数
     * @param initialName 字段名称
     * @param initialValue 字段值
     */
    public DataField(String initialName, String initialValue) {
        this.name = initialName;
        this.value = initialValue;
    }

    /**
     * 获取字段名称
     * @return 字段名称
     */
    public String getName() {
        return name;
    }

    /**
     * 获取字段值
     * @return 字段值
     */
    public String getValue() {
        return value;
    }
} 