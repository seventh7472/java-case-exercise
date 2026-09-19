package com.steven;

public class CaseDemo6_3 {

    public static void main(String[] args) {
        //找素数方法3：
        for (int i = 101; i <= 200; i++) {
            //先遍历范围：
            if (check(i)){
                System.out.println("素数为：" + i);
            }
        }
    }

    public static boolean check(int data){
        for (int i=2;i<=data/2;i++){
            if (data%i==0){
                return false;
            }
        }
        return true;

    }



        }



