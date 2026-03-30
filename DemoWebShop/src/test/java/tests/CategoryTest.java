package tests;

import base.BaseTest;
import pages.CategoryPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {

    @Test
    public void testCategoryAndAddProduct() {

        // Step 1: Page object
        CategoryPage categoryPage = new CategoryPage(driver);
        
        
        /*
         String categoryName = "Books";
         String subCategoryName = null;
         String productName = "Computing and Internet";
         */

        // 🔥 Step 2: Test data (can handle BOTH cases)
        String categoryName = "Electronics";
        String subCategoryName = "Cell phones";   // 👉 keep null if not needed
        String productName = "Smartphone";

        // Step 3: Open category
        categoryPage.openCategory(categoryName);

        // Step 4: Validate category navigation
        Assert.assertTrue(categoryPage.isOnCategoryPage(categoryName),
                "Failed to navigate to category: " + categoryName);

        // 🔥 Step 5: Handle subcategory (ONLY if exists)
        if (subCategoryName != null && !subCategoryName.isEmpty()) {
            categoryPage.openSubCategory(subCategoryName);
        }

        // Step 6: Add product
        categoryPage.addProductToCartByName(productName);
    }
}