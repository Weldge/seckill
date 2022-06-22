package life.weldge.seckill.domain.zhenkuaile.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class ZhenkuaileSeckillResult : BaseResult {

    override val platform: String? = "真快乐"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): ZhenkuaileSeckillResult {
            return ZhenkuaileSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): ZhenkuaileSeckillResult {
            return ZhenkuaileSeckillResult(ResultState.FAILS)
        }
    }
}