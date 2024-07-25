package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.UserBurdenInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

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
}
