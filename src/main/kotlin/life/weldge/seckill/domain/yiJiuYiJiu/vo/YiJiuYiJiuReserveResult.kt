package life.weldge.seckill.domain.yiJiuYiJiu.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class YiJiuYiJiuReserveResult : BaseResult {

    override val platform: String? = "1919吃喝"
    override val action: RunAction = RunAction.RESERVE

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): YiJiuYiJiuReserveResult {
            return YiJiuYiJiuReserveResult(ResultState.SUCCESS)
        }

        fun fails(): YiJiuYiJiuReserveResult {
            return YiJiuYiJiuReserveResult(ResultState.FAILS)
        }
    }
}