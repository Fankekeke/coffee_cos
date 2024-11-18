package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.UserBurdenInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface IUserBurdenInfoService extends IService<UserBurdenInfo> {

    /**
     * 分页获取用户优惠券信息
     *
     * @param page           分页对象
     * @param userBurdenInfo 用户优惠券信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectUserBurdenPage(Page<UserBurdenInfo> page, UserBurdenInfo userBurdenInfo);

    /**
     * 根据用户ID获取未使用的优惠券信息
     *
     * @param userId 用户ID
     * @return 结果
     */
    List<UserBurdenInfo> queryNotUseBurdenByUser(Integer userId);
}
