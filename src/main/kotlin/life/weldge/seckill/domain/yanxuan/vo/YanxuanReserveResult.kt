package life.weldge.seckill.domain.yanxuan.vo

import life.weldge.seckill.domain.BaseReserveResult

class YanxuanReserveResult : BaseReserveResult {

    override val platform: String? = "网易"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}