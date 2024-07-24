package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 积分物品兑换记录
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExchangeRecordInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 兑换记录编号
     */
    private String code;

    /**
     * 兑换商品ID
     */
    private Integer pointId;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 消耗积分
     */
    private BigDecimal integral;

    /**
     * 兑换数量
     */
    private Integer num;

    /**
     * 单价
     */
    private BigDecimal integralUnit;

    /**
     * 兑换时间
     */
    private String createDate;


}
