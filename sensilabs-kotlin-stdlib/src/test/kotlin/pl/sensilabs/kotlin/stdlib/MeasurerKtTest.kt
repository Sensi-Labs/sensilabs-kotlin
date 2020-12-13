package pl.sensilabs.kotlin.stdlib

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.matches
import org.junit.jupiter.api.Test
import java.util.*

internal class MeasurerKtTest {

    private val stack = Stack<String>()

    private val executionTimeHandler: (Long) -> Unit = {
        println("$it ms")
        stack.push("Execution time handler wants to report execution time as $it ms")
    }

    @Test
    fun `will measure time and execution time handler will use it internally`() {
        val result = measureTimeMillis(executionTimeHandler) {
            stack.push("This function takes long")
            "The result"
        }
        stack.push(result)
        assertThat(stack.pop()).isEqualTo("The result")
        assertThat(stack.pop()).matches(Regex("Execution time handler wants to report execution time as \\d ms"))
        assertThat(stack.pop()).isEqualTo("This function takes long")
    }

}