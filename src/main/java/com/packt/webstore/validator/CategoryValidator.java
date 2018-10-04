package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CategoryValidator implements ConstraintValidator<Category, String> {
    
    @Autowired
    private ProductService productService;
    
    private List<String> allowedCategories = Category.allowedCategories;
    
    public void initialize(Category constraintAnnotation) {
        //  celowo pozostawione puste; w tym miejscu naleｿy zainicjowa・adnotacj・ograniczajｹcｹ do sensownych domy徑nych w
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (allowedCategories.contains(value)) {
            return true;
        }
        return false;
    }
}
