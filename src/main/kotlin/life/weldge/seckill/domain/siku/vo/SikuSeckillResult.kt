package life.weldge.seckill.domain.siku.vo

import life.weldge.seckill.domain.BaseSeckillResult

class SikuSeckillResult : BaseSeckillResult {

    override val platform: String? = "寺库奢侈品"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}