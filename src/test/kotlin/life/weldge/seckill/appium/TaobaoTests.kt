//package life.weldge.seckill.appium
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import life.weldge.seckill.config.DriverTaobao
//import life.weldge.seckill.domain.ResultState
//import life.weldge.seckill.domain.taobao.service.TaobaoService
//import java.util.concurrent.TimeUnit
//
//@SpringBootTest
//class TaobaoTests {
//
//    @Autowired
//    private val driverTaobao: DriverTaobao? = null
//
//    @Autowired
//    private val service: TaobaoService? = null
//
//    @Test
//    fun connect() {
//        driverTaobao!!.getAndroidDriver().let {
//            TimeUnit.SECONDS.sleep(3L)
//            it.closeApp()
//        }
//
//    }
//
//    @Test
//    fun seckillMaotai() {
//        assert(ResultState.SUCCESS == service!!.seckillMaotai().result)
//    }
//
//}