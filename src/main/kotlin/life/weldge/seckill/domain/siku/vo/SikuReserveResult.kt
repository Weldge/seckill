package life.weldge.seckill.domain.siku.vo

import life.weldge.seckill.domain.BaseReserveResult

class SikuReserveResult : BaseReserveResult {

    override val platform: String? = "寺库奢侈品"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}