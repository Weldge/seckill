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
        var driver = driverJd!!.getAndroidDriver()
        TimeUnit.SECONDS.sleep(5L)
        driver.closeApp()
    }

    @Test
    fun seckillMaotai() {
        service!!.seckillMaotai()
    }

    @Test
    fun reserveMaotai() {
        assert(ResultState.SUCCESS == service!!.reserveMaotai().result)
    }

}