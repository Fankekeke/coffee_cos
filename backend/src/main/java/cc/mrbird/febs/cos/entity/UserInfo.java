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
 * 用户管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编号
     */
    private String code;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 性别（1.男 2.女）
     */
    private String sex;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 头像
     */
    private String images;

    /**
     * 所属账户
     */
    private Integer userId;

    /**
     * 账户积分
     */
    private BigDecimal integral;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;
}
