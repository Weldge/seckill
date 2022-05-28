package life.weldge.seckill.domain

import io.appium.java_client.MobileBy
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement

abstract class BasePage(driver: AndroidDriver<WebElement>) {

    lateinit var driver: AndroidDriver<WebElement>

    fun locator(by: MobileBy): WebElement {
        return  driver.findElement(by)
    }

    fun input(by: MobileBy, value: String) {
        this.locator(by).sendKeys(value)
    }

    fun click(by: MobileBy) {
        this.locator(by).click()
    }

}