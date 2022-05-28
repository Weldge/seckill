package life.weldge.seckill.appium

import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.Test
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import org.openqa.selenium.WebElement


class ImoutaiTests {

    @Test
    fun connect() {
        val capabilities = DesiredCapabilities()
        capabilities.setCapability("platformName", "Android")//操作系统
        capabilities.setCapability("platformVersion", "11")//系统版本
        capabilities.setCapability("deviceName", "8e156534")//设备名称
        capabilities.setCapability("appPackage", "com.moutai.mall")//包名
        capabilities.setCapability("appActivity", "com.moutai.mall.module.splash.SplashActivity")//入口
        capabilities.setCapability("noReset", true)

//        capabilities.setCapability("unlockType", "password") //锁屏解除
//        capabilities.setCapability("unlockKey", "9527")

        AndroidDriver<WebElement>(URL("http://127.0.0.1:4723/wd/hub"), capabilities)
    }
}