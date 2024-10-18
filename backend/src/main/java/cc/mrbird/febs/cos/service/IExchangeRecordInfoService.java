package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.ExchangeRecordInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IExchangeRecordInfoService extends IService<ExchangeRecordInfo> {

    /**
     * 分页获取积分物品兑换记录信息
     *
     * @param page               分页对象
     * @param exchangeRecordInfo 积分物品兑换记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectExchangeRecordPage(Page<ExchangeRecordInfo> page, ExchangeRecordInfo exchangeRecordInfo);

    /**
     * 查询积分物品兑换记录信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    LinkedHashMap<String, Object> queryDetail(Integer id);
}
