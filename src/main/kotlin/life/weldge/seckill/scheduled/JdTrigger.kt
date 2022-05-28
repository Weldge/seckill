package life.weldge.seckill.scheduled

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty("platform.android.jd.scheduled.enabled")
class JdTrigger(

){

    @Scheduled(cron = "\${platform.android.jd.scheduled.cron}")
    fun execute() {

    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(JdTrigger::class.java)
    }
}