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
 * 积分消费记录
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IntegralOutRecordInfo implements Serializable {

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
     * 积分
     */
    private BigDecimal integral;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 消费时间
     */
    private String createDate;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;
}
