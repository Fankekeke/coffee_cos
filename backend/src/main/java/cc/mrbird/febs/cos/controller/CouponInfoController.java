package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.CouponInfo;
import cc.mrbird.febs.cos.service.ICouponInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/coupon-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CouponInfoController {

    private final ICouponInfoService couponInfoService;

    /**
     * 分页获取优惠券信息
     *
     * @param page       分页对象
     * @param couponInfo 优惠券信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<CouponInfo> page, CouponInfo couponInfo) {
        return R.ok();
    }

    /**
     * 查询优惠券信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(couponInfoService.getById(id));
    }

    /**
     * 查询优惠券信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(couponInfoService.list());
    }

    /**
     * 新增优惠券信息
     *
     * @param couponInfo 优惠券信息
     * @return 结果
     */
    @PostMapping
    public R save(CouponInfo couponInfo) {
        return R.ok(couponInfoService.save(couponInfo));
    }

    /**
     * 修改优惠券信息
     *
     * @param couponInfo 优惠券信息
     * @return 结果
     */
    @PutMapping
    public R edit(CouponInfo couponInfo) {
        return R.ok(couponInfoService.updateById(couponInfo));
    }

    /**
     * 删除优惠券信息
     *
     * @param ids ids
     * @return 优惠券信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(couponInfoService.removeByIds(ids));
    }
}
