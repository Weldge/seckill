package life.weldge.seckill.domain.xiaomi.vo

import life.weldge.seckill.domain.BaseSeckillResult

class XiaomiSeckillResult : BaseSeckillResult {

    override val platform: String? = "小米"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}