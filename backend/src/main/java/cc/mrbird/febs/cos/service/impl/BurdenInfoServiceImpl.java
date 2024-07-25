package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BurdenInfo;
import cc.mrbird.febs.cos.dao.BurdenInfoMapper;
import cc.mrbird.febs.cos.service.IBurdenInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BurdenInfoServiceImpl extends ServiceImpl<BurdenInfoMapper, BurdenInfo> implements IBurdenInfoService {

    /**
     * 分页获取配料信息
     *
     * @param page       分页对象
     * @param burdenInfo 配料信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectBurdenPage(Page<BurdenInfo> page, BurdenInfo burdenInfo) {
        return baseMapper.selectBurdenPage(page, burdenInfo);
    }
}
