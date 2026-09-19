package com.steven;

import java.util.Random;
import java.util.Scanner;

public class CaseDemo8 {
    public static void main(String[] args) {
        //双色球案例：六个红球号码一个人蓝球号码

        int[] useNumbers = userSelectNumbers();
        System.out.println("您投注的号码是：");
        printArray(useNumbers);

        int[] luckyNumbers = luckyNumbers();
        System.out.println("您中奖的号码是: ");
        printArray(luckyNumbers);

        judge(useNumbers, luckyNumbers);

    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
    }

    //1.用户选号
    public static  int[] userSelectNumbers() {
        int[] numbers = new int[7];
        //录入数据


        Scanner sc = new Scanner(System.in);

        //遍历前6个位置：7-1
        for (int i = 0; i < numbers.length - 1; i++) {
            //i=0,1,2,3,4,5

            while (true) {//ctrl alt t
                System.out.println("请您输入第" + (i + 1) + "个红球号码（1~33）之间不可以重复 ：");
                int number = sc.nextInt();

                //先判断用户输入的红球号码是否在1~33之间
                if (number < 1 || number > 33) {
                    System.out.println("您输入的号码不在范围1~33之间，请确认！");
                } else {
                    //号码不可以重复：
                    if (exist(numbers, number)) {
                        //判断当前号码是否重复
                        System.out.println("对不起，您当前输入的号码选择过，重复了，请确认！");
                    } else {
                        numbers[i] = number;//合法的操作
                        break;//结束当前死循环
                    }
                }
            }
        }


        //投注最后一个蓝球号码
        while (true) {
            System.out.println("请您输入最后一个蓝球号码（1~16）: ");
            int number = sc.nextInt();
            //判断是否符合蓝色球的范围
            if (number < 1 || number > 16) {
                System.out.println("对不起输入范围不对！");
            } else {
                numbers[6] = number;
                break;
            }
        }
        return numbers;
    }

    private static boolean exist(int[] numbers, int number) {
        //判断数字是否在numbers中存在
        //numbers = {12,25,44,77,0,0,0}
        //number = 26
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                break;
            }
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }

    /*
    设计随机号码
     */

    public static int[] luckyNumbers() {
        //1.创建整型数组来存储号码
        int[] numbers = new int[7];

        Random r = new Random();
        //2.遍历前6个位置
        for (int i = 0; i < numbers.length-1; i++) {
            //0,1,2,3,4,5

            while (true) {
                //3.范围：
                int number = r.nextInt(33) + 1;

                //4.判断号码是否出现过：
                if (!exist(numbers,number)){
                    numbers[i] = number;//不重复
                    break;
                }
            }

        }
        //录入一个蓝色球号码:1~16的随机数
        numbers[6] = r.nextInt(16)+1;
        return numbers;

    }

    //判断是否中奖：
    public static void judge(int[] userNumbers,int[] luckyNumbers) {

        int redCount = 0;
        int blueCount = 0;

        //比对红球号码的命中
        for (int i = 0; i < userNumbers.length-1; i++) {

            for (int j = 0; j < luckyNumbers.length-1; j++) {
                if (userNumbers[i] == luckyNumbers[j]) {
                    redCount++;
                    break;
                }
            }
        }

        //判断蓝球是否命中：
        blueCount = userNumbers[6] == luckyNumbers[6] ? 1:0;//三目运算符

        //打印出命中数量：
        System.out.println("您命中的红球数量是：" + redCount);
        System.out.println("您命中的蓝球数量是：" + blueCount);

        //判断中奖详情：输出结果：
        if(redCount == 6 && blueCount ==1){
            System.out.println("恭喜您中一等奖");
        } else if (redCount == 6 && blueCount ==0) {
            System.out.println("恭喜您中二等奖");
        } else if (redCount == 5 && blueCount ==1) {
            System.out.println("恭喜您中三等奖");
        } else if (redCount == 5 && blueCount ==0 || redCount == 4 && blueCount ==1) {
            System.out.println("恭喜您四等奖");
        } else if (redCount == 4 && blueCount ==0 || redCount == 3 && blueCount ==1) {
            System.out.println("恭喜您五等奖");
        } else if (redCount < 3 && blueCount==1) {
            System.out.println("恭喜您中了10元");
        }else {
            System.out.println("感谢您对福利事业做出的巨大贡献");
        }

    }
}
