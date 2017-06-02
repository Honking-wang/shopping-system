package Pages;

import Dao.GoodsDao;
import Entity.Goods;
import Utils.Choice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghanqing on 2017/5/18.
 */
public class GoodsPages extends Choice {
    public static void addGoods() throws Exception {
        System.out.println("\t 正在执行添加商品操作");
        System.out.println("\t 请输入需要添加的商品");
        String goodName=choicein();
        System.out.println("\t 请输入商品价格");
        float goodPrice = choicePrice();
        System.out.println("\t 请输入商品数量");
        int goodNum = choiceNum();
        Goods goods=new Goods(goodName,goodPrice,goodNum);
        GoodsDao gd=new GoodsDao();
        boolean boom=gd.addGoods(goods);
        if (boom){
            System.out.println("\t 商品添加成功");
        }else{
            System.out.println("\t 商品添加失败");
        }
        changedNext("addGoods");
    }
    public static void updateGoods() throws Exception {
        System.out.println("\t 正在执行更改商品的操作");
        System.out.println("\t 请输入需要更改的商品编号");

        boolean boom;
        int goodid=choiceNum();

        System.out.println("\t请选择您想要更改的内容");
        System.out.println("\t1.更改商品名称");
        System.out.println("\t2.更改商品价格");
        System.out.println("\t3.更改商品数量");
        System.out.println("\t请输入选项或者按0返回上一菜单");

        do{
            String choice = choicein();
            String regex="[0-3]";
            if (choice.matches(regex)){
                int info=Integer.parseInt(choice);
                switch (info){
                    case 0:
                        MainPage.maintainPage();
                        break;
                    case 1:
                        System.out.println("请输入商品新名称");
                        String name=choicein();
                        Goods goodsName=new Goods(goodid,name);
                        boom=new GoodsDao().updateGoods(1,goodsName);
                        if (boom){
                            System.out.println("\t已成功更新商品名至数据库");
                        }else{
                            System.out.println("\t商品更新失败");
                        }
                        changedNext("updateGoods");
                        break;
                    case 2:
                        System.out.println("请输入商品新价格");
                        Float price =choicePrice();
                        Goods goodsPrice=new Goods(goodid,price);
                        boom=new GoodsDao().updateGoods(2,goodsPrice);
                        if (boom){
                            System.out.println("\t已成功更新商品价格至数据库");
                        }else{
                            System.out.println("\t商品更新失败");
                        }
                        changedNext("updateGoods");
                        break;
                    case 3:
                        System.out.println("请输入商品新数量");
                        int num=choiceNum();
                        Goods goodsNum=new Goods(goodid,num);
                        boom=new GoodsDao().updateGoods(3,goodsNum);
                        if (boom){
                            System.out.println("\t已成功更新商品数量至数据库");
                        }else{
                            System.out.println("\t商品更新失败");
                        }
                        changedNext("updateGoods");
                        break;
                }
            }
        }while (true);
    }

    public static void deleteGoods() throws Exception {
        System.out.println("\t 正在执行删除商品的操作");
        System.out.println("\t 请输入需要删除的商品编号");
        int goodid=choiceNum();
        GoodsDao gd = new GoodsDao();
        boolean boom=gd.deleteGoods(goodid);
        if (boom){
            System.out.println("\t 商品删除成功");
        }else{
            System.out.println("\t 商品删除失败");
        }
        changedNext("deleteGoods");
    }

    public static void queryGoods() throws Exception {
        System.out.println("\t正在执行查询商品操作");
        System.out.println("\t请输入商品关键字");

        ArrayList<Goods> goodsArrayList=new GoodsDao().query();
        if (goodsArrayList==null||goodsArrayList.size()<=0){
            System.err.println("\t您输入的商品不存在");
        }else{
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注");
            for (int i=0,length=goodsArrayList.size();i<length;i++){
                Goods goods=goodsArrayList.get(i);
                System.out.print("\t\t"+goods.getGoodid()+"\t\t"+goods.getGoodName()+"\t\t"+
                        goods.getGoodPrice()+"\t\t"+goods.getGoodNum()+"\t\t");
                if (goods.getGoodNum()==0){
                    System.out.println("该商品已售空！！！");
                }else if (goods.getGoodNum()<10){
                    System.out.println("该商品已不足10件！");
                }else{
                    System.out.println("\t-----");
                }
            }
        }
        do {
            System.out.println("输入0返回上一级菜单");
            String choice =choicein();
            if (choice.equals("0")){
                MainPage.maintainPage();
            }else{
                System.out.println("输入有误！！请重新输入~");
            }
        }while(true);

    }


    public static void displayGoods() throws Exception {
        System.out.println("\t\t\t\t\t所有商品列表");
        List<Goods> goodsList=new GoodsDao().display();

        if (goodsList.size()<=0){
            System.out.println("库存为空！！！");
            MainPage.maintainPage();
        }else{
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\t");
            for (int i=0,length=goodsList.size();i<length;i++){
                Goods goods=goodsList.get(i);
                System.out.print("\t\t"+goods.getGoodid()+"\t\t"+goods.getGoodName()+"\t\t"+
                        goods.getGoodPrice()+"\t\t"+goods.getGoodNum()+"\t\t");
                if (goods.getGoodNum()==0){
                    System.out.println("该商品已售空！！！");
                }else if (goods.getGoodNum()<10){
                    System.out.println("该商品已不足10件！");
                }else{
                    System.out.println("\t-----");
                }
            }
        }
        System.out.println("---------------------------");
        do {
            System.out.println("输入0返回上一级菜单");
            String choice =choicein();
            if (choice.equals("0")){
                MainPage.maintainPage();
            }else{
                System.out.println("输入有误！！请重新输入~");
            }
        }while(true);
    }
}
