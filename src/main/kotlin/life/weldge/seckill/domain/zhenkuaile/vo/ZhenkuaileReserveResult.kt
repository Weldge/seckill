package life.weldge.seckill.domain.zhenkuaile.vo

import life.weldge.seckill.domain.BaseReserveResult

class ZhenkuaileReserveResult : BaseReserveResult {

    override val platform: String? = "真快乐"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}