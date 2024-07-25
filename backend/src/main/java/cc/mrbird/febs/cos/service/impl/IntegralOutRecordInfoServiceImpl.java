package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.IntegralOutRecordInfo;
import cc.mrbird.febs.cos.dao.IntegralOutRecordInfoMapper;
import cc.mrbird.febs.cos.service.IIntegralOutRecordInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class IntegralOutRecordInfoServiceImpl extends ServiceImpl<IntegralOutRecordInfoMapper, IntegralOutRecordInfo> implements IIntegralOutRecordInfoService {

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
}
