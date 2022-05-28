package life.weldge.seckill.config

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.net.URL

@Configuration
@ConfigurationProperties(prefix = "platform.android.jd")
class DriverJd {

    lateinit var connect: Map<String, String>

    fun getDriver(): AndroidDriver<WebElement> {
        return AndroidDriver<WebElement>(URL("http://127.0.0.1:4723/wd/hub"), DesiredCapabilities(connect))
    }
}