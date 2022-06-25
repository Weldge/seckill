//package life.weldge.seckill.appium
//
//import life.weldge.seckill.config.DriverXiaomi
//import life.weldge.seckill.domain.xiaomi.service.XiaomiService
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import java.util.concurrent.TimeUnit
//
//@SpringBootTest
//class XiaomiTests {
//
//    @Autowired
//    private val driver: DriverXiaomi? = null
//
//    @Autowired
//    private val service: XiaomiService? = null
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