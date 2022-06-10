package life.weldge.seckill.domain.jd.vo

import life.weldge.seckill.domain.BaseReserveResult

class JdReserveResult : BaseReserveResult {

    override val platform: String? = "京东"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}