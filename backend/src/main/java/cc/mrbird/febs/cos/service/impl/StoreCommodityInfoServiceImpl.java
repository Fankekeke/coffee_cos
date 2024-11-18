package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.CommodityInfoMapper;
import cc.mrbird.febs.cos.entity.CommodityInfo;
import cc.mrbird.febs.cos.entity.StoreCommodityInfo;
import cc.mrbird.febs.cos.dao.StoreCommodityInfoMapper;
import cc.mrbird.febs.cos.service.IStoreCommodityInfoService;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FanK
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreCommodityInfoServiceImpl extends ServiceImpl<StoreCommodityInfoMapper, StoreCommodityInfo> implements IStoreCommodityInfoService {

    private final CommodityInfoMapper commodityInfoMapper;

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

    /**
     * 根据门店获取商品信息
     *
     * @param storeId 门店ID
     * @return 结果
     */
    @Override
    public List<CommodityInfo> queryCommodityByStore(Integer storeId) {
        // 根据门店获取商品ID
        List<StoreCommodityInfo> storeCommodityInfoList = this.list(Wrappers.<StoreCommodityInfo>lambdaQuery().eq(StoreCommodityInfo::getStoreId, storeId));
        if (CollectionUtil.isEmpty(storeCommodityInfoList)) {
            return Collections.emptyList();
        }

        // 根据商品ID获取商品信息
        List<Integer> commodityIds = storeCommodityInfoList.stream().map(StoreCommodityInfo::getCommodityId).distinct().collect(Collectors.toList());
        return commodityInfoMapper.selectBatchIds(commodityIds);
    }
}
