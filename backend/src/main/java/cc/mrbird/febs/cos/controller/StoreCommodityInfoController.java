package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.StoreCommodityInfo;
import cc.mrbird.febs.cos.service.IStoreCommodityInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/store-commodity-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreCommodityInfoController {

    private final IStoreCommodityInfoService storeCommodityInfoService;

    /**
     * 分页获取门店商品绑定信息
     *
     * @param page               分页对象
     * @param storeCommodityInfo 门店商品绑定信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<StoreCommodityInfo> page, StoreCommodityInfo storeCommodityInfo) {
        return R.ok(storeCommodityInfoService.selectStoreCommodityPage(page, storeCommodityInfo));
    }

    /**
     * 查询门店商品绑定信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(storeCommodityInfoService.getById(id));
    }

    /**
     * 查询门店商品绑定信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(storeCommodityInfoService.list());
    }

    /**
     * 新增门店商品绑定信息
     *
     * @param storeCommodityInfo 门店商品绑定信息
     * @return 结果
     */
    @PostMapping
    public R save(StoreCommodityInfo storeCommodityInfo) {
        return R.ok(storeCommodityInfoService.save(storeCommodityInfo));
    }

    /**
     * 修改门店商品绑定信息
     *
     * @param storeCommodityInfo 门店商品绑定信息
     * @return 结果
     */
    @PutMapping
    public R edit(StoreCommodityInfo storeCommodityInfo) {
        return R.ok(storeCommodityInfoService.updateById(storeCommodityInfo));
    }

    /**
     * 删除门店商品绑定信息
     *
     * @param ids ids
     * @return 门店商品绑定信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(storeCommodityInfoService.removeByIds(ids));
    }
}
