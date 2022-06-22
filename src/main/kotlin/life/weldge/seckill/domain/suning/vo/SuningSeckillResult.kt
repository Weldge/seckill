package life.weldge.seckill.domain.suning.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class SuningSeckillResult : BaseResult {

    override val platform: String? = "苏宁"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): SuningSeckillResult {
            return SuningSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): SuningSeckillResult {
            return SuningSeckillResult(ResultState.FAILS)
        }
    }
}