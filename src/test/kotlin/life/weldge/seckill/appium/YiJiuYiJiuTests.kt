package life.weldge.seckill.appium

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import life.weldge.seckill.config.DriverYiJiuYiJiu
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.yiJiuYiJiu.service.YiJiuYiJiuService
import java.util.concurrent.TimeUnit

@SpringBootTest
class YiJiuYiJiuTests {

    @Autowired
    private val driverJd: DriverYiJiuYiJiu? = null

    @Autowired
    private val service: YiJiuYiJiuService? = null

    @Test
    fun connect() {
        driverJd!!.getAndroidDriver().let {
            TimeUnit.SECONDS.sleep(5L)
            it.closeApp()
        }
    }

    @Test
    fun seckillMaotai() {
        assert(ResultState.SUCCESS == service!!.seckillMaotai().result)
    }

    @Test
    fun reserveMaotai() {
        assert(ResultState.SUCCESS == service!!.reserveMaotai().result)
    }

}