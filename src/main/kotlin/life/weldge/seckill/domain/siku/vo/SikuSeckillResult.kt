package life.weldge.seckill.domain.siku.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class SikuSeckillResult : BaseResult {

    override val platform: String? = "寺库奢侈品"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): SikuSeckillResult {
            return SikuSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): SikuSeckillResult {
            return SikuSeckillResult(ResultState.FAILS)
        }
    }
}