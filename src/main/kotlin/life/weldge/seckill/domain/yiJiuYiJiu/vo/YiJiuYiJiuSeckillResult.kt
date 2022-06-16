package life.weldge.seckill.domain.yiJiuYiJiu.vo

import life.weldge.seckill.domain.BaseSeckillResult

class YiJiuYiJiuSeckillResult : BaseSeckillResult {

    override val platform: String? = "1919吃喝"

    constructor() : super()

    constructor(result: String) {
        this.result = result
    }
}