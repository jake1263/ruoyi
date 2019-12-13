package com.ruoyi.project.oremouse.order.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.models.auth.In;

/**
 * 订单表 oremouse_order
 */
public class Order extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 订单ID */
	private Long orderId;

	/** 订单金额 */
	private Long amount;

	/** 订单状态（1未支付，2已支付，3退款） */
	private Integer orderStatus;

	/** 收货人姓名 */
	private String receivingName;

	/** 收货人手机号码 */
	private String receivingPhone;

	/** 收货人地址 */
	private String receivingAddress;

	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getReceivingName() {
		return receivingName;
	}

	public void setReceivingName(String receivingName) {
		this.receivingName = receivingName;
	}

	public String getReceivingPhone() {
		return receivingPhone;
	}

	public void setReceivingPhone(String receivingPhone) {
		this.receivingPhone = receivingPhone;
	}

	public String getReceivingAddress() {
		return receivingAddress;
	}

	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
