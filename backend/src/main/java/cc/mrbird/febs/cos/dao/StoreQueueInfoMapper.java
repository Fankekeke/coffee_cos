package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.StoreQueueInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface StoreQueueInfoMapper extends BaseMapper<StoreQueueInfo> {

    /**
     * 分页获取用户排号信息
     *
     * @param page           分页对象
     * @param storeQueueInfo 用户排号信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectStoreQueuePage(Page<StoreQueueInfo> page, @Param("storeQueueInfo") StoreQueueInfo storeQueueInfo);

    /**
     * 获取门店当前排号
     *
     * @param storeId 门店ID
     * @return 结果
     */
    Integer queryQueueByStore(@Param("storeId") Integer storeId);
}
