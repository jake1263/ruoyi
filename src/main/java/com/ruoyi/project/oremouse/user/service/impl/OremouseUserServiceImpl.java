package com.ruoyi.project.oremouse.user.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.oremouse.user.mapper.OremouseUserMapper;
import com.ruoyi.project.oremouse.user.domain.OremouseUser;
import com.ruoyi.project.oremouse.user.service.IOremouseUserService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class OremouseUserServiceImpl implements IOremouseUserService 
{
    @Autowired
    private OremouseUserMapper oremouseUserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public OremouseUser selectOremouseUserById(Long id)
    {
        return oremouseUserMapper.selectOremouseUserById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param oremouseUser 用户
     * @return 用户
     */
    @Override
    public List<OremouseUser> selectOremouseUserList(OremouseUser oremouseUser)
    {
        return oremouseUserMapper.selectOremouseUserList(oremouseUser);
    }

    /**
     * 新增用户
     * 
     * @param oremouseUser 用户
     * @return 结果
     */
    @Override
    public int insertOremouseUser(OremouseUser oremouseUser)
    {
        return oremouseUserMapper.insertOremouseUser(oremouseUser);
    }

    /**
     * 修改用户
     * 
     * @param oremouseUser 用户
     * @return 结果
     */
    @Override
    public int updateOremouseUser(OremouseUser oremouseUser)
    {
        return oremouseUserMapper.updateOremouseUser(oremouseUser);
    }

    /**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOremouseUserByIds(String ids)
    {
        return oremouseUserMapper.deleteOremouseUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    @Override
    public int deleteOremouseUserById(Long id)
    {
        return oremouseUserMapper.deleteOremouseUserById(id);
    }
}
