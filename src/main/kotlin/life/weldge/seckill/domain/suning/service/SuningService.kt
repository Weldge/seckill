package life.weldge.seckill.domain.suning.service

import com.google.common.collect.ImmutableMap
import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverSuning
import life.weldge.seckill.domain.suning.vo.SuningReserveResult
import life.weldge.seckill.domain.suning.vo.SuningSeckillResult
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class SuningService(
    val driver: DriverSuning
) {

    fun seckillMaotai(): SuningSeckillResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(6L)
            try {
                //点击进入-我的易购
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 965, "y", 2304))
                TimeUnit.SECONDS.sleep(1L)
                //从我的预约中-进入茅台详情页
                it.findElement(
                    AppiumBy.id("com.suning.mobile.ebuy:id/rv_reservation_detail")
                )?.let {element ->
                    element.click()
                }
                //返回
//                it.findElement(
//                    AppiumBy.id("com.suning.mobile.ebuy:id/btn_back")
//                )?.let {element ->
//                    element.click()
//                }
                while (true) {
                    //点击抢购
                    it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 766, "y", 2295))
//                    it.findElement(AppiumBy.id("com.suning.mobile.ebuy:id/tv_reserv_appoitnt")).let {element ->
//                        element.click()
//                    }
                }

                return SuningSeckillResult.fails()
            } catch (e: Exception) {
                log.warn("抢购发生异常，平台：苏宁，原因：'{}'。", e.message)
                return SuningSeckillResult.fails()
            } finally {
                it.closeApp()
            }
        }
    }

    fun reserveMaotai(): SuningReserveResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(6L)
            try {
                //点击进入-我的易购
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 968, "y", 2304))
                TimeUnit.SECONDS.sleep(2L)
                //点击进入- 我的关注
                it.findElement(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"关注\")")
                ).click()
                TimeUnit.SECONDS.sleep(2L)
                //点击进入茅台详情页
                it.findElements(
                    AppiumBy.id("com.suning.mobile.ebuy:id/root_view")
                )[0].click()
                TimeUnit.SECONDS.sleep(2L)
                //预约
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 747, "y", 2298))
                TimeUnit.SECONDS.sleep(2L)
                //判断预约是否成功
                it.findElement(AppiumBy.id("com.suning.mobile.ebuy:id/ordered_title"))?.let {element ->
                    if (element.text.contains("预约成功")) return SuningReserveResult.success()
                }
                return SuningReserveResult.fails()
            }catch (e: Exception) {
                log.warn("预约发生异常，平台：苏宁，原因：'{}'。", e.message)
                return SuningReserveResult.fails()
            }finally {
                //关闭app
                it.closeApp()
            }
        }
    }

    companion object {

        private val log = LoggerFactory.getLogger(SuningService::class.java)
    }
}