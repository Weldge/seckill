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
                TimeUnit.SECONDS.sleep(2L)
                //点击立即预约
                it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/tv_buy")).click()
                TimeUnit.SECONDS.sleep(2L)
                //点击弹窗立即预约-进入确认页面
                it.findElement(AppiumBy.id("com.yijiuyijiu.eshop:id/btnBuy")).click()
                TimeUnit.SECONDS.sleep(2L)
                //向上拖动确认页面
                it.executeScript("mobile: dragGesture", ImmutableMap.of("startX", 512, "startY", 2215, "endX", 550, "endY", 259))
                TimeUnit.SECONDS.sleep(2L)
                //点击收货地址
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 635, "y", 1430))
                TimeUnit.SECONDS.sleep(2L)
                //选择收货地址
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 481, "y", 448))
                TimeUnit.SECONDS.sleep(2L)
                //点击确定按钮回到确认页面
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 747, "y", 1265))
                TimeUnit.SECONDS.sleep(2L)
                //向上拖动确认页面
                it.executeScript("mobile: dragGesture", ImmutableMap.of("startX", 512, "startY", 2215, "endX", 550, "endY", 259))
                //点击平台确认协议
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 104, "y", 1738))
                TimeUnit.SECONDS.sleep(2L)
                //点击立即预约
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 537, "y", 2024))
                TimeUnit.SECONDS.sleep(2L)
                //判断是否成功-弹窗元素存在即为成功
                it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"NHFMZKDDCT-1Y3VV25APP9A6RAEM7YY\")"))?.let {
                    return YiJiuYiJiuReserveResult.success()
                }
                return YiJiuYiJiuReserveResult.fails()
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