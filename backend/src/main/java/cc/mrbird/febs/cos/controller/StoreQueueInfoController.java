package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.StoreQueueInfo;
import cc.mrbird.febs.cos.service.IStoreQueueInfoService;
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
@RequestMapping("/cos/store-queue-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreQueueInfoController {

    private final IStoreQueueInfoService storeQueueInfoService;

    /**
     * 分页获取用户排号信息
     *
     * @param page           分页对象
     * @param storeQueueInfo 用户排号信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<StoreQueueInfo> page, StoreQueueInfo storeQueueInfo) {
        return R.ok(storeQueueInfoService.selectStoreQueuePage(page, storeQueueInfo));
    }

    /**
     * 查询用户排号信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(storeQueueInfoService.getById(id));
    }

    /**
     * 查询用户排号信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(storeQueueInfoService.list(Wrappers.<StoreQueueInfo>lambdaQuery().eq(StoreQueueInfo::getDelFlag, "0")));
    }

    /**
     * 新增用户排号信息
     *
     * @param storeQueueInfo 用户排号信息
     * @return 结果
     */
    @PostMapping
    public R save(StoreQueueInfo storeQueueInfo) {
        // 排队编号
        storeQueueInfo.setCode("SQ-" + System.currentTimeMillis());
        // 领号时间
        storeQueueInfo.setReceiveDate(DateUtil.formatDateTime(new Date()));
        return R.ok(storeQueueInfoService.save(storeQueueInfo));
    }

    /**
     * 修改用户排号信息
     *
     * @param storeQueueInfo 用户排号信息
     * @return 结果
     */
    @PutMapping
    public R edit(StoreQueueInfo storeQueueInfo) {
        return R.ok(storeQueueInfoService.updateById(storeQueueInfo));
    }

    /**
     * 删除用户排号信息
     *
     * @param ids ids
     * @return 用户排号信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(storeQueueInfoService.removeByIds(ids));
    }
}
