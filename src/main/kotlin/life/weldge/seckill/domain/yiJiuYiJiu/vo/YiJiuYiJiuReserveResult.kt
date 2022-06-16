package life.weldge.seckill.domain.yiJiuYiJiu.vo

import life.weldge.seckill.domain.BaseReserveResult

class YiJiuYiJiuReserveResult : BaseReserveResult {

    override val platform: String? = "1919吃喝"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}