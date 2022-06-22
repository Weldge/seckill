package life.weldge.seckill.domain.suning.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class SuningReserveResult : BaseResult {

    override val platform: String? = "苏宁"
    override val action: RunAction = RunAction.RESERVE

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): SuningReserveResult {
            return SuningReserveResult(ResultState.SUCCESS)
        }

        fun fails(): SuningReserveResult {
            return SuningReserveResult(ResultState.FAILS)
        }
    }

}