#!/bin/bash

# 咖啡销售管理系统构建脚本

echo "开始构建咖啡销售管理系统..."

# 创建构建目录
mkdir -p build/classes
echo "创建构建目录..."

# 编译Java文件
echo "编译Java文件..."
javac -d build/classes -sourcepath src/main/java src/main/java/com/gourmetcoffee/GourmetCoffee.java

if [ $? -eq 0 ]; then
    echo "编译成功！"
    
    # 复制数据文件到构建目录
    echo "复制数据文件..."
    mkdir -p build/classes/data
    cp data/* build/classes/data/
    
    echo "构建完成！可以通过以下命令运行程序："
    echo "cd build/classes && java com.gourmetcoffee.GourmetCoffee"
else
    echo "编译失败！请检查错误信息。"
    exit 1
fi 