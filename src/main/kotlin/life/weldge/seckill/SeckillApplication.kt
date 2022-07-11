package life.weldge.seckill

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SeckillApplication

fun main(args: Array<String>) {
	runApplication<SeckillApplication>(*args)
}
