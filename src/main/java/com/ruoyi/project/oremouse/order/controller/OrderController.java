package com.ruoyi.project.oremouse.order.controller;

import com.ruoyi.common.constant.OremouseConstants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.oremouse.order.domain.Order;
import com.ruoyi.project.oremouse.order.service.IOrderSevice;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/oremouse/order")
public class OrderController  extends BaseController {

	@Autowired
	private  IOrderSevice  orderSevice;

	private String prefix = "oremouse/order";


	@RequiresPermissions("oremouse:order:view")
	@GetMapping()
	public String operorder()
	{
		return prefix + "/order";
	}

	@RequiresPermissions("oremouse:order:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Order order)
	{
		startPage();
		List<Order> list = orderSevice.listOrderList(order);
		return getDataTable(list);
	}

	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}


	/**
	 * 新增保存订单
	 */
	@RequiresPermissions("oremouse:order:add")
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@Validated Order order){
		if(OremouseConstants.OREMOUSE_ORDER_RECEIVING_PHONE_NOT_UNIQUE.equals(orderSevice.checkReceivingPhoneUnique(order))){
			return error("新增订单失败，收货人手机号' + order.getReceivingPhone() + '已存在");
		}
		return toAjax(orderSevice.insertOrder(order));
	}


	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{orderId}")
	public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap)
	{
		mmap.put("order", orderSevice.selectOrderById(orderId));

		return prefix + "/edit";
	}

	/**
	 * 修改保存订单
	 */
	@RequiresPermissions("oremouse:order:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@Validated Order order)
	{

		if(OremouseConstants.OREMOUSE_ORDER_RECEIVING_PHONE_NOT_UNIQUE.equals(orderSevice.checkReceivingPhoneUnique(order))){
			return error("修改订单失败，收货人手机号' + order.getReceivingPhone() + '已存在");
		}
		return toAjax(orderSevice.updateOrder(order));
	}


	/**
	 * 删除订单
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("oremouse:order:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		try
		{
			return toAjax(orderSevice.deleteOrderByIds(ids));
		}
		catch (Exception e)
		{
			return error(e.getMessage());
		}
	}


	/**
	 * 校验收货人手机号
	 */
	@PostMapping("/checkReceivingPhoneUnique")
	@ResponseBody
	public String checkReceivingPhoneUnique(Order order)
	{
		return orderSevice.checkReceivingPhoneUnique(order);
	}

}
