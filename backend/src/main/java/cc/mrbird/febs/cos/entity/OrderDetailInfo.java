package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 订单选购详情
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetailInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 所属订单
     */
    private Integer orderId;

    /**
     * 商品ID
     */
    private Integer commodityId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 配料
     */
    private String burdenDetail;

    /**
     * 配料价格
     */
    private BigDecimal burdenPrice;

    /**
     * 总金额
     */
    private BigDecimal totalPrice;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;
}
