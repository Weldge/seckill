//package life.weldge.seckill.appium
//
//import life.weldge.seckill.config.DriverSiku
//import life.weldge.seckill.domain.siku.service.SikuService
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import java.util.concurrent.TimeUnit
//
//@SpringBootTest
//class SikuTests {
//
//    @Autowired
//    private val driver: DriverSiku? = null
//
//    @Autowired
//    private val service: SikuService? = null
//
//    @Test
//    fun connect() {
//        var driver = driver!!.getAndroidDriver()
//        TimeUnit.SECONDS.sleep(3L)
//        driver.closeApp()
//    }
//
//    @Test
//    fun seckillMaotai() {
//        service!!.seckillMaotai()
//    }
//
//    @Test
//    fun reserveMaotai() {
//        service!!.reserveMaotai()
//    }
//
//}