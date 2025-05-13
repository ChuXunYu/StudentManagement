package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 从文件加载产品目录的类
 */
public class FileCatalogLoader implements CatalogLoader {
    
    /**
     * 从指定的文件加载产品目录
     * @param filename 文件名
     * @return 加载的产品目录
     * @throws DataFormatException 如果数据格式不正确
     * @throws IOException 如果出现I/O错误
     */
    @Override
    public Catalog loadCatalog(String filename) throws DataFormatException, IOException {
        Catalog catalog = new Catalog();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                
                if (tokenizer.hasMoreTokens()) {
                    String code = tokenizer.nextToken();
                    
                    if (code.startsWith("C")) {
                        // 这是咖啡产品
                        parseCoffee(catalog, code, tokenizer);
                    } else if (code.startsWith("B")) {
                        // 这是咖啡机产品
                        parseCoffeeBrewer(catalog, code, tokenizer);
                    } else {
                        // 这是一般产品
                        parseProduct(catalog, code, tokenizer);
                    }
                }
            }
        }
        
        return catalog;
    }
    
    /**
     * 解析咖啡产品数据
     */
    private void parseCoffee(Catalog catalog, String code, StringTokenizer tokenizer) 
            throws DataFormatException {
        try {
            String description = tokenizer.nextToken();
            double price = Double.parseDouble(tokenizer.nextToken());
            String origin = tokenizer.nextToken();
            String roast = tokenizer.nextToken();
            
            // 处理带引号的风味描述
            String flavor = parseQuotedToken(tokenizer);
            
            String aroma = tokenizer.nextToken();
            String acidity = tokenizer.nextToken();
            String body = tokenizer.nextToken();
            
            catalog.addProduct(new Coffee(code, description.replace('_', ' '), price, 
                    origin, roast, flavor, aroma, acidity, body));
        } catch (Exception e) {
            throw new DataFormatException("咖啡数据格式错误: " + e.getMessage());
        }
    }
    
    /**
     * 解析咖啡机产品数据
     */
    private void parseCoffeeBrewer(Catalog catalog, String code, StringTokenizer tokenizer) 
            throws DataFormatException {
        try {
            String description = tokenizer.nextToken();
            double price = Double.parseDouble(tokenizer.nextToken());
            String model = tokenizer.nextToken();
            String waterSupply = tokenizer.nextToken();
            int numberOfCups = Integer.parseInt(tokenizer.nextToken());
            
            catalog.addProduct(new CoffeeBrewer(code, description.replace('_', ' '), price, 
                    model, waterSupply, numberOfCups));
        } catch (Exception e) {
            throw new DataFormatException("咖啡机数据格式错误: " + e.getMessage());
        }
    }
    
    /**
     * 解析一般产品数据
     */
    private void parseProduct(Catalog catalog, String code, StringTokenizer tokenizer) 
            throws DataFormatException {
        try {
            String description = tokenizer.nextToken();
            double price = Double.parseDouble(tokenizer.nextToken());
            
            catalog.addProduct(new Product(code, description.replace('_', ' '), price));
        } catch (Exception e) {
            throw new DataFormatException("产品数据格式错误: " + e.getMessage());
        }
    }
    
    /**
     * 解析带引号的字符串
     */
    private String parseQuotedToken(StringTokenizer tokenizer) throws DataFormatException {
        String token = tokenizer.nextToken();
        
        if (token.startsWith("\"")) {
            StringBuilder quoted = new StringBuilder(token.substring(1));
            
            // 如果不是以引号结束，则继续读取
            while (!quoted.toString().endsWith("\"") && tokenizer.hasMoreTokens()) {
                quoted.append(" ").append(tokenizer.nextToken());
            }
            
            if (!quoted.toString().endsWith("\"")) {
                throw new DataFormatException("引号不匹配");
            }
            
            // 移除结尾的引号
            return quoted.substring(0, quoted.length() - 1);
        }
        
        return token;
    }
} 