package life.weldge.seckill.domain.imoutai.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class ImoutaiSeckillResult : BaseResult {

    override val platform: String? = "i茅台"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): ImoutaiSeckillResult {
            return ImoutaiSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): ImoutaiSeckillResult {
            return ImoutaiSeckillResult(ResultState.FAILS)
        }
    }
}