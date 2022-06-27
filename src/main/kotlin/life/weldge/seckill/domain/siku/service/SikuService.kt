package life.weldge.seckill.domain.siku.service

import com.google.common.collect.ImmutableMap
import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverJd
import life.weldge.seckill.domain.siku.vo.SikuReserveResult
import life.weldge.seckill.domain.siku.vo.SikuSeckillResult
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.concurrent.TimeUnit

@Service
class SikuService(
    val driver: DriverJd
) {

    fun seckillMaotai(): SikuSeckillResult {
        driver.getAndroidDriver().let { //设置全局隐式等待
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
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
                return SikuSeckillResult.success()
            } catch (e: Exception) {
                log.warn("预约发生异常，平台：寺库，原因：'{}'。", e.message)
                return SikuSeckillResult.fails()
            } finally {
                it.closeApp()
            }
        }
    }

    fun reserveMaotai(): SikuReserveResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)

            try {
                //点击我的
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 967, "y", 2307))
                TimeUnit.SECONDS.sleep(2L)
                //点击收藏
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 164, "y", 512))
                TimeUnit.SECONDS.sleep(2L)
                //点击进入茅台详情页面
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 568, "y", 389))
                TimeUnit.SECONDS.sleep(2L)
                //点击预约
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 760, "y", 2287))
                TimeUnit.SECONDS.sleep(2L)
                it.findElement(AppiumBy.id("com.secoo:id/tv_only_sure_dialog_title"))?.let {resultElement ->
                    if (resultElement.text == "预约成功") return SikuReserveResult.success()
                }
                return SikuReserveResult.fails()
            } catch (e: Exception) {
                log.warn("预约发生异常，平台：寺库，原因：'{}'。", e.message)
                return SikuReserveResult.fails()
            } finally {
                //退出app
                it.closeApp()
            }
        }
    }

    companion object {

        private val log = LoggerFactory.getLogger(SikuService::class.java)
    }
}