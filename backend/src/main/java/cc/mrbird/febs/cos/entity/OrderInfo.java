package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 订单记录管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 所属门店
     */
    private Integer storeId;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 类型（0.自提 1.外送）
     */
    private String type;

    /**
     * 外送地址
     */
    private Integer addressId;

    /**
     * 商家到外送地址里程
     */
    private BigDecimal mileage;

    /**
     * 配送价格
     */
    private BigDecimal deliveryPrice;

    /**
     * 券前价格
     */
    private BigDecimal preCouponPrice;

    /**
     * 券后价格
     */
    private BigDecimal afterCouponPrice;

    /**
     * 优惠券ID
     */
    private Integer couponId;

    /**
     * 优惠价格
     */
    private BigDecimal discountPrice;

    /**
     * 取餐码
     */
    private String pickupCode;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 取餐时间
     */
    private String pickupDate;

    /**
     * 支付时间
     */
    private String payDate;

    /**
     * 状态（0.未支付 1.已下单 2.配送中 3.待取餐 4.已完成 5.已作废）
     */
    private String status;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;
}
