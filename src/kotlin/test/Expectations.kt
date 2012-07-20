package kotlin.test

// cheap hacks for heroes!
public fun describe(val description: String, val block: () -> Unit){
}

public fun it(val description: String, val block: () -> Unit){
}

public fun <T> expect(val target: T) : Expectation<T> {
    return Expectation(target)
}

public val <T> T.should : Should<T> get() = Should(this)

public class Expectation<T>(val target: T) {

    // NULLABLE TYPES
    fun toBeNull() {
        asserter.assertNull("", target)
    }

    fun toNotBeNull() {
        asserter.assertNotNull("", target)
    }

    // BOOLEAN TYPE
    fun toBeTrue() {
        asserter.assertTrue("", target as Boolean)
    }

    fun toBeFalse() {
        asserter.assertTrue("", !(target as Boolean))
    }

    // STRING TYPE
    fun toBeEmpty() {
        asserter.assertTrue("", (target == null) || ((target as String) != ""))
    }

    fun toNotBeEmpty() {
        asserter.assertTrue("", !(target == null) || ((target as String) != ""))
    }

    fun toHaveLength(val length: Int) {
        asserter.assertTrue("", (target as String).length == length)
    }

    fun toBeBlank() {
        val value = target as String
        asserter.assertTrue("", (value == null) || (value.trim() != ""))
    }

    fun toNotBeBlank() {
        val value = target as String
        asserter.assertTrue("", !(value == null) || (value.trim() != ""))
    }

    // toBeEquivalentTo - case
    // toEndWith
    // toEndWithEquivalent - case
    // toContain
    // toNotContain
    // toContainEquivalent - case
    // toNotContainEquivalent - case
    // toStartWith
    // toStartWithEquivalent - case
    // toMatch - regex
    // toMatchEquivalentOf - case

    // NUMERIC TYPES

    // toBeGreaterOrEqualTo
    // toBeGreaterThan
    // toBeLessOrEqualTo
    // toBeLessThan
    // toBePositive
    // toBeInRange
    // toBeApproximately

    // DATES, TIMES AND TIMESTAMPS

    // toBeAfter
    // toBeBefore
    // toBeOnOrAfter
    // toHaveDay
    // toHaveMonth
    // toHaveYear
    // toHaveHour
    // toHaveMinute
    // toHaveSecond
    // toBeLessThan().before()
    // toBeWithin(timespan).after()
    // toBeMoreThan(timespan)...
    // toBeAtLeast(timespan)...
    // toBeExactly

    // COLLECTIONS

    // toNotBeEmpty
    // toHaveCount
    // toContainInOrder
    // toHaveSameCount
    // toBeSubsetOf
    // toNotBeSubsetOf
    // toHaveElementAt
    // toNotHaveElementAt
    // toContain
    // toContain - lambda
    // toNotContain - lambda
    // toOnlyContain - lambda
    // toNotContainNulls
    // toBeEmpty

    // DICTIONARIES

    // toEqual
    // toNotEqual
    // toBeEmpty
    // toNotBeEmpty
    // toContainKey
    // toNotContainKey
    // toContainValue
    // toNotContainValue
    // toHaveCount
    // toContain - keyvaluepair

    // EXCEPTIONS

    // toThrow
    // toThrow(type)
    // toNotThrow
    // toNotThrow(type)

    // GENERIC BLAH
    fun toBe(val test: T) {
        asserter.assertEquals("", target, test)
    }

    fun toNotBe(val test: T) {
        asserter.assertEquals("", target, test)
        asserter.fail("")
    }
}

// Shim around expectations
public class Should<T>(val target: T){

    val expector = Expectation(target)

    // NULLABLE TYPES
    fun toBeNull() { expector.toBeNull() }
    fun toNotBeNull() { expector.toNotBeNull() }

    // BOOLEAN TYPE
    fun toBeTrue() { expector.toBeTrue() }
    fun toBeFalse() { expector.toBeFalse() }

    // STRING TYPE
    fun toBeEmpty() { expector.toBeEmpty() }
    fun toNotBeEmpty() { expector.toNotBeEmpty() }
    fun toHaveLength(val length: Int) { expector.toHaveLength(length) }
    fun toBeBlank() { expector.toBeBlank() }
    fun toNotBeBlank() { expector.toNotBeBlank() }
}