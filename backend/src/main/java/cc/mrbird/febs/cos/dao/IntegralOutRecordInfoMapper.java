package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.IntegralOutRecordInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IntegralOutRecordInfoMapper extends BaseMapper<IntegralOutRecordInfo> {

    /**
     * 分页获取积分消费记录信息
     *
     * @param page                  分页对象
     * @param integralOutRecordInfo 积分消费记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectIntegralOutRecordPage(Page<IntegralOutRecordInfo> page, @Param("integralOutRecordInfo") IntegralOutRecordInfo integralOutRecordInfo);
}
