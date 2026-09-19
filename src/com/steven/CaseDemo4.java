package com.steven;

import static jdk.nashorn.internal.objects.NativeArray.reverse;
import static jdk.nashorn.internal.objects.NativeString.split;

public class CaseDemo4 {
    public static void main(String[] args) {
        //数据加密：用时也是解密程序
        System.out.println("加密后的结果是： " + encrypt(1983));
    }
    
    public static String encrypt(int number) {//接受密码
        //number=1983
        //1.把密码拆分一个个的数字
        int[] numbers = split(number);
        //numbers = [1,9,8,3];
        
        //2.遍历每个数字
        for (int i = 0; i < numbers.length; i++) {
            //i=0,1,2,3
            numbers[i] = (numbers[i] + 5) % 10;
        }
            //numbers = [6,4,3,8];
        
        //3.数组反转加一个独立的方法来完成
        reverseArray(numbers);
        //numbers = [8,3,4,6];

        //4.数字拼接：
        String data = "";
        for (int i = 0; i < numbers.length; i++) {
            data += numbers[i];
        }
        return data;
    }

    private static void reverseArray(int[] numbers) {
        //6.反转数组的方法:i和j
        //numbers = [8,3,4,6];
        //           i     j
        for (int i = 0,j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[j];
            numbers[j] = numbers[i];
            numbers[i] = temp;
        }

    }

    private static int[] split(int number) {
        //5.封装：拆分1983单个
        int[] numbers = new int[4];
        numbers[0] = number / 1000;
        numbers[1] = (number/ 100) % 10;//（保留整数19）%10得到9
        numbers[2] = (number /10) % 10;//(198)%10得到8
        numbers[3] = number % 10;
        return numbers;//[1,9,9,3]
    }
}
