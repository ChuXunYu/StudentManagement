package src;

/**
 * 表示数据格式错误的异常
 */
public class DataFormatException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 构造函数
     */
    public DataFormatException() {
        super();
    }
    
    /**
     * 带信息的构造函数
     * @param message 错误信息
     */
    public DataFormatException(String message) {
        super(message);
    }
    
    /**
     * 带原因的构造函数
     * @param cause 原因
     */
    public DataFormatException(Throwable cause) {
        super(cause);
    }
    
    /**
     * 带信息和原因的构造函数
     * @param message 错误信息
     * @param cause 原因
     */
    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }
} 