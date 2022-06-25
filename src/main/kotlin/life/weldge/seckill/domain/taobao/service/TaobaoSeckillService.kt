package life.weldge.seckill.domain.taobao.service

import io.appium.java_client.AppiumBy
import life.weldge.seckill.config.DriverYiJiuYiJiu
import life.weldge.seckill.domain.taobao.vo.TaobaoSeckillResult
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.concurrent.TimeUnit

@Service
class TaobaoSeckillService(
    val driver: DriverYiJiuYiJiu
) {

    fun seckillMaotai(): TaobaoSeckillResult {
        driver.getAndroidDriver().let { //设置全局隐式等待
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            it.get(detail)
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
                return TaobaoSeckillResult.success()
            } catch (e: Exception) {
                log.error("<淘宝>,抢购失败，原因：'{}'.", e.message)
            } finally {
                it.closeApp()
            }
            return TaobaoSeckillResult.fails()
        }
    }

    companion object {

        private const val detail =
            "https://weixin.1919.cn/b2c1919/#/productDetailMall/?id=845475549359947776&vendorType=TYPE_B&tallyUserId=1025994279944151040"

        private val log = LoggerFactory.getLogger(TaobaoSeckillService::class.java)
    }
}