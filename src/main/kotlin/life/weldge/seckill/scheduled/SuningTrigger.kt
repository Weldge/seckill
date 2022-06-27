package life.weldge.seckill.scheduled

import life.weldge.seckill.domain.suning.service.SuningService
import life.weldge.seckill.service.EmailService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@ConditionalOnProperty("platform.android.suning.scheduled.enabled")
class SuningTrigger(
    val suningService: SuningService,
    val emailService: EmailService,
){

    @Scheduled(cron = "\${platform.android.suning.scheduled.cron.seckill}")
    fun seckill() {
        suningService.seckillMaotai().let {
            emailService.sendEmail(
                "${LocalDate.now()},苏宁茅台抢购通知",
                emailService.handleResultToHtmlContent(listOf(it))
            )
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(SuningTrigger::class.java)
    }
}