package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.PointCommodityInfo;
import cc.mrbird.febs.cos.service.IPointCommodityInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/point-commodity-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PointCommodityInfoController {

    private final IPointCommodityInfoService pointCommodityInfoService;

    /**
     * 分页获取积分商品信息
     *
     * @param page               分页对象
     * @param pointCommodityInfo 积分商品信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<PointCommodityInfo> page, PointCommodityInfo pointCommodityInfo) {
        return R.ok(pointCommodityInfoService.selectPointCommodity(page, pointCommodityInfo));
    }

    /**
     * 查询积分商品信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(pointCommodityInfoService.getById(id));
    }

    /**
     * 查询积分商品信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(pointCommodityInfoService.list());
    }

    /**
     * 新增积分商品信息
     *
     * @param pointCommodityInfo 积分商品信息
     * @return 结果
     */
    @PostMapping
    public R save(PointCommodityInfo pointCommodityInfo) {
        return R.ok(pointCommodityInfoService.save(pointCommodityInfo));
    }

    /**
     * 修改积分商品信息
     *
     * @param pointCommodityInfo 积分商品信息
     * @return 结果
     */
    @PutMapping
    public R edit(PointCommodityInfo pointCommodityInfo) {
        return R.ok(pointCommodityInfoService.updateById(pointCommodityInfo));
    }

    /**
     * 删除积分商品信息
     *
     * @param ids ids
     * @return 积分商品信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(pointCommodityInfoService.removeByIds(ids));
    }
}
