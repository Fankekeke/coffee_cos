package cc.mrbird.febs.cos.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户排号
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StoreQueueInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 编号
     */
    private String code;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 排队日期
     */
    private String queueDate;

    /**
     * 当日排号
     */
    private Integer indexNo;

    /**
     * 领号时间
     */
    private String receiveDate;

    /**
     * 状态（0.排号中 1.已核销 2.已作废）
     */
    private String status;

    /**
     * 所属门店
     */
    private Integer storeId;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;
}
