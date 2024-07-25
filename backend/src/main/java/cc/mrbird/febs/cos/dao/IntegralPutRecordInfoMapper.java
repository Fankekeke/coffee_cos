package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.IntegralPutRecordInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IntegralPutRecordInfoMapper extends BaseMapper<IntegralPutRecordInfo> {

    /**
     * 分页获取积分获取记录信息
     *
     * @param page                  分页对象
     * @param integralPutRecordInfo 积分获取记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectIntegralPutRecordPage(Page<IntegralPutRecordInfo> page, @Param("integralPutRecordInfo") IntegralPutRecordInfo integralPutRecordInfo);
}
