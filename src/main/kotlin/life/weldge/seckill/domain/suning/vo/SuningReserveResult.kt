package life.weldge.seckill.domain.suning.vo

import life.weldge.seckill.domain.BaseReserveResult

class SuningReserveResult : BaseReserveResult {

    override val platform: String? = "苏宁"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}