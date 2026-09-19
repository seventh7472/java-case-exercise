package com.steven;

public class CaseDemo7 {
    public static void main(String[] args) {
        //九九乘法表
        for (int x = 1; x < 10; x++) {//x代表行
            //特征：列 * 行 = 值
            for (int y = 1; y <x; y++) {
                System.out.print(y + "X" + x + "=" + (y * x) + "\t");
            }
            System.out.println();
        }

    }


    //打印三角形：

}
