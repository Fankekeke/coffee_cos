package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.IntegralOutRecordInfo;
import cc.mrbird.febs.cos.dao.IntegralOutRecordInfoMapper;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.IIntegralOutRecordInfoService;
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
public class IntegralOutRecordInfoServiceImpl extends ServiceImpl<IntegralOutRecordInfoMapper, IntegralOutRecordInfo> implements IIntegralOutRecordInfoService {

    private final IUserInfoService userInfoService;

    /**
     * 分页获取积分消费记录信息
     *
     * @param page                  分页对象
     * @param integralOutRecordInfo 积分消费记录信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectIntegralOutRecordPage(Page<IntegralOutRecordInfo> page, IntegralOutRecordInfo integralOutRecordInfo) {
        return baseMapper.selectIntegralOutRecordPage(page, integralOutRecordInfo);
    }

    /**
     * 添加积分消费记录
     *
     * @param integralOutRecordInfo 积分消费记录
     * @return 结果
     */
    @Override
    public boolean integralOutRecordAdd(IntegralOutRecordInfo integralOutRecordInfo) {
        // 消费时间
        integralOutRecordInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        // 获取用户信息
        UserInfo user = userInfoService.getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, integralOutRecordInfo.getUserId()));
        if (user != null) {
            integralOutRecordInfo.setUserId(user.getId());
        }
        return this.save(integralOutRecordInfo);
    }
}
