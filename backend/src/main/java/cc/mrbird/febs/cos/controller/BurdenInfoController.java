package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BurdenInfo;
import cc.mrbird.febs.cos.service.IBurdenInfoService;
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
@RequestMapping("/cos/burden-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BurdenInfoController {

    private final IBurdenInfoService burdenInfoService;

    /**
     * 分页获取配料信息
     *
     * @param page       分页对象
     * @param burdenInfo 配料信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BurdenInfo> page, BurdenInfo burdenInfo) {
        return R.ok(burdenInfoService.selectBurdenPage(page, burdenInfo));
    }

    /**
     * 查询配料信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(burdenInfoService.getById(id));
    }

    /**
     * 查询配料信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(burdenInfoService.list(Wrappers.<BurdenInfo>lambdaQuery().eq(BurdenInfo::getDelFlag, "0")));
    }

    /**
     * 新增配料信息
     *
     * @param burdenInfo 配料信息
     * @return 结果
     */
    @PostMapping
    public R save(BurdenInfo burdenInfo) {
        return R.ok(burdenInfoService.save(burdenInfo));
    }

    /**
     * 修改配料信息
     *
     * @param burdenInfo 配料信息
     * @return 结果
     */
    @PutMapping
    public R edit(BurdenInfo burdenInfo) {
        return R.ok(burdenInfoService.updateById(burdenInfo));
    }

    /**
     * 删除配料信息
     *
     * @param ids ids
     * @return 配料信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(burdenInfoService.removeByIds(ids));
    }
}
