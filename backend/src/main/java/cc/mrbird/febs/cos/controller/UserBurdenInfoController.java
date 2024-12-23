package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.UserBurdenInfo;
import cc.mrbird.febs.cos.service.ICouponInfoService;
import cc.mrbird.febs.cos.service.IUserBurdenInfoService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/user-burden-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserBurdenInfoController {

    private final IUserBurdenInfoService userBurdenInfoService;

    private final ICouponInfoService couponInfoService;

    /**
     * 分页获取用户优惠券信息
     *
     * @param page           分页对象
     * @param userBurdenInfo 用户优惠券信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<UserBurdenInfo> page, UserBurdenInfo userBurdenInfo) {
        return R.ok(userBurdenInfoService.selectUserBurdenPage(page, userBurdenInfo));
    }

    /**
     * 根据用户ID获取未使用的优惠券信息
     *
     * @param userId 用户ID
     * @return 结果
     */
    @GetMapping("/queryNotUseBurdenByUser")
    public R queryNotUseBurdenByUser(@RequestParam("userId") Integer userId) {
        List<UserBurdenInfo> userBurdenInfoList = userBurdenInfoService.queryNotUseBurdenByUser(userId);
        if (CollectionUtil.isEmpty(userBurdenInfoList)) {
            return R.ok(Collections.emptyList());
        }
        // 获取优惠券ID
        List<Integer> couponIds = userBurdenInfoList.stream().map(UserBurdenInfo::getCouponId).distinct().collect(Collectors.toList());
        return R.ok(couponInfoService.listByIds(couponIds));
    }

    /**
     * 查询用户优惠券信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(userBurdenInfoService.getById(id));
    }

    /**
     * 查询用户优惠券信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(userBurdenInfoService.list(Wrappers.<UserBurdenInfo>lambdaQuery().eq(UserBurdenInfo::getDelFlag, "0")));
    }

    /**
     * 新增用户优惠券信息
     *
     * @param userBurdenInfo 用户优惠券信息
     * @return 结果
     */
    @PostMapping
    public R save(UserBurdenInfo userBurdenInfo) {
        // 发放时间
        userBurdenInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(userBurdenInfoService.save(userBurdenInfo));
    }

    /**
     * 修改用户优惠券信息
     *
     * @param userBurdenInfo 用户优惠券信息
     * @return 结果
     */
    @PutMapping
    public R edit(UserBurdenInfo userBurdenInfo) {
        return R.ok(userBurdenInfoService.updateById(userBurdenInfo));
    }

    /**
     * 删除用户优惠券信息
     *
     * @param ids ids
     * @return 用户优惠券信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(userBurdenInfoService.removeByIds(ids));
    }
}
