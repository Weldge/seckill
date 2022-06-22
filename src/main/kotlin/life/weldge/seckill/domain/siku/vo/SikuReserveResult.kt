package life.weldge.seckill.domain.siku.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class SikuReserveResult : BaseResult {

    override val platform: String? = "寺库奢侈品"
    override val action: RunAction = RunAction.RESERVE

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): SikuReserveResult {
            return SikuReserveResult(ResultState.SUCCESS)
        }

        fun fails(): SikuReserveResult {
            return SikuReserveResult(ResultState.FAILS)
        }
    }
}