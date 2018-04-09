package train.auction;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 竞拍系统
 * Created by za-hejun on 2018/4/3.
 */
public class AuctionSystem {
    private volatile static AuctionSystem instance;

    private ConcurrentHashMap<String, List<AuctionCommodity>> commodities = new ConcurrentHashMap<>();

    private AuctionSystem(){}

    public static AuctionSystem getInstance(){
        if(null == instance){
            synchronized (AuctionSystem.class){
                if(null == instance){
                    instance = new AuctionSystem();
                }
            }
        }
        return instance;
    }


}
