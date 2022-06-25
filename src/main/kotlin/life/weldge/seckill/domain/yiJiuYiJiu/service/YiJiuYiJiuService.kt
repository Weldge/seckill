package life.weldge.seckill.domain.yiJiuYiJiu.service

import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverYiJiuYiJiu
import life.weldge.seckill.domain.yiJiuYiJiu.vo.YiJiuYiJiuReserveResult
import life.weldge.seckill.domain.yiJiuYiJiu.vo.YiJiuYiJiuSeckillResult
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.concurrent.TimeUnit

@Service
class YiJiuYiJiuService(
    val driver: DriverYiJiuYiJiu
) {

    fun seckillMaotai(): YiJiuYiJiuSeckillResult {
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
                return YiJiuYiJiuSeckillResult.success()
            } catch (e: Exception) {
                log.error("<1919吃喝>,抢购失败，原因：'{}'.", e.message)
            } finally {
                it.closeApp()
            }
            return YiJiuYiJiuSeckillResult.fails()
        }
    }

    fun reserveMaotai(): YiJiuYiJiuReserveResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            //关闭悬浮窗口
            it.findElement(
                AppiumBy.id("com.yijiuyijiu.eshop:id/btn_close")
            ).click()
            //进入茅台页面
            it.findElement(
                AppiumBy.id("com.yijiuyijiu.eshop:id/imageContent")
            ).click()
            //

            try {
                WebDriverWait(it, Duration.ofSeconds(70), Duration.ofMillis(10)).until(
                    ExpectedConditions.attributeToBe(
                        AppiumBy.id("com.jd.lib.productdetail.feature:id/g"),
                        "text",
                        "立即预约"
                    )
                )
                it.findElement(AppiumBy.id("com.jd.lib.productdetail.feature:id/g")).click()
                return YiJiuYiJiuReserveResult.success()
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                log.error("<1919吃喝>,预约失败，原因：" + e.message)
            } finally {
                //退出app
                it.closeApp()
            }
            return YiJiuYiJiuReserveResult.fails()
        }
    }

    companion object {

        private val log = LoggerFactory.getLogger(YiJiuYiJiuService::class.java)
    }
}