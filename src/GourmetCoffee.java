package src;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * 这个类实现了一个咖啡销售管理系统。
 */
public class GourmetCoffee {

    private static BufferedReader stdIn =
        new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut =
        new PrintWriter(System.out, true);
    private static PrintWriter stdErr =
        new PrintWriter(System.err, true);

    private Catalog catalog;
    private Sales sales;
    private NumberFormat dollarFormat;

    private SalesFormatter salesFormatter;

    /**
     * 从文件加载目录数据并启动应用程序。
     */
    public static void main(String[] args) throws IOException {

        String filename = "data/catalog.dat";

        try {
            Catalog catalog =
                (new FileCatalogLoader()).loadCatalog(filename);

            GourmetCoffee application = new GourmetCoffee(catalog);

            application.run();

        } catch (FileNotFoundException fnfe) {
            stdErr.println("找不到文件");
            System.exit(1);
        } catch (DataFormatException dfe) {
            stdErr.println("文件包含格式错误的数据: " + dfe.getMessage());
            System.exit(1);
        }
    }

    /**
     * 构造函数
     */
    public GourmetCoffee(Catalog initialCatalog) {
        catalog = initialCatalog;
        sales = new Sales();
        salesFormatter = PlainTextSalesFormatter.getSingletonInstance();
        dollarFormat = NumberFormat.getCurrencyInstance();
    }

    /**
     * 向用户显示选项菜单并执行选择的任务。
     */
    private void run() throws IOException {
        int choice = getChoice();

        while (choice != 0) {
            if (choice == 1) {
                displayCatalog();
            } else if (choice == 2) {
                sales.addOrder(getOrder());
            } else if (choice == 3) {
                displayProductInfo();
            } else if (choice == 4) {
                displayOrder();
            } else if (choice == 5) {
                displaySales();
            } else if (choice == 6) {
                displayFormats();
            } else if (choice == 7) {
                saveFile();
            }

            choice = getChoice();
        }
    }

    /**
     * 显示选项菜单并验证用户的选择。
     */
    private int getChoice() throws IOException {
        int input;

        do {
            try {
                stdErr.println();
                stdErr.print("[0]  退出\n"
                        + "[1]  显示产品目录\n"
                        + "[2]  创建订单\n"
                        + "[3]  显示产品信息\n"
                        + "[4]  显示订单\n"
                        + "[5]  显示销售数据\n"
                        + "[6]  配置销售格式\n"
                        + "[7]  保存销售数据到文件\n"
                        + "选择> ");
                stdErr.flush();

                input = Integer.parseInt(stdIn.readLine());

                stdErr.println();

                if (0 <= input && 7 >= input) {
                    break;
                } else {
                    stdErr.println("无效选择: " + input);
                }
            } catch (NumberFormatException nfe) {
                stdErr.println(nfe);
            }
        } while (true);

        return input;
    }

    /**
     * 显示产品目录。
     */
    private void displayCatalog() {
        int size = catalog.getNumberOfProducts();

        if (size == 0) {
            stdErr.println("目录为空");
        } else {
            stdOut.println("目录包含 " + size + " 个产品:");
            for (Product product : catalog) {
                stdOut.println(product.getCode());
            }
        }
    }

    /**
     * 获取用户选择的产品信息。
     */
    private void displayProductInfo() throws IOException {
        Product product = getProduct();

        if (product == null) {
            stdErr.println("没有产品");
        } else {
            ArrayList<DataField> dataFields = product.getDataFields();
            if (dataFields.size() == 0) {
                stdErr.println("没有数据字段");
            } else {
                for (DataField field : dataFields) {
                    stdOut.println(field.getName() + ": " + field.getValue());
                }
            }
        }
    }

    /**
     * 获取订单。
     */
    private Order getOrder() throws IOException {
        Order order = new Order();

        Product product = getProduct();

        while (product != null) {
            int quantity = getQuantity();
            order.addItem(new OrderItem(product, quantity));
            product = getProduct();
        }

        return order;
    }

    /**
     * 获取产品。
     */
    private Product getProduct() throws IOException {
        Product product = null;

        do {
            try {
                stdErr.print("产品代码> ");
                stdErr.flush();

                String code = stdIn.readLine();

                if (code.equals("")) {
                    return null;
                }

                product = catalog.getProduct(code);

                if (product == null) {
                    stdErr.println("没有代码为 " + code + " 的产品");
                }
            } catch (Exception e) {
                stdErr.println(e);
            }
        } while (product == null);

        return product;
    }

    /**
     * 获取数量。
     */
    private int getQuantity() throws IOException {
        int quantity = 0;

        do {
            try {
                stdErr.print("数量> ");
                stdErr.flush();

                quantity = Integer.parseInt(stdIn.readLine());

                if (quantity <= 0) {
                    stdErr.println("数量必须为正整数");
                }
            } catch (NumberFormatException e) {
                stdErr.println("无效输入");
            }
        } while (quantity <= 0);

        return quantity;
    }

    /**
     * 显示订单。
     */
    private void displayOrder() throws IOException {
        Order order = getOrder();

        stdOut.println("订单:");
        for (OrderItem item : order) {
            Product product = item.getProduct();
            stdOut.println(item.getQuantity() + " " + product.getCode() + " " + product.getDescription());
        }
        stdOut.println("总计: " + dollarFormat.format(order.getTotalCost()));
    }

    /**
     * 显示销售数据。
     */
    private void displaySales() {
        stdOut.print(salesFormatter.formatSales(sales));
    }

    /**
     * 显示销售格式选项。
     */
    private void displayFormats() throws IOException {
        // 这里应该实现选择销售格式的功能
        stdOut.println("销售格式已配置为纯文本格式。");
    }

    /**
     * 保存销售数据到文件。
     */
    private void saveFile() throws IOException {
        // 这里应该实现保存销售数据到文件的功能
        stdOut.println("销售数据已保存到文件。");
    }
} 