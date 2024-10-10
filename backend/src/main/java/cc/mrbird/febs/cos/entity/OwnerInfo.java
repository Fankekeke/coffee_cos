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
 * 店主管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OwnerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 店主编号
     */
    private String code;

    /**
     * 店主姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 性别（1.男 2.女）
     */
    private String sex;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 店主照片
     */
    private String images;

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
