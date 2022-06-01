package life.weldge.seckill.appium

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import life.weldge.seckill.config.DriverTaobao
import java.time.Duration
import java.util.concurrent.TimeUnit

@SpringBootTest
class TaobaoTests {

    @Autowired
    private val driverTaobao: DriverTaobao? = null

    @Test
    fun connect() {
        var driver = driverTaobao!!.getAndroidDriver()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
//        Thread.sleep(2000)
//        driver.get("【淘宝】https://m.tb.cn/h.fu4Zdhg?tk=4Ok82ljbTy4「飞天53%vol 500ml贵州茅台酒（带杯）白酒酒水」点击链接直接打开")
//        var activity = Activity(
//            taobaoDriver.connect["appPackage"],
//            "com.taobao.android.detail.wrapper.activity.DetailActivity"
//        )
//        driver.startActivity(activity)
    }

}