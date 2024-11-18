package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.UserInfoMapper;
import cc.mrbird.febs.cos.entity.StoreQueueInfo;
import cc.mrbird.febs.cos.dao.StoreQueueInfoMapper;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.IStoreQueueInfoService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreQueueInfoServiceImpl extends ServiceImpl<StoreQueueInfoMapper, StoreQueueInfo> implements IStoreQueueInfoService {

    private final UserInfoMapper userInfoMapper;

    /**
     * 分页获取用户排号信息
     *
     * @param page           分页对象
     * @param storeQueueInfo 用户排号信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectStoreQueuePage(Page<StoreQueueInfo> page, StoreQueueInfo storeQueueInfo) {
        return baseMapper.selectStoreQueuePage(page, storeQueueInfo);
    }

    /**
     * 新增用户排号信息
     *
     * @param storeQueueInfo 用户排号信息
     * @return 结果
     */
    @Override
    public boolean queueAdd(StoreQueueInfo storeQueueInfo) {
        // 获取用户信息
        UserInfo userInfo = userInfoMapper.selectOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, storeQueueInfo.getUserId()));
        if (userInfo != null) {
            userInfo.setUserId(userInfo.getId());
        }

        // 排队编号
        storeQueueInfo.setCode("SQ-" + System.currentTimeMillis());
        // 排队日期
        storeQueueInfo.setQueueDate(DateUtil.formatDate(new Date()));
        // 领号时间
        storeQueueInfo.setReceiveDate(DateUtil.formatDateTime(new Date()));

        // 判断此商铺当前排号位置
        return false;
    }
}
