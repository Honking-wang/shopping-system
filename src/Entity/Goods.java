package Entity;

/**
 * Created by wanghanqing on 2017/5/18.
 */
public final class Goods {
    private int goodid;
    private String goodName;
    private float goodPrice;
    private int goodNum;

    /**
     *增加商品时
     */
    public Goods(String goodName,float goodPrice,int goodNum){
        this.goodName=goodName;
        this.goodPrice=goodPrice;
        this.goodNum=goodNum;
    }

    public Goods(int goodid,String goodName,float goodPrice,int goodNum){
        this.goodid=goodid;
        this.goodName=goodName;
        this.goodPrice=goodPrice;
        this.goodNum=goodNum;
    }

    public Goods(int goodid,int goodNum){
        this.goodid=goodid;
        this.goodNum=goodNum;
    }

    public Goods(int goodid,String goodName) {
        this.goodid = goodid;
        this.goodName = goodName;
    }

    public Goods(int goodid,float goodPrice) {
        this.goodid = goodid;
        this.goodPrice = goodPrice;
    }

    public int getGoodid() {
        return goodid;
    }

    public String getGoodName() {
        return goodName;
    }

    public float getGoodPrice() {
        return goodPrice;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public void setGoodPrice(float goodPrice) {
        this.goodPrice = goodPrice;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }
}
