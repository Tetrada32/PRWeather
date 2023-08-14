package com.gahov.prweather.domain.common.usecase

/**
 * An interface representing a use case for performing operations and producing results.
 *
 * @param Result The type of result that the use case will produce.
 */
interface UseCase<out Result> where Result : Any {

    /**
     * An open nested class representing parameters for the use case.
     */
    open class Params
}