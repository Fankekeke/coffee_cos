package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.PointCommodityInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface PointCommodityInfoMapper extends BaseMapper<PointCommodityInfo> {

    /**
     * 分页获取积分商品信息
     *
     * @param page               分页对象
     * @param pointCommodityInfo 积分商品信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectPointCommodity(Page<PointCommodityInfo> page, @Param("pointCommodityInfo") PointCommodityInfo pointCommodityInfo);
}
