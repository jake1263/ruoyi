package com.ruoyi.project.oremouse.user.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.oremouse.user.domain.OremouseUser;
import com.ruoyi.project.oremouse.user.service.IOremouseUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/oremouse/user")
public class OremouseUserController extends BaseController
{
    private String prefix = "oremouse/user";

    @Autowired
    private IOremouseUserService oremouseUserService;

    @RequiresPermissions("oremouse:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("oremouse:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OremouseUser oremouseUser)
    {
        startPage();
        List<OremouseUser> list = oremouseUserService.selectOremouseUserList(oremouseUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("oremouse:user:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OremouseUser oremouseUser)
    {
        List<OremouseUser> list = oremouseUserService.selectOremouseUserList(oremouseUser);
        ExcelUtil<OremouseUser> util = new ExcelUtil<OremouseUser>(OremouseUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("oremouse:user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OremouseUser oremouseUser)
    {
        return toAjax(oremouseUserService.insertOremouseUser(oremouseUser));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        OremouseUser oremouseUser = oremouseUserService.selectOremouseUserById(id);
        mmap.put("oremouseUser", oremouseUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("oremouse:user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OremouseUser oremouseUser)
    {
        return toAjax(oremouseUserService.updateOremouseUser(oremouseUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("oremouse:user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(oremouseUserService.deleteOremouseUserByIds(ids));
    }
}
