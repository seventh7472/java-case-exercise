package com.steven;
import java.util.Random;

public class CaseDemo2 {
    public static void main(String[] args) {
        //案例二：开发验证码
        System.out.println(createCode(5));//几位字符

    }
    public static String createCode(int n) {//String类型可以代表数字，大小写字母
        Random r = new Random();
        String code ="";//用字符串的拼接
        //1.定义for循环定义随机控制：Random
        for (int i = 1; i <= n; i++) {//2.i代表验证码的位置：
            int type =r.nextInt(3);//三种：数字，大小写的字符
            switch (type) {
                case 0:
                    code += r.nextInt(10);//0~9随机生成一个数字，code = code + 8
                    break;
                case 1:
                    //ASCII码大字母：A~Z之间 A：65 Z：65+25 （0-25）+65,大写字母(A~Z)
                    char ch1 = (char) (r.nextInt(26)+65);//大写字符的范围
                    code += ch1;
                    break;
                case 2://（0-25）+97：小写字母(a~z)
                    char ch2 = (char) (r.nextInt(26)+97);
                    code += ch2;
                    break;
            }
        }
        return code;

    }


}
