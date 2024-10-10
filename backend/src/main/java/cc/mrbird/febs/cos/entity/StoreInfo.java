package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 门店管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StoreInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 门店编号
     */
    private String code;

    /**
     * 门店名称
     */
    private String name;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 开始营业时间
     */
    private String startTime;

    /**
     * 营业结束时间
     */
    private String endTime;

    /**
     * 所属店主
     */
    private Integer shopkeeperId;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 门店图片
     */
    private String images;

    /**
     * 删除标识
     */
    @TableLogic
    private String delFlag;
}
