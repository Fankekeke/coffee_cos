package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.IntegralPutRecordInfo;
import cc.mrbird.febs.cos.dao.IntegralPutRecordInfoMapper;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.IIntegralPutRecordInfoService;
import cc.mrbird.febs.cos.service.IUserInfoService;
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
public class IntegralPutRecordInfoServiceImpl extends ServiceImpl<IntegralPutRecordInfoMapper, IntegralPutRecordInfo> implements IIntegralPutRecordInfoService {

    private final IUserInfoService userInfoService;

    /**
     * 分页获取积分获取记录信息
     *
     * @param page                  分页对象
     * @param integralPutRecordInfo 积分获取记录信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectIntegralPutRecordPage(Page<IntegralPutRecordInfo> page, IntegralPutRecordInfo integralPutRecordInfo) {
        return baseMapper.selectIntegralPutRecordPage(page, integralPutRecordInfo);
    }

    /**
     * 添加积分获取记录
     *
     * @param integralPutRecordInfo 积分获取记录
     * @return 结果
     */
    @Override
    public boolean integralPutRecordAdd(IntegralPutRecordInfo integralPutRecordInfo) {
        // 添加时间
        integralPutRecordInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        // 获取用户信息
        UserInfo user = userInfoService.getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, integralPutRecordInfo.getUserId()));
        if (user != null) {
            integralPutRecordInfo.setUserId(user.getId());
        }
        return this.save(integralPutRecordInfo);
    }
}
