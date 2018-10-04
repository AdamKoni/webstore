package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductImageValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        long allowedSize = 10000000;
        if (product.getProductImage() != null && product.getProductImage().getSize() >= allowedSize) {
            errors.rejectValue("ProductImage", "com.packt.webstore.validator.ProductImageValidator.message");
        }
    }
}
