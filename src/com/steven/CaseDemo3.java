package com.steven;

import java.text.Format;
import java.util.Scanner;

public class CaseDemo3 {
    public static void main(String[] args) {
        //案例三：评委打分
        System.out.println( " 当前选手得分是： " + getAvergaeScore(6));
    }

    public static double getAvergaeScore(int number){//接收评委人数
        //1.动态化数组，后期接入评委的打分
        int[] scores = new int[number];
        //eg:6个人，数组有6个分数

        //2.遍历数组内部：录入分数
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < number; i++) {
            System.out.println("请您录入第" + (i + 1) + "个评委的分数：");
            int score = sc.nextInt();
            scores[i] = score;
        }

        //3.数组中计算出总分，最高分，最低分
        int sum = 0;//总分变量
            int max = scores[0];//求最大值
            int min = scores[0];//求最小值

        //遍历数组找出数据：
        for (int j = 0; j < scores.length; j++) {
            //i = 0,1,2,3,4,5
            int score =scores[j];
            sum += score;
            if (score > max) {
                max = score;
            }
            if (score < min) {
                min = score;
            }

        }

        //4.计算平均分并返回：
        return 1.0 * (sum - min -max )/(number - 2);//会有小数






    }
}
