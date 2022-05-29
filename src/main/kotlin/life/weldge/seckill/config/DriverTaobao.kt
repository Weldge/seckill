package life.weldge.seckill.config

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.net.URL

@Configuration
@ConfigurationProperties(prefix = "platform.android.taobao")
class DriverTaobao {

    lateinit var connect: Map<String, String>

    fun getAndroidDriver(): AndroidDriver {
        return AndroidDriver(URL("http://127.0.0.1:4723"), UiAutomator2Options(connect))
    }
}