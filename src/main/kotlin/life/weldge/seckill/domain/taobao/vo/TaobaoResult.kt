package life.weldge.seckill.domain.taobao.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class TaobaoResult : BaseResult {

    override val platform: String? = "淘宝"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): TaobaoResult {
            return TaobaoResult(ResultState.SUCCESS)
        }

        fun fails(): TaobaoResult {
            return TaobaoResult(ResultState.FAILS)
        }
    }
}