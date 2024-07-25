package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.StoreCommodityInfo;
import cc.mrbird.febs.cos.dao.StoreCommodityInfoMapper;
import cc.mrbird.febs.cos.service.IStoreCommodityInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class StoreCommodityInfoServiceImpl extends ServiceImpl<StoreCommodityInfoMapper, StoreCommodityInfo> implements IStoreCommodityInfoService {

    /**
     * 分页获取门店商品绑定信息
     *
     * @param page               分页对象
     * @param storeCommodityInfo 门店商品绑定信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectStoreCommodityPage(Page<StoreCommodityInfo> page, StoreCommodityInfo storeCommodityInfo) {
        return baseMapper.selectStoreCommodityPage(page, storeCommodityInfo);
    }
}
