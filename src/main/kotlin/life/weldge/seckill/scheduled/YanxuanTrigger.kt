package life.weldge.seckill.scheduled

import life.weldge.seckill.domain.yanxuan.service.YanxuanService
import life.weldge.seckill.service.EmailService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@ConditionalOnProperty("platform.android.yanxuan.scheduled.enabled")
class YanxuanTrigger(
    val yanxuanService: YanxuanService,
    val emailService: EmailService,
){

    @Scheduled(cron = "\${platform.android.yanxuan.scheduled.cron.seckill.one}")
    fun seckillOne() {
        yanxuanService.seckillMaotai().let {
            emailService.sendEmail(
                "${LocalDate.now()},网易严选-上午场-茅台抢购通知",
                emailService.handleResultToHtmlContent(listOf(it))
            )
        }
    }

    @Scheduled(cron = "\${platform.android.yanxuan.scheduled.cron.seckill.two}")
    fun seckillTwo() {
        yanxuanService.seckillMaotai().let {
            emailService.sendEmail(
                "${LocalDate.now()},网易严选-上午场-茅台抢购通知",
                emailService.handleResultToHtmlContent(listOf(it))
            )
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(YanxuanTrigger::class.java)
    }
}