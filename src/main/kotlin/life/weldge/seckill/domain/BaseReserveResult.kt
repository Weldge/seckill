package life.weldge.seckill.domain

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement

abstract class BaseReserveResult(driver: AndroidDriver) {

    lateinit var driver: AndroidDriver

    /**
     * 元素定位
     */
    fun locator(by: AppiumBy): WebElement {
        return  driver.findElement(by)
    }

    /**
     * 元素输入
     */
    fun input(by: AppiumBy, value: String) {
        this.locator(by).sendKeys(value)
    }

    /**
     * 元素点击
     */
    fun click(by: AppiumBy) {
        this.locator(by).click()
    }

}