package life.weldge.seckill.scheduled

import life.weldge.seckill.domain.taobao.service.TaobaoService
import life.weldge.seckill.service.EmailService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@ConditionalOnProperty("platform.android.taobao.scheduled.enabled")
class TaobaoTrigger(
    val taobaoService: TaobaoService,
    val emailService: EmailService,
){

    @Scheduled(cron = "\${platform.android.taobao.scheduled.cron.seckill}")
    fun seckill() {
        taobaoService.seckillMaotai().let {
            emailService.sendEmail(
                "${LocalDate.now()},淘宝茅台抢购通知",
                emailService.handleResultToHtmlContent(listOf(it))
            )
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(TaobaoTrigger::class.java)
    }
}