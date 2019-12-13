package com.ruoyi.project.oremouse.order.service;

import com.ruoyi.project.oremouse.order.domain.Order;

import java.util.List;

public interface IOrderSevice {
	List<Order> listOrderList(Order order);

	String checkReceivingPhoneUnique(Order order);

	int insertOrder(Order order);

	int deleteOrderByIds(String ids);

	int updateOrder(Order order);

	Order selectOrderById(Long orderId);
}
