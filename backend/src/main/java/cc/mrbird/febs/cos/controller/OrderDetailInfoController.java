package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.OrderDetailInfo;
import cc.mrbird.febs.cos.service.IOrderDetailInfoService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/order-detail-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderDetailInfoController {

    private final IOrderDetailInfoService orderDetailInfoService;

    /**
     * 分页获取订单选购详情信息
     *
     * @param page            分页对象
     * @param orderDetailInfo 订单选购详情信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<OrderDetailInfo> page, OrderDetailInfo orderDetailInfo) {
        return R.ok();
    }

    /**
     * 查询订单选购详情信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(orderDetailInfoService.getById(id));
    }

    /**
     * 查询订单选购详情信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(orderDetailInfoService.list(Wrappers.<OrderDetailInfo>lambdaQuery().eq(OrderDetailInfo::getDelFlag, "0")));
    }

    /**
     * 新增订单选购详情信息
     *
     * @param orderDetailInfo 订单选购详情信息
     * @return 结果
     */
    @PostMapping
    public R save(OrderDetailInfo orderDetailInfo) {
        return R.ok(orderDetailInfoService.save(orderDetailInfo));
    }

    /**
     * 修改订单选购详情信息
     *
     * @param orderDetailInfo 订单选购详情信息
     * @return 结果
     */
    @PutMapping
    public R edit(OrderDetailInfo orderDetailInfo) {
        return R.ok(orderDetailInfoService.updateById(orderDetailInfo));
    }

    /**
     * 删除订单选购详情信息
     *
     * @param ids ids
     * @return 订单选购详情信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(orderDetailInfoService.removeByIds(ids));
    }
}
