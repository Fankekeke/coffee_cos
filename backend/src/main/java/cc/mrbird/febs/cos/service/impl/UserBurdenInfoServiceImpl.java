package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.UserBurdenInfo;
import cc.mrbird.febs.cos.dao.UserBurdenInfoMapper;
import cc.mrbird.febs.cos.service.IUserBurdenInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class UserBurdenInfoServiceImpl extends ServiceImpl<UserBurdenInfoMapper, UserBurdenInfo> implements IUserBurdenInfoService {

    /**
     * 分页获取用户优惠券信息
     *
     * @param page           分页对象
     * @param userBurdenInfo 用户优惠券信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectUserBurdenPage(Page<UserBurdenInfo> page, UserBurdenInfo userBurdenInfo) {
        return baseMapper.selectUserBurdenPage(page, userBurdenInfo);
    }
}
