package life.weldge.seckill.domain.taobao.service

import com.google.common.collect.ImmutableMap
import life.weldge.seckill.config.DriverTaobao
import life.weldge.seckill.domain.taobao.vo.TaobaoSeckillResult
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class TaobaoService(
    val driver: DriverTaobao
) {

    fun seckillMaotai(): TaobaoSeckillResult {
        driver.getAndroidDriver().let {
            //线程睡眠等待首页动画结束
            TimeUnit.SECONDS.sleep(5L)
            it.get(detail)
            //等待详情页加载完毕
            TimeUnit.SECONDS.sleep(2L)
            try {
                //持续点击-立即购买
                while (true) {
                    it.executeScript("mobile: clickGesture", ImmutableMap.of("x", 884, "y", 2294))
                }
                return TaobaoSeckillResult.fails()
            } catch (e: Exception) {
                log.warn("抢购发生异常，平台：淘宝，原因：'{}'。", e.message)
                return TaobaoSeckillResult.fails()
            } finally {
                it.closeApp()
            }
        }
    }

    companion object {

        private const val detail = "https://m.tb.cn/h.fESqESb?tk=5O8J2oCbI470"
        private val log = LoggerFactory.getLogger(TaobaoService::class.java)
    }
}