package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BurdenInfo;
import cc.mrbird.febs.cos.dao.BurdenInfoMapper;
import cc.mrbird.febs.cos.service.IBurdenInfoService;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 获取配料信息树
     *
     * @return 结果
     */
    @Override
    public List<BurdenInfo> queryTreeList() {
        // 获取所有配料信息
        List<BurdenInfo> burdenList = this.list(Wrappers.<BurdenInfo>lambdaQuery().eq(BurdenInfo::getDelFlag, "0"));
        if (CollectionUtil.isEmpty(burdenList)) {
            return Collections.emptyList();
        }

        // 获取最上层数据
        List<BurdenInfo> burdenTopList = burdenList.stream().filter(e -> e.getParentId() == 0).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(burdenList)) {
            return Collections.emptyList();
        }

        // 递归获取数据
        return this.recursiveBuildTree(burdenTopList, burdenList);
    }

    /**
     * 递归设置配料数据
     *
     * @param burdenTopList 最上层数据
     * @param burdenList    所有配料信息
     * @return 结果
     */
    public List<BurdenInfo> recursiveBuildTree(List<BurdenInfo> burdenTopList, List<BurdenInfo> burdenList) {
        for (BurdenInfo burden : burdenTopList) {
            // 获取子集数据
            List<BurdenInfo> childrenBurdenList = burdenList.stream().filter(e -> burden.getId().equals(e.getParentId())).collect(Collectors.toList());
            if (CollectionUtil.isEmpty(childrenBurdenList)) {
                burden.setChildren(new ArrayList<>());
            } else {
                burden.setChildren(childrenBurdenList);
                recursiveBuildTree(childrenBurdenList, burdenList);
            }
        }
        return burdenTopList;
    }

}
