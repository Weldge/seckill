package life.weldge.seckill.domain.yiJiuYiJiu.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class YiJiuYiJiuSeckillResult : BaseResult {

    override val platform: String? = "1919吃喝"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): YiJiuYiJiuSeckillResult {
            return YiJiuYiJiuSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): YiJiuYiJiuSeckillResult {
            return YiJiuYiJiuSeckillResult(ResultState.FAILS)
        }
    }
}