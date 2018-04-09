package train.auction;

import lombok.*;
import train.auction.enums.AuctionStrategyEnum;

import javax.validation.constraints.NotNull;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 竞拍商品（物品）
 * Created by za-hejun on 2018/4/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"code"})
public class AuctionCommodity {
    //每个商品的唯一编码
    @NotNull
    private String code;

    //起拍价
    @NotNull
    private double originPrice;

    //最高限价
    private double limitPrice;

    //当前价格
    private double nowPrice;

    //竞价次数
    private AtomicInteger times;

    //当前出价人
    private AuctionPlayer player;

    //该物品的竞拍规则，可拓展
    private AuctionStrategyEnum ruleEnum = AuctionStrategyEnum.LIMIT;

    public AuctionCommodity(String code, double originPrice, double limitPrice){
        this.code = code;
        this.originPrice = originPrice;
        this.limitPrice = limitPrice;
        this.nowPrice = originPrice;
    }

    public boolean addAndCompare(AuctionPlayer player, double increasedPrice){
        if((nowPrice += increasedPrice) == limitPrice){
            return true;
        }
        this.player = player;
        return false;
    }
}
