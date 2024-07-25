package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.StoreInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface StoreInfoMapper extends BaseMapper<StoreInfo> {

    /**
     * 分页获取门店信息
     *
     * @param page      分页对象
     * @param storeInfo 门店信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectStorePage(Page<StoreInfo> page, @Param("storeInfo") StoreInfo storeInfo);
}
