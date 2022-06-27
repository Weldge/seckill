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
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            //进入茅台页面
            it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 524, "y", 1396))
            TimeUnit.SECONDS.sleep(4L)
            try {
                //点击我的预约，进入预约列表
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 580, "y", 2115))
                TimeUnit.SECONDS.sleep(3L)
                it.findElement(AppiumBy.className("android.widget.Button"))?.let {detailElement ->
                    if (detailElement.text == "待抢购") {
                        //点击进入茅台详情页
                        detailElement.click()
                        TimeUnit.SECONDS.sleep(1L)
                        //点击数量-进入弹窗
                        it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/layout_product_number")).click()
                        TimeUnit.SECONDS.sleep(1L)
                        //点击减少符号-修改抢购数量为1
                        it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/btnDecrease")).click()
                        TimeUnit.SECONDS.sleep(1L)
                        //关闭数量弹窗-回到详情页，等待抢购
                        it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/iconClose")).click()

                        //点击立即抢购-进入弹窗页
                        it.findElement(
                            AppiumBy.id("com.yijiuyijiu.eshop:id/tv_buy")
                        ).click()
                        //点击弹窗页面-立即抢购
                        it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/btnBuy")).click()
                        //判断抢购结果弹窗
                        it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/titleTv")).let { resultElement ->
                            if (resultElement.text == "抢购失败") {
                                //关闭
                                it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/confirmTextView")).click()
                            }
                            return YiJiuYiJiuSeckillResult.success()
                        }
                    }

                }
                return YiJiuYiJiuSeckillResult.fails()
            } catch (e: Exception) {
                log.warn("抢购发生异常，平台：1919吃喝，原因：'{}'。", e.message)
                return YiJiuYiJiuSeckillResult.fails()
            } finally {
                it.closeApp()
            }
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
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 524, "y", 1396))
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