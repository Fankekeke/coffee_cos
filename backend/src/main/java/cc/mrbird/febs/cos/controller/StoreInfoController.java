package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.StoreInfo;
import cc.mrbird.febs.cos.service.IStoreInfoService;
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
@RequestMapping("/cos/store-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreInfoController {

    private final IStoreInfoService storeInfoService;

    /**
     * 分页获取门店信息
     *
     * @param page      分页对象
     * @param storeInfo 门店信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<StoreInfo> page, StoreInfo storeInfo) {
        return R.ok(storeInfoService.selectStorePage(page, storeInfo));
    }

    /**
     * 查询门店信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(storeInfoService.getById(id));
    }

    /**
     * 查询门店信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(storeInfoService.list(Wrappers.<StoreInfo>lambdaQuery().eq(StoreInfo::getDelFlag, "0")));
    }

    /**
     * 新增门店信息
     *
     * @param storeInfo 门店信息
     * @return 结果
     */
    @PostMapping
    public R save(StoreInfo storeInfo) {
        return R.ok(storeInfoService.save(storeInfo));
    }

    /**
     * 修改门店信息
     *
     * @param storeInfo 门店信息
     * @return 结果
     */
    @PutMapping
    public R edit(StoreInfo storeInfo) {
        return R.ok(storeInfoService.updateById(storeInfo));
    }

    /**
     * 删除门店信息
     *
     * @param ids ids
     * @return 门店信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(storeInfoService.removeByIds(ids));
    }
}
