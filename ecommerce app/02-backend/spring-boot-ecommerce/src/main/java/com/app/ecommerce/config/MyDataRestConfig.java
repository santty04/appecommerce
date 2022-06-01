package com.app.ecommerce.config;

import com.app.ecommerce.dao.ProductRepository;
import com.app.ecommerce.entity.Product;
import com.app.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // Deshabilitar los metodos para Product: Put, Post y Delete
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure( (metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure( (metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // Deshabilitar los metodos para ProductCategory: Put, Post y Delete
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure( (metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure( (metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}

