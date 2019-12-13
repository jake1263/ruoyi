package com.ruoyi.project.oremouse.order.service;

import com.ruoyi.common.constant.OremouseConstants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.oremouse.order.domain.Order;
import com.ruoyi.project.oremouse.order.mapper.OrderMapper;
import com.ruoyi.project.system.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements  IOrderSevice {

	@Autowired(required = false)
	private OrderMapper orderMapper;

	@Override
	public List<Order> listOrderList(Order order) {
		return orderMapper.listOrderList(order);
	}

	@Override
	public String checkReceivingPhoneUnique(Order order) {
		Long postId = StringUtils.isNull(order.getOrderId()) ? -1L : order.getOrderId();
		Order info = orderMapper.checkReceivingPhoneUnique(order.getReceivingPhone());
		if (StringUtils.isNotNull(info) && info.getOrderId().longValue() != postId.longValue())
		{
			 return OremouseConstants.OREMOUSE_ORDER_RECEIVING_PHONE_NOT_UNIQUE;
		}
		return OremouseConstants.OREMOUSE_ORDER_RECEIVING_PHONE_UNIQUE;
	}

	@Override
	public int insertOrder(Order order) {
		return orderMapper.insertOrder(order);
	}

	@Override
	public int deleteOrderByIds(String ids) {
		Long[] orderIds = Convert.toLongArray(ids);
		return orderMapper.deleteOrderByIds(orderIds);
	}

	@Override
	public int updateOrder(Order order) {

		return orderMapper.updateOrder(order);
	}

	@Override
	public Order selectOrderById(Long orderId) {
		Order order = orderMapper.selectOrderById(orderId);
		return order;
	}


}
