package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.OwnerInfo;
import cc.mrbird.febs.cos.dao.OwnerInfoMapper;
import cc.mrbird.febs.cos.service.IOwnerInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class OwnerInfoServiceImpl extends ServiceImpl<OwnerInfoMapper, OwnerInfo> implements IOwnerInfoService {

    /**
     * 分页获取店主信息
     *
     * @param page      分页对象
     * @param ownerInfo 店主信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectOwnerPage(Page<OwnerInfo> page, OwnerInfo ownerInfo) {
        return baseMapper.selectOwnerPage(page, ownerInfo);
    }
}
