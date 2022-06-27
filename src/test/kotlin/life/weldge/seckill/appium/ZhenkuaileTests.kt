//package life.weldge.seckill.appium
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import life.weldge.seckill.config.DriverZhenkuaile
//import life.weldge.seckill.domain.ResultState
//import life.weldge.seckill.domain.zhenkuaile.service.ZhenkuaileService
//import java.util.concurrent.TimeUnit
//
//@SpringBootTest
//class ZhenkuaileTests {
//
//    @Autowired
//    private val driver: DriverZhenkuaile? = null
//
//    @Autowired
//    private val service: ZhenkuaileService? = null
//
//    @Test
//    fun connect() {
//        driver!!.getAndroidDriver().let {
//            TimeUnit.SECONDS.sleep(3L)
//            it.closeApp()
//        }
//    }
//
//    @Test
//    fun seckillMaotai() {
//        assert(ResultState.SUCCESS == service!!.seckillMaotai().result)
//    }
//
//    @Test
//    fun reserveMaotai() {
//        assert(ResultState.SUCCESS == service!!.reserveMaotai().result)
//    }
//
//}