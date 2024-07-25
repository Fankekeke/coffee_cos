package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.StoreQueueInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IStoreQueueInfoService extends IService<StoreQueueInfo> {

    /**
     * 分页获取用户排号信息
     *
     * @param page           分页对象
     * @param storeQueueInfo 用户排号信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectStoreQueuePage(Page<StoreQueueInfo> page, StoreQueueInfo storeQueueInfo);
}
