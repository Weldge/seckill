//package life.weldge.seckill.appium
//
//import life.weldge.seckill.config.DriverYanxuan
//import life.weldge.seckill.domain.ResultState
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import life.weldge.seckill.domain.yanxuan.service.YanxuanService
//import java.util.concurrent.TimeUnit
//
//@SpringBootTest
//class YanxuanTests {
//
//    @Autowired
//    private val driver: DriverYanxuan? = null
//
//    @Autowired
//    private val service: YanxuanService? = null
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