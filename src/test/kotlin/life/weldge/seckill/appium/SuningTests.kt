//package life.weldge.seckill.appium
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import life.weldge.seckill.config.DriverSuning
//import life.weldge.seckill.domain.suning.service.SuningService
//import java.util.concurrent.TimeUnit
//
//@SpringBootTest
//class SuningTests {
//
//    @Autowired
//    private val driverJd: DriverSuning? = null
//    @Autowired
//    private val service: SuningService? = null
//
//    @Test
//    fun connect() {
//        var driver = driverJd!!.getAndroidDriver()
//        TimeUnit.SECONDS.sleep(5L)
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