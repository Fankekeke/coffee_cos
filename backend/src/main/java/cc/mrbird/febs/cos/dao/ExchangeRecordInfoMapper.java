package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.ExchangeRecordInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface ExchangeRecordInfoMapper extends BaseMapper<ExchangeRecordInfo> {

    /**
     * 分页获取积分物品兑换记录信息
     *
     * @param page               分页对象
     * @param exchangeRecordInfo 积分物品兑换记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectExchangeRecordPage(Page<ExchangeRecordInfo> page, @Param("exchangeRecordInfo") ExchangeRecordInfo exchangeRecordInfo);
}
