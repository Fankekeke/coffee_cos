package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.ExchangeRecordInfo;
import cc.mrbird.febs.cos.dao.ExchangeRecordInfoMapper;
import cc.mrbird.febs.cos.service.IExchangeRecordInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class ExchangeRecordInfoServiceImpl extends ServiceImpl<ExchangeRecordInfoMapper, ExchangeRecordInfo> implements IExchangeRecordInfoService {

    /**
     * 分页获取积分物品兑换记录信息
     *
     * @param page               分页对象
     * @param exchangeRecordInfo 积分物品兑换记录信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectExchangeRecordPage(Page<ExchangeRecordInfo> page, ExchangeRecordInfo exchangeRecordInfo) {
        return baseMapper.selectExchangeRecordPage(page, exchangeRecordInfo);
    }
}
