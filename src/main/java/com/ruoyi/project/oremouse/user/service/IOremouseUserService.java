package com.ruoyi.project.oremouse.user.service;

import com.ruoyi.project.oremouse.user.domain.OremouseUser;
import java.util.List;

/**
 * 用户Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface IOremouseUserService 
{
    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    public OremouseUser selectOremouseUserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param oremouseUser 用户
     * @return 用户集合
     */
    public List<OremouseUser> selectOremouseUserList(OremouseUser oremouseUser);

    /**
     * 新增用户
     * 
     * @param oremouseUser 用户
     * @return 结果
     */
    public int insertOremouseUser(OremouseUser oremouseUser);

    /**
     * 修改用户
     * 
     * @param oremouseUser 用户
     * @return 结果
     */
    public int updateOremouseUser(OremouseUser oremouseUser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOremouseUserByIds(String ids);

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteOremouseUserById(Long id);
}
