package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.StoreQueueInfo;
import cc.mrbird.febs.cos.dao.StoreQueueInfoMapper;
import cc.mrbird.febs.cos.service.IStoreQueueInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class StoreQueueInfoServiceImpl extends ServiceImpl<StoreQueueInfoMapper, StoreQueueInfo> implements IStoreQueueInfoService {

    /**
     * 分页获取用户排号信息
     *
     * @param page           分页对象
     * @param storeQueueInfo 用户排号信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectStoreQueuePage(Page<StoreQueueInfo> page, StoreQueueInfo storeQueueInfo) {
        return baseMapper.selectStoreQueuePage(page, storeQueueInfo);
    }
}
