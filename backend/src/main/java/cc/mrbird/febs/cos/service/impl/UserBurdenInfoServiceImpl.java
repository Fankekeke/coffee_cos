package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.UserInfoMapper;
import cc.mrbird.febs.cos.entity.UserBurdenInfo;
import cc.mrbird.febs.cos.dao.UserBurdenInfoMapper;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.IUserBurdenInfoService;
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
public class UserBurdenInfoServiceImpl extends ServiceImpl<UserBurdenInfoMapper, UserBurdenInfo> implements IUserBurdenInfoService {

    private final UserInfoMapper userInfoMapper;

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

    /**
     * 根据用户ID获取未使用的优惠券信息
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public List<UserBurdenInfo> queryNotUseBurdenByUser(Integer userId) {
        // 获取用户信息
        UserInfo userInfo = userInfoMapper.selectOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, userId));
        if (userInfo == null) {
            return Collections.emptyList();
        }
        return this.list(Wrappers.<UserBurdenInfo>lambdaQuery().eq(UserBurdenInfo::getUserId, userInfo.getId()).eq(UserBurdenInfo::getStatus, "1"));
    }
}
