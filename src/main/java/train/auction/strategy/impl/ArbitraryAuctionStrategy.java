package train.auction.strategy.impl;

import train.auction.AuctionCommodity;
import train.auction.AuctionPlayer;
import train.auction.annotation.AuctionStrategyAnnotation;
import train.auction.enums.AuctionStrategyEnum;
import train.auction.strategy.AuctionStrategy;

/**
 * 自由竞拍方式
 * Created by za-hejun on 2018/4/3.
 */
@AuctionStrategyAnnotation(strategy = {AuctionStrategyEnum.ARBITRARY})
public class ArbitraryAuctionStrategy implements AuctionStrategy {

    @Override
    public boolean bid(AuctionPlayer player, double addPrice, AuctionCommodity commodity) {
        return false;
    }
}
