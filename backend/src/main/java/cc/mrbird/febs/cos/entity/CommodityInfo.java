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
 * 商品管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommodityInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编号
     */
    private String code;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 小杯价格
     */
    private BigDecimal smallCupPrice;

    /**
     * 中杯价格
     */
    private BigDecimal mediumCupPrice;

    /**
     * 大杯价格
     */
    private BigDecimal bigCupPrice;

    /**
     * 商品图片
     */
    private String images;

    /**
     * 商品备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;
}
