package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.CommodityInfo;
import cc.mrbird.febs.cos.service.ICommodityInfoService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/commodity-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommodityInfoController {

    private final ICommodityInfoService commodityInfoService;

    /**
     * 分页获取商品信息
     *
     * @param page          分页对象
     * @param commodityInfo 商品信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<CommodityInfo> page, CommodityInfo commodityInfo) {
        return R.ok(commodityInfoService.selectCommodityPage(page, commodityInfo));
    }

    /**
     * 查询商品信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(commodityInfoService.getById(id));
    }

    /**
     * 查询商品信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(commodityInfoService.list(Wrappers.<CommodityInfo>lambdaQuery().eq(CommodityInfo::getDelFlag, "0")));
    }

    /**
     * 新增商品信息
     *
     * @param commodityInfo 商品信息
     * @return 结果
     */
    @PostMapping
    public R save(CommodityInfo commodityInfo) {
        // 商品编号
        commodityInfo.setCode("COM-" + System.currentTimeMillis());
        // 添加时间
        commodityInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(commodityInfoService.save(commodityInfo));
    }

    /**
     * 修改商品信息
     *
     * @param commodityInfo 商品信息
     * @return 结果
     */
    @PutMapping
    public R edit(CommodityInfo commodityInfo) {
        return R.ok(commodityInfoService.updateById(commodityInfo));
    }

    /**
     * 删除商品信息
     *
     * @param ids ids
     * @return 商品信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(commodityInfoService.removeByIds(ids));
    }
}
