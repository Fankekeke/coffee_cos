package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.PointCommodityInfo;
import cc.mrbird.febs.cos.dao.PointCommodityInfoMapper;
import cc.mrbird.febs.cos.service.IPointCommodityInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class PointCommodityInfoServiceImpl extends ServiceImpl<PointCommodityInfoMapper, PointCommodityInfo> implements IPointCommodityInfoService {

    /**
     * 分页获取积分商品信息
     *
     * @param page               分页对象
     * @param pointCommodityInfo 积分商品信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectPointCommodity(Page<PointCommodityInfo> page, PointCommodityInfo pointCommodityInfo) {
        return baseMapper.selectPointCommodity(page, pointCommodityInfo);
    }
}
