package life.weldge.seckill.domain.zhenkuaile.service

import com.google.common.collect.ImmutableMap
import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverImoutai
import life.weldge.seckill.config.DriverYiJiuYiJiu
import life.weldge.seckill.domain.zhenkuaile.vo.ZhenkuaileReserveResult
import life.weldge.seckill.domain.zhenkuaile.vo.ZhenkuaileSeckillResult
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.concurrent.TimeUnit

@Service
class ZhenkuaileService(
    val driver: DriverYiJiuYiJiu,
    val driverImoutai: DriverImoutai,
) {

    fun seckillMaotai(): ZhenkuaileSeckillResult {
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
                return ZhenkuaileSeckillResult.fails()
            } catch (e: Exception) {
                log.warn("抢购发生异常，平台：真快乐，原因：'{}'。", e.message)
                return ZhenkuaileSeckillResult.fails()
            } finally {
                it.closeApp()
            }
        }
    }

    fun reserveMaotai(): ZhenkuaileReserveResult {
        driverImoutai.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            try {
                //点击进入-我的
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 971, "y", 2302))
                TimeUnit.SECONDS.sleep(2L)
                //点击收藏
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 131, "y", 721))
                TimeUnit.SECONDS.sleep(2L)
                //点击收藏列表第一项-进入茅台详情页
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 563, "y", 658))
                TimeUnit.SECONDS.sleep(2L)

                return ZhenkuaileReserveResult.fails()
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                log.warn("预约发生异常，平台：真快乐，原因：'{}'。", e.message)
                return ZhenkuaileReserveResult.fails()
            } finally {
                //退出app
                it.closeApp()
            }
        }
    }

    companion object {

        private val log = LoggerFactory.getLogger(ZhenkuaileService::class.java)
    }
}