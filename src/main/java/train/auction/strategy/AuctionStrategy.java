package train.auction.strategy;

import train.auction.AuctionCommodity;
import train.auction.AuctionPlayer;

/**
 * Created by za-hejun on 2018/4/3.
 */
public interface AuctionStrategy {
    boolean bid(AuctionPlayer player, double addPrice, AuctionCommodity commodity);
}
