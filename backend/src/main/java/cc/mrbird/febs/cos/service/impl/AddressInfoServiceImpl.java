package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.UserInfoMapper;
import cc.mrbird.febs.cos.entity.AddressInfo;
import cc.mrbird.febs.cos.dao.AddressInfoMapper;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.IAddressInfoService;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressInfoServiceImpl extends ServiceImpl<AddressInfoMapper, AddressInfo> implements IAddressInfoService {

    private final UserInfoMapper userInfoMapper;

    /**
     * 分页获取用户收货地址信息
     *
     * @param page        分页对象
     * @param addressInfo 用户收货地址信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectAddressPage(Page<AddressInfo> page, AddressInfo addressInfo) {
        return baseMapper.selectAddressPage(page, addressInfo);
    }

    /**
     * 根据用户ID获取收货地址
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public LinkedHashMap<String, Object> queryAddressByUser(Integer userId) {
        // 返回信息
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>() {
            {
                put("default", null);
                put("address", Collections.emptyList());
            }
        };
        // 获取用户信息
        UserInfo userInfo = userInfoMapper.selectOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, userId));
        if (userInfo == null) {
            return result;
        }

        // 获取用户收货地址
        List<AddressInfo> addressList = this.list(Wrappers.<AddressInfo>lambdaQuery().eq(AddressInfo::getUserId, userInfo.getId()));
        if (CollectionUtil.isEmpty(addressList)) {
            return result;
        }
        result.put("default", addressList.stream().filter(e -> "1".equals(e.getDefaultFlag())).findFirst().orElse(null));
        result.put("address", addressList);
        return result;
    }
}
