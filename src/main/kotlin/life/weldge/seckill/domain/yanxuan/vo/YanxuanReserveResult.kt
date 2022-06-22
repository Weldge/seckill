package life.weldge.seckill.domain.yanxuan.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState

class YanxuanReserveResult : BaseResult {

    override val platform: String? = "网易"

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