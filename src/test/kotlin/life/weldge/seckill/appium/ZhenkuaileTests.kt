//package life.weldge.seckill.appium
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import life.weldge.seckill.config.DriverZhenkuaile
//import life.weldge.seckill.domain.zhenkuaile.service.ZhenkuaileSeckillService
//
//@SpringBootTest
//class ZhenkuaileTests {
//
//    @Autowired
//    private val driver: DriverZhenkuaile? = null
//    @Autowired
//    private val service: ZhenkuaileSeckillService? = null
//
//    @Test
//    fun connect() {
//        var driver = driver!!.getAndroidDriver()
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