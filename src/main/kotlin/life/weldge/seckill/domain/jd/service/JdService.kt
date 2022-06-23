package life.weldge.seckill.domain.jd.service

import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverJd
import life.weldge.seckill.domain.jd.vo.JdReserveResult
import life.weldge.seckill.domain.jd.vo.JdSeckillResult
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.concurrent.TimeUnit

@Service
class JdService(
    val driver: DriverJd
) {

    fun seckillMaotai(): JdSeckillResult {
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
                return JdSeckillResult.success()
            } catch (e: Exception) {
                log.error("京东抢购失败，原因：'{}'.", e.message)
            } finally {
                it.closeApp()
            }
            return JdSeckillResult.fails()
        }
    }

    fun reserveMaotai(): JdReserveResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(6L)
            try {
                //进入茅台详情页
                it.get(detail)
                //等待详情页加载完毕
                TimeUnit.SECONDS.sleep(2L)
                it.findElement(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"立即预约\")")
                )?.let {element ->
                    element.click()
                }
                return JdReserveResult.success()
            } catch (e: Exception) {
                log.warn("预约发生异常，平台：京东，原因：'{}'。", e.message)
                return JdReserveResult.fails()
            } finally {
                //退出app
                it.closeApp()
            }
        }
    }

    companion object {

        private const val detail =
            "https://item.m.jd.com/product/100012043978.html?gx=RnFjkTVbbj2PmtQUqId1VOmfpTE6-g&ad_od=share&utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=CopyURL"

        private val log = LoggerFactory.getLogger(JdService::class.java)
    }
}