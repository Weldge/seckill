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
class JdSeckillService(
    val driver: DriverJd
) {

    fun seckillMaotai(): JdSeckillResult {
        driver.getAndroidDriver().let { //设置全局隐式等待
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            it.get(detail)
            //等待详情页加载完毕
            TimeUnit.SECONDS.sleep(8L)
            try {
                WebDriverWait(it, Duration.ofSeconds(70), Duration.ofMillis(10L)).until(
                    ExpectedConditions.attributeToBe(
                        AppiumBy.id("com.jd.lib.productdetail.feature:id/g"),
                        "enabled",
                        "true"
                    )
                )
                it.findElement(AppiumBy.id("com.jd.lib.productdetail.feature:id/g")).click()
                return JdSeckillResult("抢购成功")
            } catch (e: Exception) {
                log.error("京东抢购失败，原因：'{}'.", e.message)
            } finally {
                it.closeApp()
            }
            return JdSeckillResult("抢购失败")
        }
    }

    fun reserveMaotai(): JdReserveResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            it.get(detail)
            //等待详情页加载完毕
            TimeUnit.SECONDS.sleep(8L)
            try {
                WebDriverWait(it, Duration.ofSeconds(70), Duration.ofMillis(10)).until(
                    ExpectedConditions.attributeToBe(
                        AppiumBy.id("com.jd.lib.productdetail.feature:id/g"),
                        "text",
                        "立即预约"
                    )
                )
                it.findElement(AppiumBy.id("com.jd.lib.productdetail.feature:id/g")).click()
                return JdReserveResult("预约成功")
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                log.error("京东预约失败，原因：" + e.message)
            } finally {
                //退出app
                it.closeApp()
            }
            return JdReserveResult("预约失败")
        }
    }

    companion object {

        private const val detail =
            "https://item.m.jd.com/product/100012043978.html?gx=RnFjkTVbbj2PmtQUqId1VOmfpTE6-g&ad_od=share&utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=CopyURL"

        private val log = LoggerFactory.getLogger(JdSeckillService::class.java)
    }
}