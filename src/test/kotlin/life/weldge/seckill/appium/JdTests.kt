package life.weldge.seckill.appium

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import life.weldge.seckill.config.DriverJd
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.jd.service.JdService

@SpringBootTest
class JdTests {

    @Autowired
    private val driverJd: DriverJd? = null

    @Autowired
    private val service: JdService? = null

    @Test
    fun connect() {
        var driver = driverJd!!.getAndroidDriver()
    }

    @Test
    fun seckillMaotai() {

        assert(ResultState.SUCCESS == service!!.seckillMaotai().result)
    }

    @Test
    fun reserveMaotai() {
        assert(ResultState.SUCCESS == service!!.reserveMaotai().result)
    }

}