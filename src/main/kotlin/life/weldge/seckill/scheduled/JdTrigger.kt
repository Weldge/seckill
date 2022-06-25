package life.weldge.seckill.scheduled

import life.weldge.seckill.domain.jd.service.JdService
import life.weldge.seckill.service.EmailService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty("platform.android.jd.scheduled.enabled")
class JdTrigger(
    val jdService: JdService,
    val emailService: EmailService,
){

    @Scheduled(cron = "\${platform.android.jd.scheduled.cron.seckill}")
    fun seckill() {
        jdService.seckillMaotai()
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(JdTrigger::class.java)
    }
}