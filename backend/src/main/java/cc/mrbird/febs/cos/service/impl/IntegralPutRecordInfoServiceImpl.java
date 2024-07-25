package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.IntegralPutRecordInfo;
import cc.mrbird.febs.cos.dao.IntegralPutRecordInfoMapper;
import cc.mrbird.febs.cos.service.IIntegralPutRecordInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class IntegralPutRecordInfoServiceImpl extends ServiceImpl<IntegralPutRecordInfoMapper, IntegralPutRecordInfo> implements IIntegralPutRecordInfoService {

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
}
