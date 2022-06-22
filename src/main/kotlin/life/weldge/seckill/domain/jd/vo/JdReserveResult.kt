package life.weldge.seckill.domain.jd.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class JdReserveResult : BaseResult {

    override val platform: String? = "京东"
    override val action: RunAction = RunAction.RESERVE

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): JdReserveResult {
            return JdReserveResult(ResultState.SUCCESS)
        }

        fun fails(): JdReserveResult {
            return JdReserveResult(ResultState.FAILS)
        }
    }
}