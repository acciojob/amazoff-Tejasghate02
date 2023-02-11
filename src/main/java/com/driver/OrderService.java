package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository=new OrderRepository();

    public void addOrder(@RequestBody Order order){
        orderRepository.addOrder(order);
    }


    public void addPartner(@PathVariable String partnerId){
        orderRepository.addPartner(partnerId);
    }

    public void addOrderPartnerPair(@RequestParam String orderId, @RequestParam String partnerId){

        //This is basically assigning that order to that partnerId
         orderRepository.addOrderPartnerPair(orderId,partnerId);
    }

    public Order getOrderById(@PathVariable String orderId){

        return orderRepository.getOrderById(orderId);
    }


    public DeliveryPartner getPartnerById(@PathVariable String partnerId){

        return orderRepository.getPartnerById(partnerId);
    }


    public Integer getOrderCountByPartnerId(@PathVariable String partnerId){

        return orderRepository.getOrderCountByPartnerId(partnerId);
    }


    public List<String> getOrdersByPartnerId(@PathVariable String partnerId){

        return orderRepository.getOrdersByPartnerId(partnerId);
    }

    public List<String> getAllOrders(){

        return orderRepository.getAllOrders();
    }

    public Integer getCountOfUnassignedOrders(){

        return orderRepository.getCountOfUnassignedOrders();
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(@PathVariable String time, @PathVariable String partnerId){

        return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(time,partnerId);
    }

    public String getLastDeliveryTimeByPartnerId(@PathVariable String partnerId){

        return orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
    }


    public void deletePartnerById(@PathVariable String partnerId){

        //Delete the partnerId
        //And push all his assigned orders to unassigned orders.

        orderRepository.deletePartnerById(partnerId);
    }


    public String deleteOrderById(@PathVariable String orderId){

        //Delete an order and also
        // remove it from the assigned order of that partnerId

        return deleteOrderById(orderId);
    }

}
