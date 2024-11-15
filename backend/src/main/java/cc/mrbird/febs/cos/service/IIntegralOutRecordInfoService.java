package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.IntegralOutRecordInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IIntegralOutRecordInfoService extends IService<IntegralOutRecordInfo> {

    /**
     * 分页获取积分消费记录信息
     *
     * @param page                  分页对象
     * @param integralOutRecordInfo 积分消费记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectIntegralOutRecordPage(Page<IntegralOutRecordInfo> page, IntegralOutRecordInfo integralOutRecordInfo);

    /**
     * 添加积分消费记录
     *
     * @param integralOutRecordInfo 积分消费记录
     * @return 结果
     */
    boolean integralOutRecordAdd(IntegralOutRecordInfo integralOutRecordInfo);
}
