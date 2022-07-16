//package life.weldge.seckill.appium
//
//import life.weldge.seckill.config.DriverImoutai
//import life.weldge.seckill.domain.ResultState
//import life.weldge.seckill.domain.imoutai.service.ImoutaiService
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//
//@SpringBootTest
//class ImoutaiTests {
//
//    @Autowired
//    private val driverImoutai: DriverImoutai? = null
//    @Autowired
//    private val seckillService: ImoutaiService? = null
//
//    @Test
//    fun connect() {
//        driverImoutai!!.getAndroidDriver()
//    }
//
//    @Test
//    fun goMaotai100() {
//        assert(ResultState.SUCCESS == seckillService!!.seckillMaotai100().result)
//    }
//
//}