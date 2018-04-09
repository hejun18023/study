package designPatterns.strategy;

/**
 * Created by za-hejun on 2018/3/26.
 */
public class Player {
    private double price;

    public Player(double price){
        this.price = price;
    }

    public double needPay(){
        return CalculateFactory.getInstance().getCaculate(this).cal(price);
    }

    public double getPrice(){
        return price;
    }

}
