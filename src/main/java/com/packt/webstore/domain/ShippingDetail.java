package com.packt.webstore.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class ShippingDetail implements Serializable {
    private static final long serialVersionUID = 6350930334140807514L;
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date shippingDate;
    private Address shippingAddress;
    
    public ShippingDetail() {
        this.shippingAddress = new Address();
    }
}