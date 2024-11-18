package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.UserInfoMapper;
import cc.mrbird.febs.cos.entity.CouponInfo;
import cc.mrbird.febs.cos.dao.CouponInfoMapper;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.ICouponInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements ICouponInfoService {

    private final UserInfoMapper userInfoMapper;

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
