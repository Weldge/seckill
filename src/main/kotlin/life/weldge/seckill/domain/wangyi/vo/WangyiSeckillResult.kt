package life.weldge.seckill.domain.wangyi.vo

import life.weldge.seckill.domain.BaseSeckillResult

class WangyiSeckillResult : BaseSeckillResult {

    override val platform: String? = "网易"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}