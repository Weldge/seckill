package life.weldge.seckill.domain.imoutai.service

import com.google.common.collect.ImmutableMap
import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverImoutai
import life.weldge.seckill.domain.imoutai.vo.ImoutaiSeckillResult
import life.weldge.seckill.domain.yiJiuYiJiu.vo.YiJiuYiJiuSeckillResult
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

@Service
class ImoutaiService(
    val driver: DriverImoutai
) {

    fun seckillMaotai100(): ImoutaiSeckillResult {
        driver.getAndroidDriver().let { it ->
            TimeUnit.SECONDS.sleep(10L)
            //进入云购
            it.findElement(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"云购\")")
            ).click()
            TimeUnit.SECONDS.sleep(2L)

            //抢购
            try {
                //向上拖动找到maotai100
                it.executeScript(
                    "mobile: dragGesture",
                    ImmutableMap.of("startX", 534, "startY", 983, "endX", 537, "endY", 851)
                )
                TimeUnit.SECONDS.sleep(3L)
                while (true) {
                    LocalDateTime.now().let {statTime ->
                        if (statTime.second >= 59) {
                            //点击进入详情
                            it.executeScript(
                                "mobile: clickGesture",
                                ImmutableMap.of("x", 512, "y", 2097)
                            )
                            while (true) {
                                it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 827, "y", 2301))
                                if (LocalDateTime.now().minute in 2..5) return ImoutaiSeckillResult.fails()
                            }
                        }
                    }
                }
                return ImoutaiSeckillResult.fails()
            }catch (e: Exception) {
                log.warn("抢购发生异常，平台：i茅台，原因：'{}'。", e.message)
                return ImoutaiSeckillResult.fails()
            }finally {
                //退出app
                it.closeApp()
            }
        }

    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ImoutaiService::class.java)
    }
}