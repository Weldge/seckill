package life.weldge.seckill.domain.suning.service

import com.google.common.collect.ImmutableMap
import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverSuning
import life.weldge.seckill.domain.suning.vo.SuningReserveResult
import life.weldge.seckill.domain.suning.vo.SuningSeckillResult
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.concurrent.TimeUnit

@Service
class SuningSeckillService(
    val driver: DriverSuning
) {

    fun seckillMaotai(): SuningSeckillResult {
        driver.getAndroidDriver().let { //设置全局隐式等待
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            it.get(detail)
            //等待详情页加载完毕
            TimeUnit.SECONDS.sleep(5L)
            try {
                WebDriverWait(it, Duration.ofSeconds(70), Duration.ofMillis(10L)).until(
                    ExpectedConditions.attributeToBe(
                        AppiumBy.id("com.jd.lib.productdetail.feature:id/g"),
                        "enabled",
                        "true"
                    )
                )
                it.findElement(AppiumBy.id("com.jd.lib.productdetail.feature:id/g")).click()
                return SuningSeckillResult.success()
            } catch (e: Exception) {
                log.error("京东抢购失败，原因：'{}'.", e.message)
            } finally {
                it.closeApp()
            }
            return SuningSeckillResult.fails()
        }
    }

    fun reserveMaotai(): SuningReserveResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(7L)
            //点击进入-我的易购
            it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 968, "y", 2304))
            TimeUnit.SECONDS.sleep(2L)
            //点击进入- 我的关注
            it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"关注\")")).click()
            TimeUnit.SECONDS.sleep(2L)
            //点击进入茅台详情页
            it.findElements(AppiumBy.id("com.suning.mobile.ebuy:id/root_view"))[0].click()
            TimeUnit.SECONDS.sleep(2L)
            //预约
            it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 747, "y", 2298))
            TimeUnit.SECONDS.sleep(2L)
            try {
                return SuningReserveResult.success()
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                log.error("京东预约失败，原因：" + e.message)
            } finally {
                //退出app
                it.closeApp()
            }
            return SuningReserveResult.fails()
        }
    }

    companion object {

        private const val detail =
            "https://m.suning.com/product/0000000000/000000012354857650.html?utm_campaign=1655567113693042812&utm_source=share-copyurl&utm_medium=2cd5ed46-copyurl"

        private val log = LoggerFactory.getLogger(SuningSeckillService::class.java)
    }
}