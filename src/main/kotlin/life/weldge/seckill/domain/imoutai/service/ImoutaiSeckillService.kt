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
            //首页进入动画时间太长， 设置显示等待
            it.manage().timeouts().implicitlyWait(Duration.ofSeconds(20))
            WebDriverWait(it, Duration.ofSeconds(30)).until(
                ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"云购\")")
                )
            )
            //进入云购
            it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"云购\")")).click()
            //进入100ml茅台详情页面
            it.findElements(
                AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.view.ViewGroup\").clickable(true)"
                )
            )[1].click()
            //抢购

        }

    }
}