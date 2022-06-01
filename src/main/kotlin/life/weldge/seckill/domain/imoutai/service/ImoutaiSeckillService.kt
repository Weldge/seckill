package life.weldge.seckill.domain.imoutai.service

import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverImoutai
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class ImoutaiSeckillService(
    val driver: DriverImoutai
) {

    fun seckillMaotai100() {
        driver.getAndroidDriver().let { it ->
            //设置隐式等待
            it.manage().timeouts().implicitlyWait(Duration.ofSeconds(20))
            WebDriverWait(it, Duration.ofSeconds(30)).until(
                ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"云购\")")
                )
            )
            //进入云购
            var yungou = it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"云购\")"))
            yungou.click()
            //进入100ml茅台详情页面
            var detail = it.findElement(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"¥399/瓶\")")
            )
            detail.click()

        }

    }
}