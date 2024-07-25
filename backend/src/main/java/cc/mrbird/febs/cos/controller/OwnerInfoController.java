package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.OwnerInfo;
import cc.mrbird.febs.cos.service.IOwnerInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/owner-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OwnerInfoController {

    private final IOwnerInfoService ownerInfoService;

    /**
     * 分页获取店主信息
     *
     * @param page      分页对象
     * @param ownerInfo 店主信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<OwnerInfo> page, OwnerInfo ownerInfo) {
        return R.ok(ownerInfoService.selectOwnerPage(page, ownerInfo));
    }

    /**
     * 查询店主信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(ownerInfoService.getById(id));
    }

    /**
     * 查询店主信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(ownerInfoService.list());
    }

    /**
     * 新增店主信息
     *
     * @param ownerInfo 店主信息
     * @return 结果
     */
    @PostMapping
    public R save(OwnerInfo ownerInfo) {
        return R.ok(ownerInfoService.save(ownerInfo));
    }

    /**
     * 修改店主信息
     *
     * @param ownerInfo 店主信息
     * @return 结果
     */
    @PutMapping
    public R edit(OwnerInfo ownerInfo) {
        return R.ok(ownerInfoService.updateById(ownerInfo));
    }

    /**
     * 删除店主信息
     *
     * @param ids ids
     * @return 店主信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(ownerInfoService.removeByIds(ids));
    }
}
