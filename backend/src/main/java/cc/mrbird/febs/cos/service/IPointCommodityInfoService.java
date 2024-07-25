package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.PointCommodityInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IPointCommodityInfoService extends IService<PointCommodityInfo> {

    /**
     * 分页获取积分商品信息
     *
     * @param page               分页对象
     * @param pointCommodityInfo 积分商品信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectPointCommodity(Page<PointCommodityInfo> page, PointCommodityInfo pointCommodityInfo);
}
