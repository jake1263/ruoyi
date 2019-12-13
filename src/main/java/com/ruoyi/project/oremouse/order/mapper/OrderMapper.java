package com.ruoyi.project.oremouse.order.mapper;

import com.ruoyi.project.oremouse.order.domain.Order;

import java.util.List;

public interface OrderMapper {

	  List<Order> listOrderList(Order order);

	  Order checkReceivingPhoneUnique(String receivingPhone);

	  int insertOrder(Order order);

	  int deleteOrderByIds(Long[] orderIds);

	  Order selectOrderById(Long orderId);

	   int updateOrder(Order order);
}
