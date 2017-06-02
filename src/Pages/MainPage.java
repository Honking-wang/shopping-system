package Pages;

import Utils.Choice;

import java.sql.SQLException;

import static Pages.GoodsPages.*;

/**
 * Created by wanghanqing on 2017/5/15.
 */
public class MainPage extends Choice{

    public static void main(String[] args) throws Exception {
        MainPage.inpage();
    }
    public static void inpage() throws SQLException {
        System.out.println("***************************");
        System.out.println("\t1.商品维护");
        System.out.println("\t2.前台收银");
        System.out.println("\t3.商品管理");
        System.out.println("***************************");

        System.out.println("请输入选项,或者按0退出.");

        do {
            String in=choicein();
            String regex="[0-3]";
            if (in.matches(regex)){
                int info =Integer.parseInt(in);
                switch (info){
                    case 0:
                        System.out.println("------------------");
                        System.out.println("您已退出系统");
                        System.exit(0000);
                        break;
                    case 1:
                        try {
                            maintainPage();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        ChargePage();
                        break;
                    case 3:
                        ManagePage();
                        break;
                    default:
                        break;
                }

            }else{
                System.err.println("您的输入有误");
                System.out.println("请重新输入或按0退出");
            }


        }while (true);
    }

    public static void maintainPage() throws Exception {
        System.out.println("***************************");
        System.out.println("\t 1.增加商品");
        System.out.println("\t 2.修改商品");
        System.out.println("\t 3.删除商品");
        System.out.println("\t 4.查询商品");
        System.out.println("\t 5.显示所有商品");
        System.out.println("***************************");
        System.out.println("请输入选项或者按0返回上一级菜单");
        do {
            String choice=choicein();
            String regex="[0-5]";
            if (choice.matches(regex)){
                int info=Integer.parseInt(choice);
                switch (info){
                    case 0:
                        inpage();
                        break;
                    case 1:
                        try {
                            addGoods();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        updateGoods();
                        break;
                    case 3:
                        deleteGoods();
                        break;
                    case 4:
                        queryGoods();
                        break;
                    case 5:
                        displayGoods();
                        break;
                    default:
                        break;
                }
            }else{
                System.err.println("您的输入有误");
                System.out.println("请重新输入或按0返回上一级菜单");
            }
        }while(true);
    }

    public static void ChargePage(){

    }
    public static void ManagePage(){

    }
}
