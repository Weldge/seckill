package life.weldge.seckill.domain.jd.service

import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverJd
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class JdSeckillService(
    val driver: DriverJd
) {

    fun seckillMaotai() {
        driver.getAndroidDriver().let { //设置全局隐式等待
            it.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) //进入茅台详情页
            it.get(detail)
            try {
                WebDriverWait(it, Duration.ofSeconds(70), Duration.ofMillis(1)).until(
                    ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator("new UiSelector().text(\"立即抢购\")")
                    )
                )

            }catch (e: org.openqa.selenium.NoSuchElementException) {

            }
            var btn = it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"预约\")"))
            //退出app
            it.closeApp()

        }
    }

    fun reserveMaotai() {
        driver.getAndroidDriver().let { //设置全局隐式等待
            it.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) //进入茅台详情页
            it.get(detail)
            try {
                WebDriverWait(it, Duration.ofSeconds(70), Duration.ofMillis(1)).until(
                    ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator("new UiSelector().text(\"立即预约\")")
                    )
                )
                it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"立即预约\")")).click()
            }catch (e: org.openqa.selenium.NoSuchElementException) {

            }
            var btn = it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"等待预约\")"))
            //退出app
            it.closeApp()

        }
    }

    companion object {

        private const val detail =
            "https://item.m.jd.com/product/100012043978.html?gx=RnFjkTVbbj2PmtQUqId1VOmfpTE6-g&ad_od=share&utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=CopyURL"
    }
}