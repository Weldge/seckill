package life.weldge.seckill.scheduled

import life.weldge.seckill.domain.yiJiuYiJiu.service.YiJiuYiJiuService
import life.weldge.seckill.service.EmailService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@ConditionalOnProperty("platform.android.yijiu.scheduled.enabled")
class YiJiuYiJiuTrigger(
    val yiJiuYiJiuService: YiJiuYiJiuService,
    val emailService: EmailService,
){

    @Scheduled(cron = "\${platform.android.yijiu.scheduled.cron.seckill.one}")
    fun seckillOne() {
        yiJiuYiJiuService.seckillMaotai().let {
            emailService.sendEmail(
                "${LocalDate.now()},1919吃喝-上午场-茅台抢购通知",
                emailService.handleResultToHtmlContent(listOf(it))
            )
        }
    }

    @Scheduled(cron = "\${platform.android.yijiu.scheduled.cron.seckill.two}")
    fun seckillTwo() {
        yiJiuYiJiuService.seckillMaotai().let {
            emailService.sendEmail(
                "${LocalDate.now()},1919吃喝-上午场-茅台抢购通知",
                emailService.handleResultToHtmlContent(listOf(it))
            )
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(YiJiuYiJiuTrigger::class.java)
    }
}