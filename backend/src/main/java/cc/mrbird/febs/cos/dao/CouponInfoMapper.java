package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.CouponInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface CouponInfoMapper extends BaseMapper<CouponInfo> {

    /**
     * 分页获取优惠券信息
     *
     * @param page       分页对象
     * @param couponInfo 优惠券信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectCouponPage(Page<CouponInfo> page, @Param("couponInfo") CouponInfo couponInfo);
}
