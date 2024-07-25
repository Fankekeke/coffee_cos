package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BurdenInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBurdenInfoService extends IService<BurdenInfo> {

    /**
     * 分页获取配料信息
     *
     * @param page       分页对象
     * @param burdenInfo 配料信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectBurdenPage(Page<BurdenInfo> page, BurdenInfo burdenInfo);
}
