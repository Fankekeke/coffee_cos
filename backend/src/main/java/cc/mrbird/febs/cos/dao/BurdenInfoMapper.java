package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BurdenInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface BurdenInfoMapper extends BaseMapper<BurdenInfo> {

    /**
     * 分页获取配料信息
     *
     * @param page       分页对象
     * @param burdenInfo 配料信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectBurdenPage(Page<BurdenInfo> page, @Param("burdenInfo") BurdenInfo burdenInfo);
}
