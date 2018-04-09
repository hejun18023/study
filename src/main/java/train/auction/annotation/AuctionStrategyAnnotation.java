package train.auction.annotation;

import train.auction.enums.AuctionStrategyEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by za-hejun on 2018/4/3.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuctionStrategyAnnotation {
    AuctionStrategyEnum[] strategy() default AuctionStrategyEnum.ARBITRARY;
    //每次最小加价
    double minAddPrice() default 1.0D;
    //每次最大加价
    double maxAddPrice() default Double.MAX_VALUE;

    int minTimes() default 1;

    int maxTimes() default Integer.MAX_VALUE;
}
