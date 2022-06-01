package life.weldge.seckill.domain.imoutai.entity

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import life.weldge.seckill.domain.BasePage
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration


/**
 * 茅台100毫升
 */
class Maotai100(driver: AndroidDriver) : BasePage(driver) {

    fun seckill(by: AppiumBy) {
        driver.findElement(by)
        WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(by))
    }
}