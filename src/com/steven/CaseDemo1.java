package com.steven;

public class CaseDemo1 {
    public static void main(String[] args) {
    //        System.out.println("优惠价格是：" + calculate(1000,8,"经济舱") + "元");
    //用double来接受返回值：
    double price = calculate(1000,7,"头等舱");
        System.out.println("优惠价格是：" + price);
    }
    //案例一:买飞机票,区间用if,数据匹配值用switch

    public static double calculate(double price,int month,String type) {
        if(month>=5 && month<=10) {
            //旺季
            switch (type) {
                case "头等舱":
                price *= 0.9;
                break;
                case "经济舱":
                price *= 0.85;
                break;
            }
        }
        else {
            //淡季
            switch (type) {
                case "头等舱":
                price *= 0.7;//price = price *0.7;
                break;
                case "经济舱":
                price *= 0.65;
                break;
            }

        }
        return price;
    }




}
