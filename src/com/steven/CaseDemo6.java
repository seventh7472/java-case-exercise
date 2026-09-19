package com.steven;

public class CaseDemo6 {
    public static void main(String[] args) {
        System.out.println("当前素数的个数是：" + search(101, 200));

    }

    public static int search(int start, int end) {
        //eg:101,200
        int count = 0;//统计素数的个数

        //1.遍历101到200之间的每个数据
        for (int i = start; i <= end; i++) {

            //信号位思想：
            boolean flag = true;//假设的意思，默认i为素数

            //2.判断是否是素数
           for (int j = 2;j <= i/2; j++) {
               if(i % j == 0){
                   //i说明他就不是
                   flag = false;//假设不成立
                   break;
               }
           }


            //3.根据i是否是素数,然后输出结果
            if (flag){
                System.out.println(i);
                count++;
            }


        }

    return count;

    }

}
