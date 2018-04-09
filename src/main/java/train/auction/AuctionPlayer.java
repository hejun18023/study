package train.auction;

import lombok.Data;
import lombok.EqualsAndHashCode;
import train.auction.enums.PlayerTypeEnum;

/**
 * 竞拍者
 * Created by za-hejun on 2018/4/3.
 */
@EqualsAndHashCode(of = {"code"})
@Data
public class AuctionPlayer {
    private String code;

    private String name;

    private String age;

    private String company;

    private String email;

    private String phone;

    private String address;

    private PlayerTypeEnum type = PlayerTypeEnum.PERSONAL;
}
