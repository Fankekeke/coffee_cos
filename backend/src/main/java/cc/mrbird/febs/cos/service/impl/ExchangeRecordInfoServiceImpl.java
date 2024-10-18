package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.PointCommodityInfoMapper;
import cc.mrbird.febs.cos.dao.UserInfoMapper;
import cc.mrbird.febs.cos.entity.ExchangeRecordInfo;
import cc.mrbird.febs.cos.dao.ExchangeRecordInfoMapper;
import cc.mrbird.febs.cos.entity.PointCommodityInfo;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.IExchangeRecordInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class ExchangeRecordInfoServiceImpl extends ServiceImpl<ExchangeRecordInfoMapper, ExchangeRecordInfo> implements IExchangeRecordInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private PointCommodityInfoMapper pointCommodityInfoMapper;

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

    /**
     * 查询积分物品兑换记录信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @Override
    public LinkedHashMap<String, Object> queryDetail(Integer id) {
        // 返回数据
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        // 兑换记录
        ExchangeRecordInfo exchangeRecord = this.getById(id);
        if (exchangeRecord == null) {
            return result;
        }
        result.put("record", exchangeRecord);
        // 用户信息
        UserInfo userInfo = userInfoMapper.selectById(exchangeRecord.getUserId());
        result.put("user", userInfo);
        // 兑换物品信息
        PointCommodityInfo commodityInfo = pointCommodityInfoMapper.selectById(exchangeRecord.getPointId());
        result.put("commodity", commodityInfo);
        return result;
    }
}
