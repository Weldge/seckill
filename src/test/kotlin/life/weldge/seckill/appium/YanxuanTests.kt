//package life.weldge.seckill.appium
//
//import life.weldge.seckill.config.DriverYanxuan
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import life.weldge.seckill.domain.yanxuan.service.YanxuanSeckillService
//import java.util.concurrent.TimeUnit
//
//@SpringBootTest
//class YanxuanTests {
//
//    @Autowired
//    private val driver: DriverYanxuan? = null
//    @Autowired
//    private val service: YanxuanSeckillService? = null
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