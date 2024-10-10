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
 * 积分商品管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PointCommodityInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 积分物品编号
     */
    private String code;

    /**
     * 积分物品名称
     */
    private String name;

    /**
     * 库存数量
     */
    private Integer stockNum;

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
