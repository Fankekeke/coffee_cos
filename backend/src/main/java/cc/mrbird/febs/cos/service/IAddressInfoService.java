package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.AddressInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IAddressInfoService extends IService<AddressInfo> {

    /**
     * 分页获取用户收货地址信息
     *
     * @param page        分页对象
     * @param addressInfo 用户收货地址信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectAddressPage(Page<AddressInfo> page, AddressInfo addressInfo);

    /**
     * 根据用户ID获取收货地址
     *
     * @param userId 用户ID
     * @return 结果
     */
    LinkedHashMap<String, Object> queryAddressByUser(Integer userId);
}
