package life.weldge.seckill.domain

open class BaseResult() {

    open val platform: String? = null

    open val action: RunAction? = null

    open var result: ResultState? = null

}