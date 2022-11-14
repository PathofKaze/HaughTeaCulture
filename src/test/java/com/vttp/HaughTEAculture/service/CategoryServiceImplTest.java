package com.vttp.HaughTEAculture.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.vttp.HaughTEAculture.model.ProductCategory;
import com.vttp.HaughTEAculture.repository.ProductCategoryRepo;
import com.vttp.HaughTEAculture.service.implementation.CategoryServiceImpl;
import com.vttp.HaughTEAculture.exception.Exception;

@RunWith(SpringRunner.class)
public class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private ProductCategoryRepo productCategoryRepository;

    @Test
    public void findByCategoryTypeTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);

        Mockito.when(productCategoryRepository.findByCategoryType(productCategory.getCategoryId())).thenReturn(productCategory);

        categoryService.findByCategoryType(productCategory.getCategoryId());

        Mockito.verify(productCategoryRepository, Mockito.times(1)).findByCategoryType(productCategory.getCategoryId());
    }

    @Test(expected = Exception.class)
    public void findByCategoryTypeExceptionTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);

        Mockito.when(productCategoryRepository.findByCategoryType(productCategory.getCategoryId())).thenReturn(null);

        categoryService.findByCategoryType(productCategory.getCategoryId());
    }
}
