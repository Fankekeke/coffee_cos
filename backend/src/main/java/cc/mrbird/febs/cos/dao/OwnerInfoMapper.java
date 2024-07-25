package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.OwnerInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface OwnerInfoMapper extends BaseMapper<OwnerInfo> {

    /**
     * 分页获取店主信息
     *
     * @param page      分页对象
     * @param ownerInfo 店主信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectOwnerPage(Page<OwnerInfo> page, @Param("ownerInfo") OwnerInfo ownerInfo);
}
