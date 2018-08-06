package com.xxx.view;

import java.util.Scanner;

/**
 * @author JingeZhang
 * @create 2018-08-06 18:17
 */
public class FamilyAccount {
    private static Scanner input;
    private static double balance = 10000;//本金
    private static String details = "收支\t账户金额\t收支金额\t说明\n本金\t10000\t0\t\t本金\n";

    public static void main(String[] args) {
        enterMain();
    }

    public static void enterMain() {
        input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("-----------------家庭收支记账软件-----------------");
            System.out.println("\t\t1 收支明细");
            System.out.println("\t\t2 登记收入");
            System.out.println("\t\t3 登记支出");
            System.out.println("\t\t4 退    出");
            System.out.print("\t\t请选择(1-4)：");
            int select = input.nextInt();
            System.out.println();
            switch (select) {
                case 1:
                    showDetails();
                    break;
                case 2:
                    registerIncome();
                    break;
                case 3:
                    registerExpend();
                    break;
                case 4:
                    flag = exit();
                    break;
            }
        }


    }
    //退出
    private static boolean exit() {
        /**
         * 确认是否退出(Y/N)：x
         选择错误，请重新输入：x
         选择错误，请重新输入：y
         请按任意键继续. . .
         */
        System.out.print("确认是否退出(Y/N)：");
        char confirm = input.next().toUpperCase().charAt(0);
        while(true){
            if(confirm=='Y'){
                System.out.println("请按任意键继续. . .");
                input.nextLine();
                return false;
            }else if(confirm =='N'){
                return true;
            }else{
                System.out.println("选择错误，请重新输入:");
            }
        }


    }

    //登记支出
    private static void registerExpend() {
        /**
         * 本次支出金额：50
         本次支出说明：给别人发红包
         ---------------------登记完成---------------------
         */
        System.out.print("本次支出金额：");
        double expend = input.nextDouble();
        balance -= expend;
        System.out.print("本次支出说明：");
        String str = input.next();
        details +="支出\t"+balance+"\t"+expend+"\t"+str+"\n";
        System.out.println("---------------------登记完成---------------------");
    }

    //登记收入
    private static void registerIncome() {
        /**
         * 本次收入金额：2000
         本次收入说明：工资
         ---------------------登记完成---------------------
         */
        System.out.print("本次收入金额：");
        double income = input.nextDouble();
        balance += income;
        System.out.print("本次收入说明：");
        String str = input.next();
        details += "收入\t" + balance + "\t" + income + "\t" + str+"\n";
        System.out.println("---------------------登记完成---------------------");
    }

    //记录收支明细
    private static void showDetails() {
        System.out.println("-----------------当前收支明细记录-----------------");
        System.out.println(details);
        System.out.println("--------------------------------------------------");
    }


}
