package life.weldge.seckill.domain.yiJiuYiJiu.service

import com.google.common.collect.ImmutableMap
import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverYiJiuYiJiu
import life.weldge.seckill.domain.suning.service.SuningService
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
            try {
                //进入茅台页面
                it.findElement(
                    AppiumBy.id("com.yijiuyijiu.eshop:id/imageContent")
                ).click()
                TimeUnit.SECONDS.sleep(3L)
                //点击我的预约，进入预约列表
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 580, "y", 2115))
                TimeUnit.SECONDS.sleep(2L)
                //进入茅台详情页面
                it.findElement(AppiumBy.className("android.widget.Button"))?.let {element ->
                    if (element.text == "预约中") element.click()
                }
                TimeUnit.SECONDS.sleep(2L)
                //点击抢购
                //点击弹窗抢购
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
//            it.findElement(
//                AppiumBy.id("com.yijiuyijiu.eshop:id/btn_close")
//            ).click()
            try {
                //进入茅台页面
                it.findElement(
                    AppiumBy.id("com.yijiuyijiu.eshop:id/imageContent")
                ).click()
                TimeUnit.SECONDS.sleep(3L)
                //点击立即预约
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 570, "y", 1900))
                //点击立即预约
                it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/tv_buy")).click()
                //点击弹窗立即预约
                it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/btnBuy")).click()
//                WebDriverWait(it, Duration.ofSeconds(70), Duration.ofMillis(10)).until(
//                    ExpectedConditions.attributeToBe(
//                        AppiumBy.id("com.jd.lib.productdetail.feature:id/g"),
//                        "text",
//                        "立即预约"
//                    )
//                )
                return YiJiuYiJiuReserveResult.success()
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                log.warn("预约发生异常，平台：1919吃喝，原因：'{}'。", e.message)
                return YiJiuYiJiuReserveResult.fails()
            } finally {
                //退出app
                it.closeApp()
            }
        }
    }

    companion object {

        private val log = LoggerFactory.getLogger(YiJiuYiJiuService::class.java)
    }
}