package pl.sensilabs.kotlin.stdlib

/**
 * see also https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.system/measure-time-millis.html
 */
inline fun <T> measureTimeMillis(
        executionTimeHandler: (Long) -> Unit,
        function: () -> T
): T {

    val startTime = System.currentTimeMillis()
    val result: T = function.invoke()
    executionTimeHandler.invoke(System.currentTimeMillis() - startTime)

    return result
}
