package pl.sensilabs.kotlin.stdlib

inline fun <reified T : Enum<T>> valueOf(value: String?): T? {
    value ?: return null
    return T::class.java.enumConstants.firstOrNull {
        it.name == value
    }
}