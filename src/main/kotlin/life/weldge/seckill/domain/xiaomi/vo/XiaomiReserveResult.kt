package life.weldge.seckill.domain.xiaomi.vo

import life.weldge.seckill.domain.BaseReserveResult

class XiaomiReserveResult : BaseReserveResult {

    override val platform: String? = "小米"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}