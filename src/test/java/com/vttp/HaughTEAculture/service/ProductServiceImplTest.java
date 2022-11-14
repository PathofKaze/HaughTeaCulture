package com.vttp.HaughTEAculture.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.vttp.HaughTEAculture.error.ProductStatusError;
import com.vttp.HaughTEAculture.model.ProductInfo;
import com.vttp.HaughTEAculture.repository.ProductInfoRepo;
import com.vttp.HaughTEAculture.service.implementation.ProductServiceImpl;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductInfoRepo productInfoRepository;

    @Mock
    private CategoryService categoryService;

    private ProductInfo productInfo;

    @Before
    public void setUp() {
        productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductStock(10);
        productInfo.setProductStatus(1);
    }

    @Test
    public void increaseStockTest() {
        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.increaseStock("1", 10);

        Mockito.verify(productInfoRepository, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = Exception.class)
    public void increaseStockExceptionTest() {
        productService.increaseStock("1", 10);
    }

    @Test
    public void decreaseStockTest() {
        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.decreaseStock("1", 9);

        Mockito.verify(productInfoRepository, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = Exception.class)
    public void decreaseStockValueLesserEqualTest() {
        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.decreaseStock("1", 10);
    }

    @Test(expected = Exception.class)
    public void decreaseStockExceptionTest() {
        productService.decreaseStock("1", 10);
    }

    @Test
    public void offSaleTest() {
        productInfo.setProductStatus(ProductStatusError.UP.getCode());

        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.offSale("1");

        Mockito.verify(productInfoRepository, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = Exception.class)
    public void offSaleStatusDownTest() {
        productInfo.setProductStatus(ProductStatusError.DOWN.getCode());

        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.offSale("1");
    }

    @Test(expected = Exception.class)
    public void offSaleProductNullTest() {
        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(null);

        productService.offSale("1");
    }

    @Test
    public void onSaleTest() {
        productInfo.setProductStatus(ProductStatusError.DOWN.getCode());

        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.onSale("1");

        Mockito.verify(productInfoRepository, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = Exception.class)
    public void onSaleStatusUpTest() {
        productInfo.setProductStatus(ProductStatusError.UP.getCode());

        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.onSale("1");
    }

    @Test(expected = Exception.class)
    public void onSaleProductNullTest() {
        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(null);

        productService.offSale("1");
    }

    @Test
    public void updateTest() {
        productService.update(productInfo);

        Mockito.verify(productInfoRepository, Mockito.times(1)).save(productInfo);
    }

    @Test(expected = Exception.class)
    public void updateProductStatusBiggerThenOneTest() {
        productInfo.setProductStatus(2);

        productService.update(productInfo);
    }

    @Test
    public void deleteTest() {
        when(productInfoRepository.findByProductId(productInfo.getProductId())).thenReturn(productInfo);

        productService.delete("1");

        Mockito.verify(productInfoRepository, Mockito.times(1)).delete(productInfo);
    }

    @Test(expected = Exception.class)
    public void deleteProductNullTest() {
        productService.delete("1");
    }
}
