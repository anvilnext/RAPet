package config;

public class PagePaths {

    public static String USERNAME_INPUT = "//input[@placeholder='Username']";
    public static String PASSWORD_INPUT = "//input[@placeholder='Password']";
    public static String ADD_TO_CART_BUTTON = "//div[@class='inventory_item_name'][text()='%s']//ancestor::div[@class='inventory_item']//button";
    public static String SHOPPING_CART_LABEL = "//a[@class='shopping_cart_link']";
    public static String SHOPPING_CART_ITEMS = "//div[@class='inventory_item_name']";
    public static String SHOPPING_CART_ITEM_LABEL = "//div[@class='inventory_item_name'][text()='%s']";

}
