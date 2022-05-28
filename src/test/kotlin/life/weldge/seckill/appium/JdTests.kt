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
        var driver = driverJd!!.getDriver()
        driver.get("https://item.m.jd.com/product/100012043978.html?gx=RnFjkTVbbj2PmtQUqId1VOmfpTE6-g&ad_od=share&utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=CopyURL")
//        Thread.sleep(2000)
//        driver.get("【淘宝】https://m.tb.cn/h.fu4Zdhg?tk=4Ok82ljbTy4「飞天53%vol 500ml贵州茅台酒（带杯）白酒酒水」点击链接直接打开")
//        var activity = Activity(
//            taobaoDriver.connect["appPackage"],
//            "com.taobao.android.detail.wrapper.activity.DetailActivity"
//        )
//        driver.startActivity(activity)
    }

}