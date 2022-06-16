package life.weldge.seckill.domain.suning.vo

import life.weldge.seckill.domain.BaseSeckillResult

class SuningSeckillResult : BaseSeckillResult {

    override val platform: String? = "苏宁"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}