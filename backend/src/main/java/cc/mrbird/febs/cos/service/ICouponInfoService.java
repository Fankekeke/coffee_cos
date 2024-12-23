package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.CouponInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface ICouponInfoService extends IService<CouponInfo> {

    /**
     * 分页获取优惠券信息
     *
     * @param page       分页对象
     * @param couponInfo 优惠券信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectCouponPage(Page<CouponInfo> page, CouponInfo couponInfo);

}
