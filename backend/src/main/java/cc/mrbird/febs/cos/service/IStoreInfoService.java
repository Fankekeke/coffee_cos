package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.StoreInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IStoreInfoService extends IService<StoreInfo> {

    /**
     * 分页获取门店信息
     *
     * @param page      分页对象
     * @param storeInfo 门店信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectStorePage(Page<StoreInfo> page, StoreInfo storeInfo);
}
