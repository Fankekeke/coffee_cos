package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.CouponInfo;
import cc.mrbird.febs.cos.dao.CouponInfoMapper;
import cc.mrbird.febs.cos.service.ICouponInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements ICouponInfoService {

    /**
     * 分页获取优惠券信息
     *
     * @param page       分页对象
     * @param couponInfo 优惠券信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectCouponPage(Page<CouponInfo> page, CouponInfo couponInfo) {
        return baseMapper.selectCouponPage(page, couponInfo);
    }
}
