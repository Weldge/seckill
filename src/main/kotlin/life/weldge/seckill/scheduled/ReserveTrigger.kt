package life.weldge.seckill.scheduled

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.jd.service.JdService
import life.weldge.seckill.domain.siku.service.SikuService
import life.weldge.seckill.domain.suning.service.SuningService
import life.weldge.seckill.domain.xiaomi.service.XiaomiService
import life.weldge.seckill.domain.yanxuan.service.YanxuanService
import life.weldge.seckill.domain.yiJiuYiJiu.service.YiJiuYiJiuService
import life.weldge.seckill.domain.zhenkuaile.service.ZhenkuaileService
import life.weldge.seckill.service.EmailService
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@ConditionalOnProperty("scheduled.reserve.enabled")
class ReserveTrigger(
    val emailService: EmailService,
    val yanxuanService: YanxuanService,
    val jdService: JdService,
    val yiJiuYiJiuService: YiJiuYiJiuService,
    val zhenkuaileService: ZhenkuaileService,
    val sikuService: SikuService,
    val suningService: SuningService,
    val xiaomiService: XiaomiService,
) {

    @Scheduled(cron = "\${scheduled.reserve.cron.one}")
    fun reserveOne() {
        var result = mutableListOf<BaseResult>()
        yanxuanService.reserveMaotai().let {
            result.add(it)
        }
        jdService.reserveMaotai().let {
            result.add(it)
        }
        yiJiuYiJiuService.reserveMaotai().let {
            result.add(it)
        }
        zhenkuaileService.reserveMaotai().let {
            result.add(it)
        }
        emailService.sendEmail(
            "${LocalDate.now()},上午场预约结果通知",
            emailService.handleResultToHtmlContent(result)
        )
    }

    @Scheduled(cron = "\${scheduled.reserve.cron.two}")
    fun reserveTwo() {
        var result = mutableListOf<BaseResult>()
        suningService.reserveMaotai().let {
            result.add(it)
        }
        sikuService.reserveMaotai().let {
            result.add(it)
        }
        xiaomiService.reserveMaotai().let {
            result.add(it)
        }
        yiJiuYiJiuService.reserveMaotai().let {
            result.add(it)
        }
        yanxuanService.reserveMaotai().let {
            result.add(it)
        }
        emailService.sendEmail(
            "${LocalDate.now()},下午场预约结果通知",
            emailService.handleResultToHtmlContent(result)
        )
    }
}