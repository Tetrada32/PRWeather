package com.gahov.prweather.domain.common.converter

/**
 * An abstract base class for mapping objects from one type to another.
 *
 * @param T The source type to map from.
 * @param E The destination type to map to.
 */
abstract class Mapper<in T, out E> {

    /**
     * Maps an object from the source type to the destination type.
     *
     * @param from The object of type [T] to be mapped.
     * @return An object of type [E] representing the mapped result.
     */
    abstract fun map(from: T): E

    /**
     * Maps a list of objects from the source type to a list of objects of the destination type.
     *
     * @param from The list of objects of type [T] to be mapped.
     * @return A list of objects of type [E] representing the mapped results.
     */
    open fun map(from: List<T>) = from.map { map(it) }

}