package com.vj.ecommerce.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.vj.ecommerce.entities.Product;
import com.vj.ecommerce.entities.ProductCategory;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		HttpMethod[] unSupportedMethods = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		
		config.getExposureConfiguration().forDomainType(Product.class)
		    .withItemExposure((metadata,httpMethods)->httpMethods.disable(unSupportedMethods))
		    .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(unSupportedMethods));
		
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
	    .withItemExposure((metadata,httpMethods)->httpMethods.disable(unSupportedMethods))
	    .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(unSupportedMethods));
		
	}
	
	

}
