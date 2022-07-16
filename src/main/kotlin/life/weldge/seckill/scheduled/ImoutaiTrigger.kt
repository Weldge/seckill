package life.weldge.seckill.scheduled

import life.weldge.seckill.domain.imoutai.service.ImoutaiService
import life.weldge.seckill.service.EmailService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@ConditionalOnProperty("platform.android.imoutai.scheduled.enabled")
class ImoutaiTrigger(
    val imoutaiService: ImoutaiService,
    val emailService: EmailService
){

    @Scheduled(cron = "\${platform.android.imoutai.scheduled.cron.seckill.one}")
    fun one() {
        imoutaiService.seckillMaotai100().let {
            emailService.sendEmail(
                "${LocalDate.now()},i茅台抢购通知",
                emailService.handleResultToHtmlContent(listOf(it))
            )
        }
    }

    @Scheduled(cron = "\${platform.android.imoutai.scheduled.cron.seckill.two}")
    fun two() {
        imoutaiService.seckillMaotai100().let {
            emailService.sendEmail(
                "${LocalDate.now()},i茅台抢购通知",
                emailService.handleResultToHtmlContent(listOf(it))
            )
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ImoutaiTrigger::class.java)
    }
}