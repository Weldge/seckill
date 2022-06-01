package life.weldge.seckill.appium

import life.weldge.seckill.config.DriverImoutai
import life.weldge.seckill.domain.imoutai.service.ImoutaiSeckillService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ImoutaiTests {

    @Autowired
    private val driverImoutai: DriverImoutai? = null
    @Autowired
    private val seckillService: ImoutaiSeckillService? = null

    @Test
    fun connect() {
//        capabilities.setCapability("unlockType", "password") //锁屏解除
//        capabilities.setCapability("unlockKey", "9527")
        driverImoutai!!.getAndroidDriver()
    }

    @Test
    fun goMaotai100() {
        seckillService!!.seckillMaotai100()
    }

}