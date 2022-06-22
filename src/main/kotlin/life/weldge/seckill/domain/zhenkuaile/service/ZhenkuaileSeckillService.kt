package life.weldge.seckill.domain.zhenkuaile.service

import io.appium.java_client.AppiumBy
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
class ZhenkuaileSeckillService(
    val driver: DriverYiJiuYiJiu
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
                return ZhenkuaileSeckillResult.success()
            } catch (e: Exception) {
                log.error("<1919吃喝>,抢购失败，原因：'{}'.", e.message)
            } finally {
                it.closeApp()
            }
            return ZhenkuaileSeckillResult.fails()
        }
    }

    fun reserveMaotai(): ZhenkuaileReserveResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            //关闭悬浮窗口
            it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/btn_close")).click()
            //进入茅台页面
            it.findElement(
                AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"com.yijiuyijiu.eshop:id/tvName\").text(\"抢茅台\")"
                )
            ).click()

            try {
                WebDriverWait(it, Duration.ofSeconds(70), Duration.ofMillis(10)).until(
                    ExpectedConditions.attributeToBe(
                        AppiumBy.id("com.jd.lib.productdetail.feature:id/g"),
                        "text",
                        "立即预约"
                    )
                )
                it.findElement(AppiumBy.id("com.jd.lib.productdetail.feature:id/g")).click()
                return ZhenkuaileReserveResult.success()
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                log.error("<1919吃喝>,预约失败，原因：" + e.message)
            } finally {
                //退出app
                it.closeApp()
            }
            return ZhenkuaileReserveResult.fails()
        }
    }

    companion object {

        private val log = LoggerFactory.getLogger(ZhenkuaileSeckillService::class.java)
    }
}