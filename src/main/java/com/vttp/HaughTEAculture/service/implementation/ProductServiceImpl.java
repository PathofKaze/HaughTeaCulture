package com.vttp.HaughTEAculture.service.implementation;

import com.vttp.HaughTEAculture.model.ProductInfo;
import com.vttp.HaughTEAculture.error.ProductStatusError;
import com.vttp.HaughTEAculture.error.ResultError;
import com.vttp.HaughTEAculture.exception.Exception;
import com.vttp.HaughTEAculture.repository.ProductInfoRepo;
import com.vttp.HaughTEAculture.service.CategoryService;
import com.vttp.HaughTEAculture.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepo productInfoRepository;

    @Autowired
    CategoryService categoryService;

    @Override
    public ProductInfo findOne(String productId) {

        ProductInfo productInfo = productInfoRepository.findByProductId(productId);
        return productInfo;
    }

    @Override
    public Page<ProductInfo> findUpAll(Pageable pageable) {
        return productInfoRepository.findAllByProductStatusOrderByProductIdAsc(ProductStatusError.UP.getCode(),pageable);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAllByOrderByProductId(pageable);
    }

    @Override
    public Page<ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable) {
        return productInfoRepository.findAllByCategoryTypeOrderByProductIdAsc(categoryType, pageable);
    }

    @Override
    @Transactional
    public void increaseStock(String productId, int amount) {
        ProductInfo productInfo = findOne(productId);
        if (productInfo == null) throw new Exception(ResultError.PRODUCT_NOT_EXIST);

        int update = productInfo.getProductStock() + amount;
        productInfo.setProductStock(update);
        productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void decreaseStock(String productId, int amount) {
        ProductInfo productInfo = findOne(productId);
        if (productInfo == null) throw new Exception(ResultError.PRODUCT_NOT_EXIST);

        int update = productInfo.getProductStock() - amount;
        if(update <= 0) throw new Exception(ResultError.PRODUCT_NOT_ENOUGH );

        productInfo.setProductStock(update);
        productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = findOne(productId);
        if (productInfo == null) throw new Exception(ResultError.PRODUCT_NOT_EXIST);

        if (productInfo.getProductStatus() == ProductStatusError.DOWN.getCode()) {
            throw new Exception(ResultError.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusError.DOWN.getCode());
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = findOne(productId);
        if (productInfo == null) throw new Exception(ResultError.PRODUCT_NOT_EXIST);

        if (productInfo.getProductStatus() == ProductStatusError.UP.getCode()) {
            throw new Exception(ResultError.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusError.UP.getCode());
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo update(ProductInfo productInfo) {

        categoryService.findByCategoryType(productInfo.getCategoryType());
        if(productInfo.getProductStatus() > 1) {
            throw new Exception(ResultError.PRODUCT_STATUS_ERROR);
        }


        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return update(productInfo);
    }

    @Override
    public void delete(String productId) {
        ProductInfo productInfo = findOne(productId);
        if (productInfo == null) throw new Exception(ResultError.PRODUCT_NOT_EXIST);
        productInfoRepository.delete(productInfo);

    }


}
