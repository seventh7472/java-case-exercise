package com.steven;

import java.util.Random;
import java.util.Scanner;

public class CaseDemo5 {
    public static void main(String[] args) {
        //方法1：抢红包案例
        int[] moneys = {9,66,188,520,9999};
        start(moneys);

    }

    public static void start(int[] moneys){
        //moneys=[9,66,188,520,9999]
        //        0  1  2   3    4
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        //1.定义抽奖五次
        for (int i = 1; i <= 5 ; i++) {
            //2.提示抽奖
            System.out.println("请您输入任意内容进行抽奖：");
            sc.nextInt();//输入内容

            //3.为当前粉丝找一个随机红包
            while (true) {
                int index = r.nextInt(moneys.length);//0-4
                int money = moneys[index];

                //4.判断红包是否为0
                if(money != 0){
                    System.out.println("恭喜您抽中了红包：" + money );
                    moneys[index] = 0;//当前位置红包没有了
                    break;//结束此次抽奖
                }
            }

        }
        System.out.println("活动已结束！");





    }



}
