package life.weldge.seckill.appium

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import life.weldge.seckill.config.DriverJd

@SpringBootTest
class JdTests {

    @Autowired
    private val driverJd: DriverJd? = null

    @Test
    fun connect() {
        var driver = driverJd!!.getAndroidDriver()
//        driver.get("https://item.m.jd.com/product/100012043978.html?gx=RnFjkTVbbj2PmtQUqId1VOmfpTE6-g&ad_od=share&utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=CopyURL")

    }

}