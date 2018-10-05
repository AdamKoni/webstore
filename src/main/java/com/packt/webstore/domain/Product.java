package com.packt.webstore.domain;

import com.packt.webstore.validator.Category;
import com.packt.webstore.validator.ProductId;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@XmlRootElement
public class Product implements Serializable {
    
    private static final long serialVersionUID = 3678107792576131001L;
    
    @Pattern(regexp = "P[0-9]+", message = "{Pattern.Product.productId.validation}")
    @ProductId
    private String productId;
    
    @Size(min = 4, max = 50, message = "{Size.Product.name.validation}")
    private String name;
    
    @Min(value = 0, message = "Min.Product.unitPrice.validation}")
    @Digits(integer = 8, fraction = 2, message = "{Digits.Product.unitPrice.validation}")
    @NotNull(message = "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    
    @Category
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;
    @JsonIgnore
    private MultipartFile productImage;
    
    public Product() {
        super();
    }
    
    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }
    
    @XmlTransient
    public MultipartFile getProductImage() {
        return productImage;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "Produkt [productId=" + productId + ", nazwa=" + name + "]";
    }
}