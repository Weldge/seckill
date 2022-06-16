package life.weldge.seckill.appium

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import life.weldge.seckill.config.DriverYiJiuYiJiu
import life.weldge.seckill.domain.yiJiuYiJiu.service.YiJiuYiJiuSeckillService

@SpringBootTest
class YiJiuYiJiuTests {

    @Autowired
    private val driverJd: DriverYiJiuYiJiu? = null
    @Autowired
    private val service: YiJiuYiJiuSeckillService? = null

    @Test
    fun connect() {
        var driver = driverJd!!.getAndroidDriver()
        driver.closeApp()
    }

    @Test
    fun seckillMaotai() {
        service!!.seckillMaotai()
    }

    @Test
    fun reserveMaotai() {
        service!!.reserveMaotai()
    }

}