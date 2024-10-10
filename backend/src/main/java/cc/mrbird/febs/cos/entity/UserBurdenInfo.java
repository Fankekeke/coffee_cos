package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户优惠券管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBurdenInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 优惠券ID
     */
    private Integer couponId;

    /**
     * 有效天数
     */
    private Integer efficientDay;

    /**
     * 过期时间
     */
    private String endDate;

    /**
     * 状态（1.正常 2.已使用 3.已过期）
     */
    private String status;

    /**
     * 获取时间
     */
    private String createDate;

    /**
     * 所属订单
     */
    private Integer orderId;

    /**
     * 使用时间
     */
    private String useDate;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;
}
