package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.IntegralPutRecordInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IIntegralPutRecordInfoService extends IService<IntegralPutRecordInfo> {

    /**
     * 分页获取积分获取记录信息
     *
     * @param page                  分页对象
     * @param integralPutRecordInfo 积分获取记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectIntegralPutRecordPage(Page<IntegralPutRecordInfo> page, IntegralPutRecordInfo integralPutRecordInfo);

    /**
     * 添加积分获取记录
     *
     * @param integralPutRecordInfo 积分获取记录
     * @return 结果
     */
    boolean integralPutRecordAdd(IntegralPutRecordInfo integralPutRecordInfo);
}
