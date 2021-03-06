package life.weldge.seckill.domain.jd.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class JdSeckillResult : BaseResult {

    override val platform: String? = "京东"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): JdSeckillResult {
            return JdSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): JdSeckillResult {
            return JdSeckillResult(ResultState.FAILS)
        }
    }
}