package life.weldge.seckill.domain.taobao.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class TaobaoSeckillResult : BaseResult {

    override val platform: String? = "淘宝"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): TaobaoSeckillResult {
            return TaobaoSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): TaobaoSeckillResult {
            return TaobaoSeckillResult(ResultState.FAILS)
        }
    }
}