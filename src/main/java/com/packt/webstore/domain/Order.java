package com.packt.webstore.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Order implements Serializable {
    private static final long serialVersionUID = -3560539622417210365L;
    private Long orderId;
    private Cart cart;
    private Customer customer;
    private ShippingDetail shippingDetail;
    
    public Order() {
        this.customer = new Customer();
        this.shippingDetail = new ShippingDetail();
    }
    
    @Override
    public int hashCode() {
        final int prime = 829;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        return true;
    }
}