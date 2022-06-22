package life.weldge.seckill.domain.xiaomi.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class XiaomiReserveResult : BaseResult {

    override val platform: String? = "小米"
    override val action: RunAction = RunAction.RESERVE

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): XiaomiReserveResult {
            return XiaomiReserveResult(ResultState.SUCCESS)
        }

        fun fails(): XiaomiReserveResult {
            return XiaomiReserveResult(ResultState.FAILS)
        }
    }
}