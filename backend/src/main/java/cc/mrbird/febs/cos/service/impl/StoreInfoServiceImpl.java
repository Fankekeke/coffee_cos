package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.StoreInfo;
import cc.mrbird.febs.cos.dao.StoreInfoMapper;
import cc.mrbird.febs.cos.service.IStoreInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class StoreInfoServiceImpl extends ServiceImpl<StoreInfoMapper, StoreInfo> implements IStoreInfoService {

    /**
     * 分页获取门店信息
     *
     * @param page      分页对象
     * @param storeInfo 门店信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectStorePage(Page<StoreInfo> page, StoreInfo storeInfo) {
        return baseMapper.selectStorePage(page, storeInfo);
    }
}
