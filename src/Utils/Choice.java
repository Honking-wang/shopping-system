package Utils;

import Pages.GoodsPages;
import Pages.MainPage;

import java.util.Scanner;

/**
 * Created by wanghanqing on 2017/5/15.
 */
public class Choice {
    /**
     * 键盘录入字符串操作
     */
    public static String choicein(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入");
        return scanner.next();
    }

    /**
     *键盘录入浮点型数字操作
     */
    public static float choicePrice(){
        float price=0.00f;
        System.out.println("请输入，保留两位有效数字");
        String regex="(([1-9][0-9]*)\\.([0-9]{2}))|([0]\\.([0-9]{2}))";
        do {
            Scanner scanner = new Scanner(System.in);

            String info = scanner.next();
            if (info.matches(regex)) {
                price = Float.parseFloat(info);
            } else {
                System.err.println("您的输入有误，请重新输入");
                continue;
            }
            break;
        }while (true);
        return price;
    }
    /**
     * 键盘录入整数操作
     */
    public static int choiceNum(){
        int num=0;
        String regex="[0-9]|([1-9][0-9]+)";
        do {
            Scanner scanner=new Scanner(System.in);
            String info=scanner.next();
            if (info.matches(regex)){
                num=Integer.parseInt(info);
            }else{
                System.err.println("您的输入有误，请重新输入");
            }
            break;
        }while (true);
        return num;
    }
    /**
     * 执行完操作页面跳转时操作
     */
    public static void changedNext(String opr) throws Exception {
        do {
            System.out.println("是否执行当前操作 Y/N");
            String choice =choicein();
            if (choice.equals("Y")||choice.equals("y")){
                if ("addGoods".equals(opr)){
                    GoodsPages.addGoods();
                }else if ("deleteGoods".equals(opr)){
                    GoodsPages.deleteGoods();
                }else{
                    GoodsPages.updateGoods();
                }
            }else if ("N".equals(choice)||"n".equals(choice)){
                MainPage.maintainPage();
            }else{
                System.out.println("您的输入有误，请重新输入");
            }
        }while(true);
    }
}
