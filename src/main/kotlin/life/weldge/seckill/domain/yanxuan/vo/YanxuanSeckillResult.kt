package life.weldge.seckill.domain.yanxuan.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class YanxuanSeckillResult : BaseResult {

    override val platform: String? = "网易"
    override val action: RunAction = RunAction.SECKILL

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): YanxuanSeckillResult {
            return YanxuanSeckillResult(ResultState.SUCCESS)
        }

        fun fails(): YanxuanSeckillResult {
            return YanxuanSeckillResult(ResultState.FAILS)
        }
    }
}