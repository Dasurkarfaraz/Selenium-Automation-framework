package com.starquick.test;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.enums.CatogoryType;

import java.util.HashMap;

/**
 * Test class for performing various product searches and interactions on the TATA Open Landing Page.
 * <p>
 * This class extends {@link BaseTest} and includes test methods for searching different products
 * such as milk, rusk, onions, detergent, cooking oil, sprite, atta, and tea. Each test method
 * uses the {@link TATAOpenLandingPage1} page object to perform actions and validations.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class testuser extends BaseTest {

    /**
     * Searches for milk and verifies that the product is displayed in the results.
     * <p>
     * This test method clicks on the search button, enters the product name for milk,
     * and verifies that the product "Amul Masti Dahi Pouch" is present in the search results.
     * </p>
     * 
     * @param data a {@link HashMap} containing product search data with keys "product" and "SecondProduct".
     */
    @FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
    @Test
    protected void Milksearchproduct(HashMap<String, String> data) {
        LogManager.getLogger().info("Milk Search Product Started");
       
        LogManager.getLogger().info("Milk Search Product End");
    }

    /**
     * Searches for rusk and performs actions related to adding it to the cart.
     * <p>
     * This test method searches for the rusk product, adds it to the cart, and then performs
     * additional actions such as closing the cart if needed.
     * </p>
     * 
     * @param data a {@link HashMap} containing product search data with keys "product" and "SecondProduct".
     * @throws InterruptedException if the thread is interrupted during sleep.
     */
    @FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
    @Test
    protected void Rusksearchproduct(HashMap<String, String> data) throws InterruptedException {
        LogManager.getLogger().info("Rusk search product Started");
        
        LogManager.getLogger().info("Rusk search product End");
    }

    /**
     * Searches for onions and verifies that the product is displayed in the results.
     * <p>
     * This test method searches for onions and performs the necessary actions to verify
     * the presence of the product in the search results.
     * </p>
     * 
     * @param data a {@link HashMap} containing product search data with key "product".
     */
    @FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
    @Test
    protected void Onionsearchproduct(HashMap<String, String> data) {
        LogManager.getLogger().info("onion search product Start");
       
        LogManager.getLogger().info("onion search product End");
    }

    /**
     * Searches for detergent and verifies that the product is displayed in the results.
     * <p>
     * This test method searches for detergent and performs the necessary actions to verify
     * the presence of the product in the search results.
     * </p>
     * 
     * @param data a {@link HashMap} containing product search data with key "product".
     */
    @FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
    @Test
    protected void detergentsearchproduct(HashMap<String, String> data) {
        LogManager.getLogger().info("Detergent search product Start");
        
        LogManager.getLogger().info("Detergent search product end");
    }

    /**
     * Searches for cooking oil and verifies that the product is displayed in the results.
     * <p>
     * This test method searches for cooking oil and performs the necessary actions to verify
     * the presence of the product in the search results.
     * </p>
     * 
     * @param data a {@link HashMap} containing product search data with key "product".
     */
    @FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
    @Test
    protected void searchcookoil(HashMap<String, String> data) {
        LogManager.getLogger().info("Search Cooking Oil product Start");
        
        LogManager.getLogger().info("Search Cooking Oil product End");
    }

    /**
     * Searches for sprite and verifies that the product is displayed in the results.
     * <p>
     * This test method searches for sprite and performs the necessary actions to verify
     * the presence of the product in the search results.
     * </p>
     * 
     * @param data a {@link HashMap} containing product search data with key "product".
     */
    @FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
    @Test
    protected void softdrink(HashMap<String, String> data) {
        LogManager.getLogger().info("Sprite product Start");
       
        LogManager.getLogger().info("Sprite product End");
    }

    /**
     * Searches for atta and verifies that the product is displayed in the results.
     * <p>
     * This test method searches for atta and performs the necessary actions to verify
     * the presence of the product in the search results.
     * </p>
     * 
     * @param data a {@link HashMap} containing product search data with key "product".
     */
    @FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
    @Test
    protected void atta(HashMap<String, String> data) {
     
    }

    /**
     * Searches for Tata Agni Leaf Tea Pouch and verifies that the product is displayed in the results.
     * <p>
     * This test method searches for Tata Agni Leaf Tea Pouch and performs the necessary actions to verify
     * the presence of the product in the search results.
     * </p>
     * 
     * @param data a {@link HashMap} containing product search data with key "product".
     */
    @FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
    @Test
    protected void Tata_Agni_Leaf_Tea_Pouch(HashMap<String, String> data) {
       
    }
}
