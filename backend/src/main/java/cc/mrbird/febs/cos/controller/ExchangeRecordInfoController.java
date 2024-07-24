package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.ExchangeRecordInfo;
import cc.mrbird.febs.cos.service.IExchangeRecordInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/exchange-record-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExchangeRecordInfoController {

    private final IExchangeRecordInfoService exchangeRecordInfoService;

    /**
     * 分页获取积分物品兑换记录信息
     *
     * @param page               分页对象
     * @param exchangeRecordInfo 积分物品兑换记录信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<ExchangeRecordInfo> page, ExchangeRecordInfo exchangeRecordInfo) {
        return R.ok();
    }

    /**
     * 查询积分物品兑换记录信息详情
     *
     * @param id 主键ID
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(exchangeRecordInfoService.getById(id));
    }

    /**
     * 查询积分物品兑换记录信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(exchangeRecordInfoService.list());
    }

    /**
     * 新增积分物品兑换记录信息
     *
     * @param exchangeRecordInfo 积分物品兑换记录信息
     * @return 结果
     */
    @PostMapping
    public R save(ExchangeRecordInfo exchangeRecordInfo) {
        return R.ok(exchangeRecordInfoService.save(exchangeRecordInfo));
    }

    /**
     * 修改积分物品兑换记录信息
     *
     * @param exchangeRecordInfo 积分物品兑换记录信息
     * @return 结果
     */
    @PutMapping
    public R edit(ExchangeRecordInfo exchangeRecordInfo) {
        return R.ok(exchangeRecordInfoService.updateById(exchangeRecordInfo));
    }

    /**
     * 删除积分物品兑换记录信息
     *
     * @param ids ids
     * @return 积分物品兑换记录信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(exchangeRecordInfoService.removeByIds(ids));
    }
}