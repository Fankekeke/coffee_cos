package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.IntegralOutRecordInfo;
import cc.mrbird.febs.cos.service.IIntegralOutRecordInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/integral-out-record-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IntegralOutRecordInfoController {

    private final IIntegralOutRecordInfoService integralOutRecordInfoService;

    /**
     * 分页获取积分消费记录信息
     *
     * @param page                  分页对象
     * @param integralOutRecordInfo 积分消费记录信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<IntegralOutRecordInfo> page, IntegralOutRecordInfo integralOutRecordInfo) {
        return R.ok();
    }

    /**
     * 查询积分消费记录信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(integralOutRecordInfoService.getById(id));
    }

    /**
     * 查询积分消费记录信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(integralOutRecordInfoService.list());
    }

    /**
     * 新增积分消费记录信息
     *
     * @param integralOutRecordInfo 积分消费记录信息
     * @return 结果
     */
    @PostMapping
    public R save(IntegralOutRecordInfo integralOutRecordInfo) {
        return R.ok(integralOutRecordInfoService.save(integralOutRecordInfo));
    }

    /**
     * 修改积分消费记录信息
     *
     * @param integralOutRecordInfo 积分消费记录信息
     * @return 结果
     */
    @PutMapping
    public R edit(IntegralOutRecordInfo integralOutRecordInfo) {
        return R.ok(integralOutRecordInfoService.updateById(integralOutRecordInfo));
    }

    /**
     * 删除积分消费记录信息
     *
     * @param ids ids
     * @return 积分消费记录信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(integralOutRecordInfoService.removeByIds(ids));
    }
}
