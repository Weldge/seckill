package life.weldge.seckill.domain.zhenkuaile.vo

import life.weldge.seckill.domain.BaseResult
import life.weldge.seckill.domain.ResultState
import life.weldge.seckill.domain.RunAction

class ZhenkuaileReserveResult : BaseResult {

    override val platform: String? = "真快乐"
    override val action: RunAction = RunAction.RESERVE

    constructor() : super()

    constructor(result: ResultState) {
        this.result = result
    }

    companion object {
        fun success(): ZhenkuaileReserveResult {
            return ZhenkuaileReserveResult(ResultState.SUCCESS)
        }

        fun fails(): ZhenkuaileReserveResult {
            return ZhenkuaileReserveResult(ResultState.FAILS)
        }
    }
}