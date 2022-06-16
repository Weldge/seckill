package life.weldge.seckill.domain.wangyi.vo

import life.weldge.seckill.domain.BaseReserveResult

class WangyiReserveResult : BaseReserveResult {

    override val platform: String? = "网易"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}