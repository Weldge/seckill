package life.weldge.seckill.domain.yanxuan.service

import com.google.common.collect.ImmutableMap
import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverYanxuan
import life.weldge.seckill.domain.yanxuan.vo.YanxuanReserveResult
import life.weldge.seckill.domain.yanxuan.vo.YanxuanSeckillResult
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class YanxuanService(
    val driver: DriverYanxuan
) {

    fun seckillMaotai(): YanxuanSeckillResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            try {
                //进入个人页面
                it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"个人\")")).click()
                TimeUnit.SECONDS.sleep(2L)
                //点击收藏
                it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"收藏\")")).click()
                TimeUnit.SECONDS.sleep(2L)
                //点击坐标进入-茅台详情页
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 517, "y", 517))
                //开始抢购
                it.findElement(AppiumBy.id("com.netease.yanxuan:id/moutai_promotion_button")).let { element ->
                    while (true) {
                        if (element.isEnabled) {
                            element.click()
                        } else {
                            if (element.text == "本场已抢完") {
                                return YanxuanSeckillResult.fails()
                            }
                        }
                    }
                }
                return YanxuanSeckillResult.success()
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                log.warn("抢购发生异常，平台：苏宁，原因：'{}'。", e.message)
            } finally {
                //退出app
                it.closeApp()
            }
            return YanxuanSeckillResult.fails()
        }
    }

    fun reserveMaotai(): YanxuanReserveResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            try {
                //进入个人页面
                it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"个人\")")).click()
                TimeUnit.SECONDS.sleep(2L)
                //点击收藏
                it.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"收藏\")")).click()
                TimeUnit.SECONDS.sleep(2L)
                //点击坐标进入-茅台详情页
                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 517, "y", 517))
                TimeUnit.SECONDS.sleep(2L)
                //点击立即预约-进入预约页面
                it.findElement(
                    AppiumBy.id("com.netease.yanxuan:id/moutai_promotion_button")
                ).let { element ->
                    if (element.text == "立即预约") element.click()
                    //点击坐标-立即预约
                    it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 535, "y", 2278))
                    return YanxuanReserveResult.success()
                }
                return YanxuanReserveResult.fails()
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                log.warn("预约发生异常，平台：苏宁，原因：'{}'。", e.message)
            } finally {
                //退出app
                it.closeApp()
            }
            return YanxuanReserveResult.fails()
        }
    }

    companion object {

        private val log = LoggerFactory.getLogger(YanxuanService::class.java)
    }
}