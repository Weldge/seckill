package life.weldge.seckill.scheduled

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty("platform.android.imoutai.scheduled.enabled")
class ImoutaiTrigger(

){

    @Scheduled(cron = "\${platform.android.imoutai.scheduled.cron}")
    fun execute() {

    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ImoutaiTrigger::class.java)
    }
}