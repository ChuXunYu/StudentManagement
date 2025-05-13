package src;

import java.io.IOException;

/**
 * 产品目录加载器接口
 */
public interface CatalogLoader {
    
    /**
     * 从指定的文件加载产品目录
     * @param filename 文件名
     * @return 加载的产品目录
     * @throws DataFormatException 如果数据格式不正确
     * @throws IOException 如果出现I/O错误
     */
    public Catalog loadCatalog(String filename) 
            throws DataFormatException, IOException;
} 