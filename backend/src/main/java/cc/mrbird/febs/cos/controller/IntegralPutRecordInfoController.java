package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.IntegralPutRecordInfo;
import cc.mrbird.febs.cos.service.IIntegralPutRecordInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/integral-put-record-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IntegralPutRecordInfoController {

    private final IIntegralPutRecordInfoService integralPutRecordInfoService;

    /**
     * 分页获取积分获取记录信息
     *
     * @param page                  分页对象
     * @param integralPutRecordInfo 积分获取记录信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<IntegralPutRecordInfo> page, IntegralPutRecordInfo integralPutRecordInfo) {
        return R.ok(integralPutRecordInfoService.selectIntegralPutRecordPage(page, integralPutRecordInfo));
    }

    /**
     * 查询积分获取记录信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(integralPutRecordInfoService.getById(id));
    }

    /**
     * 查询积分获取记录信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(integralPutRecordInfoService.list());
    }

    /**
     * 新增积分获取记录信息
     *
     * @param integralPutRecordInfo 积分获取记录信息
     * @return 结果
     */
    @PostMapping
    public R save(IntegralPutRecordInfo integralPutRecordInfo) {
        return R.ok(integralPutRecordInfoService.save(integralPutRecordInfo));
    }

    /**
     * 修改积分获取记录信息
     *
     * @param integralPutRecordInfo 积分获取记录信息
     * @return 结果
     */
    @PutMapping
    public R edit(IntegralPutRecordInfo integralPutRecordInfo) {
        return R.ok(integralPutRecordInfoService.updateById(integralPutRecordInfo));
    }

    /**
     * 删除积分获取记录信息
     *
     * @param ids ids
     * @return 积分获取记录信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(integralPutRecordInfoService.removeByIds(ids));
    }
}
