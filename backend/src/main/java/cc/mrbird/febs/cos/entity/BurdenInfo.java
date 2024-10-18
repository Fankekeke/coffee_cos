package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 配料管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BurdenInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 配料编号
     */
    private String code;

    /**
     * 配料名称
     */
    private String name;

    /**
     * 类型（0.根节点 1.配料种类）
     */
    private String type;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 父节点
     */
    private Integer parentId;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;

    /**
     * 子集
     */
    @TableField(exist = false)
    private List<BurdenInfo> children;
}
