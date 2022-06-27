package life.weldge.seckill.service

import life.weldge.seckill.domain.BaseResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component

@Component
class EmailService(
    private val javaMailSender: JavaMailSender,
    @Value("\${spring.mail.username}")
    private val from: String,
) {

    fun sendEmail(subject: String, content: String) {
        val simpleMailMessage = SimpleMailMessage()
        simpleMailMessage.setFrom(from)
        simpleMailMessage.setTo(to)
        simpleMailMessage.setSubject(subject)
        simpleMailMessage.setText(content)
        try {
            javaMailSender.send(simpleMailMessage)
            log.info("send email success, from: '{}', to: '{}' .", from, to)
        } catch (e: Exception) {
            log.error("send email error, message: {}.", e.message)
        }
    }

    fun handleResultToHtmlContent(result: List<BaseResult>): String {
        var html = "<html>\n<body>\n"
        result.forEach {
            html = "$html <p>${it.platform}, ${it.action!!.description}${it.result!!.description}</p>\n"
        }
        html = "$html</body>\n</html>\n"
        return html
    }

    companion object {

        private const val to: String = "546962808@qq.com"
        private val log: Logger = LoggerFactory.getLogger(EmailService::class.java)
    }

}