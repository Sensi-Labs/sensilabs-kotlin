package pl.sensilabs.kotlin.stdlib

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test
import pl.sensilabs.kotlin.stdlib.EnumsKtTest.NonEmptyEnumExample.EXISTING_VALUE

internal class EnumsKtTest {

    enum class EmptyEnumExample

    enum class NonEmptyEnumExample {

        EXISTING_VALUE

    }

    @Test
    fun `empty enum should safely return null when non existing value is provided`() {
        assertThat(valueOf<EmptyEnumExample>("EXISTING_VALUE")).isNull()
    }

    @Test
    fun `empty enum should safely return null when empty value is provided`() {
        assertThat(valueOf<EmptyEnumExample>("")).isNull()
    }

    @Test
    fun `empty enum should safely return null when null value is provided`() {
        assertThat(valueOf<EmptyEnumExample>(null)).isNull()
    }

    @Test
    fun `non empty enum should return existing constant when existing value is provided`() {
        assertThat(valueOf<NonEmptyEnumExample>("EXISTING_VALUE")).isEqualTo(EXISTING_VALUE)
    }

    @Test
    fun `non empty enum should safely return null when non existing value is provided`() {
        assertThat(valueOf<NonEmptyEnumExample>("NON_EXISTING_VALUE")).isNull()
    }

    @Test
    fun `non empty enum should safely return null when empty value is provided`() {
        assertThat(valueOf<NonEmptyEnumExample>("")).isNull()
    }

    @Test
    fun `non empty enum should safely return null when null value is provided`() {
        assertThat(valueOf<NonEmptyEnumExample>(null)).isNull()
    }
}