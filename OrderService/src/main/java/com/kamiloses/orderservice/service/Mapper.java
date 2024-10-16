package com.kamiloses.orderservice.service;

import com.kamiloses.orderservice.dto.MakeAnOrderDto;
import com.kamiloses.orderservice.dto.OrderItemDto;
import com.kamiloses.orderservice.dto.FullOrderDetailsDto;
import com.kamiloses.orderservice.entity.Order;
import com.kamiloses.orderservice.entity.OrderItem;
import com.kamiloses.orderservice.entity.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {


    Order makeAnOrderDtoToOrder(MakeAnOrderDto orderDto) {
        Order order = new Order();
        order.setCustomerId(null);
        order.setOrderItems(orderItemDtoToEntity(orderDto.getOrderItems()));
        order.setStatus(OrderStatus.PENDING);

        return order;
    }

    List<OrderItem> orderItemDtoToEntity(List<OrderItemDto> orderItemDto) {
        return orderItemDto.stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductName(item.getProductName());
            orderItem.setQuantity(item.getQuantity());
            return orderItem;
        }).toList();
    }

    List<FullOrderDetailsDto> OrderItemDtoToResponseProductInfo(List<OrderItemDto> orderItemDto, Double userAccountBalance) {
        return orderItemDto.stream().map(order -> {
            FullOrderDetailsDto responseProduct = new FullOrderDetailsDto();
            responseProduct.setProductName(order.getProductName());
            responseProduct.setQuantity(order.getQuantity());
            responseProduct.setPricePerUnit(null);
            responseProduct.setUserAccountBalance(userAccountBalance);
            return responseProduct;
        }).toList();

    }

    List<OrderItem> responseProductInfoToOrderItem(List<FullOrderDetailsDto> fullOrderDetailsDtoList) {
        return fullOrderDetailsDtoList.stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductName(item.getProductName());
            orderItem.setQuantity(1000);
            orderItem.setPricePerUnit(item.getPricePerUnit());
            return orderItem;
        }).toList();

    }

}
