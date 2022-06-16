package life.weldge.seckill.domain.taobao.vo

import life.weldge.seckill.domain.BaseSeckillResult

class TaobaoSeckillResult : BaseSeckillResult {

    override val platform: String? = "淘宝"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}