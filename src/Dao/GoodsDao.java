package Dao;

import DB.DBconn;
import Entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Utils.Choice.choicein;

/**
 * Created by wanghanqing on 2017/5/25.
 */
public class GoodsDao {
    boolean boom=false;
    public boolean addGoods(Goods goods) throws SQLException {
        boom=false;
        String sql="INSERT INTO GOODS VALUES (NULL,?,?,?)";
        Connection connection= DBconn.getconnection();
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,goods.getGoodName());
        pstmt.setFloat(2,goods.getGoodPrice());
        pstmt.setInt(3,goods.getGoodNum());

        int inf=pstmt.executeUpdate();
        if (inf>0){
            boom=true;
        }
        return boom;
    }
    public boolean deleteGoods(int GID) throws SQLException {
        boom=false;
        String sql="DELETE FROM GOODS WHERE GID=?";
        Connection connection=DBconn.getconnection();
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setInt(1,GID);

        int inf=pstmt.executeUpdate();
        if (inf>0){
            boom=true;
        }
        return boom;
    }
    public boolean updateGoods(int key,Goods goods) throws SQLException {
        boom=false;
        int inf;
        PreparedStatement pstmt;
        Connection connection=DBconn.getconnection();
        switch (key){
            /**
             * 更改商品名称
             */
            case 1:
                pstmt=connection.prepareStatement("UPDATE GOODS SET GNAME=? WHERE GID=?");
                pstmt.setString(1,goods.getGoodName());
                pstmt.setInt(2,goods.getGoodid());

                inf=pstmt.executeUpdate();
                if (inf>0){
                    boom=true;
                }
                break;
            /**
             * 更改商品价格
             */
            case 2:
                pstmt=connection.prepareStatement("UPDATE GOODS SET GPRICE=? WHERE GID=?");
                pstmt.setFloat(1,goods.getGoodPrice());
                pstmt.setInt(2,goods.getGoodid());

                inf=pstmt.executeUpdate();
                if (inf>0){
                    boom=true;
                }
                break;
            /**
             *更新商品数量
             */
            case 3:
                pstmt=connection.prepareStatement("UPDATE GOODS SET GNUM=? WHERE GID=?");
                pstmt.setInt(1,goods.getGoodNum());
                pstmt.setInt(2,goods.getGoodid());

                inf=pstmt.executeUpdate();
                if (inf>0){
                    boom=true;
                }
                break;
            default:
                break;
        }
        return boom;
    }

    public static ArrayList<Goods> query() throws SQLException {
        ArrayList<Goods> goodsArrayList=new ArrayList<>();
        Connection connection=DBconn.getconnection();
        String name="%"+choicein()+"%";
        PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM GOODS WHERE GNAME LIKE ?");
        pstmt.setString(1,name);

        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            int id=rs.getInt("GID");
            String gname=rs.getString("GNAME");
            float price=rs.getFloat("GPRICE");
            int num=rs.getInt("GNUM");

            Goods goods=new Goods(id,gname,price,num);
            goodsArrayList.add(goods);
        }
        return goodsArrayList;

    }


    public List<Goods> display() throws Exception {
        List<Goods> goodsList=new ArrayList<Goods>();
        String sql="SELECT * FROM GOODS";
        Connection connection=DBconn.getconnection();
        PreparedStatement pstmt=connection.prepareStatement(sql);

        ResultSet rs=pstmt.executeQuery();
        while (rs.next()){
            int id=rs.getInt("GID");
            String name=rs.getString("GNAME");
            float price=rs.getFloat("GPRICE");
            int num=rs.getInt("GNUM");
            Goods goods=new Goods(id,name,price,num);
            goodsList.add(goods);
        }
        return goodsList;
    }
}
