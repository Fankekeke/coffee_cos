package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.StoreCommodityInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface StoreCommodityInfoMapper extends BaseMapper<StoreCommodityInfo> {

    /**
     * 分页获取门店商品绑定信息
     *
     * @param page               分页对象
     * @param storeCommodityInfo 门店商品绑定信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectStoreCommodityPage(Page<StoreCommodityInfo> page, @Param("storeCommodityInfo") StoreCommodityInfo storeCommodityInfo);
}
