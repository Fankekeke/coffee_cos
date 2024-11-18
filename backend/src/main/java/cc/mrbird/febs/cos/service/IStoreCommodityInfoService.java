package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.CommodityInfo;
import cc.mrbird.febs.cos.entity.StoreCommodityInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface IStoreCommodityInfoService extends IService<StoreCommodityInfo> {

    /**
     * 分页获取门店商品绑定信息
     *
     * @param page               分页对象
     * @param storeCommodityInfo 门店商品绑定信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectStoreCommodityPage(Page<StoreCommodityInfo> page, StoreCommodityInfo storeCommodityInfo);

    /**
     * 根据门店获取商品信息
     *
     * @param storeId 门店ID
     * @return 结果
     */
    List<CommodityInfo> queryCommodityByStore(Integer storeId);
}
