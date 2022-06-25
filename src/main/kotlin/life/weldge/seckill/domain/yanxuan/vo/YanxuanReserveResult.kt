package life.weldge.seckill.domain.yanxuan.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class YanxuanReserveResult : BaseResult {

    override val platform: String? = "网易"
    override val action: RunAction = RunAction.RESERVE

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): YanxuanReserveResult {
            return YanxuanReserveResult(ResultState.SUCCESS)
        }

        fun fails(): YanxuanReserveResult {
            return YanxuanReserveResult(ResultState.FAILS)
        }
    }
}