package life.weldge.seckill.appium

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import life.weldge.seckill.scheduled.ReserveTrigger

@SpringBootTest
class JdTests {

    @Autowired
    private val reserveTrigger: ReserveTrigger? = null

    @Test
    fun one() {
        reserveTrigger!!.reserveOne()
    }

    @Test
    fun two() {
        reserveTrigger!!.reserveTwo()
    }

}