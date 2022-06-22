package life.weldge.seckill.domain.xiaomi.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class XiaomiSeckillResult : BaseResult {

    override val platform: String? = "小米"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): XiaomiSeckillResult {
            return XiaomiSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): XiaomiSeckillResult {
            return XiaomiSeckillResult(ResultState.FAILS)
        }
    }
}