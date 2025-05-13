# 咖啡销售管理系统 (Gourmet Coffee Management System)

这是一个用Java开发的咖啡销售管理系统，允许用户管理咖啡产品目录、创建订单、查看销售报表等。

## 功能特性

- 咖啡和咖啡设备的产品目录管理
- 订单创建和管理
- 多种格式（纯文本、HTML、XML）的销售报表
- 可保存销售数据到文件
- 简单易用的交互界面

## 安装说明

### 前提条件

- Java JDK 8或更高版本
- Apache Ant (可选，用于构建)

### 安装步骤

1. 克隆仓库
   ```
   git clone https://github.com/yourusername/GourmetCoffeeManagement.git
   ```

2. 进入项目目录
   ```
   cd GourmetCoffeeManagement
   ```

3. 使用Ant构建项目 (如果有Ant)
   ```
   ant compile
   ```
   
   或手动编译Java文件
   ```
   mkdir -p build/classes
   javac -d build/classes src/*.java
   cp -r data build/
   ```

4. 运行应用程序
   ```
   # 使用Ant
   ant run
   
   # 或手动运行
   cd build/classes
   java src.GourmetCoffee
   ```

## 使用方法

启动程序后，你将看到一个菜单，提供以下选项：

- 显示产品目录
- 创建订单
- 显示产品信息
- 显示订单
- 显示销售报表
- 配置销售报表格式
- 保存销售数据到文件

## 项目结构

```
├── data/               # 数据文件
│   └── catalog.dat     # 产品目录数据
├── src/                # 源代码
│   ├── Catalog.java    # 产品目录
│   ├── Coffee.java     # 咖啡产品
│   ├── CoffeeBrewer.java # 咖啡机产品
│   ├── DataField.java  # 数据字段
│   ├── DataFormatException.java # 数据异常
│   ├── FileCatalogLoader.java   # 文件加载器
│   ├── GourmetCoffee.java       # 主程序
│   ├── Order.java               # 订单
│   ├── OrderItem.java           # 订单项
│   ├── PlainTextSalesFormatter.java # 格式化器
│   ├── Product.java             # 产品
│   ├── Sales.java               # 销售记录
│   └── SalesFormatter.java      # 格式化器接口
├── build.xml           # Ant构建文件
├── LICENSE             # 许可证文件
└── README.md           # 说明文档
```

## 贡献指南

欢迎贡献代码、报告问题或提出功能建议。请通过GitHub Issues提交问题，并通过Pull Requests提交代码更改。

## 许可证

该项目使用MIT许可证 - 详见 [LICENSE](LICENSE) 文件 