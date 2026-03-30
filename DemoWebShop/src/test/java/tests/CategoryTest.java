package tests;

import base.BaseTest;
import pages.CategoryPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {

    @Test
    public void testCategoryAndAddProduct() {
        CategoryPage categoryPage = new CategoryPage(driver);
        
        
        /*
         String categoryName = "Books";
         String subCategoryName = null;
         String productName = "Computing and Internet";
         */

        String categoryName = "Electronics";
        String subCategoryName = "Cell phones";
        String productName = "Smartphone";

        categoryPage.openCategory(categoryName);

        Assert.assertTrue(categoryPage.isOnCategoryPage(categoryName), "Failed to navigate to category: " + categoryName);

        if (subCategoryName != null && !subCategoryName.isEmpty()) {
            categoryPage.openSubCategory(subCategoryName);
        }

        categoryPage.addProductToCartByName(productName);
    }
}