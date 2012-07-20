package kotlin.test

import java.util.regex.Pattern

// cheap hacks for heroes!
public fun describe(val description: String, val block: () -> Unit){}
public fun it(val description: String, val block: () -> Unit){}

// Entry points for expectations
public fun <T> expect(val target: T) : Expectation<T> {
    return Expectation(target)
}

public val <T> T.should : Should<T> get() = Should(this)

public class Expectation<T>(val target: T) {

    // add support for chaining
    public class ExpectationChain<T>(val expectation: Expectation<T>) {
        val and: Expectation<T> get() = expectation
    }

    private val chain = ExpectationChain(this)

    // NULLABLE TYPES
    fun toBeNull() : ExpectationChain<T> {
        asserter.assertNull("", target)
        return chain
    }

    fun toNotBeNull() : ExpectationChain<T> {
        asserter.assertNotNull("", target)
        return chain
    }

    // BOOLEAN TYPE
    fun toBeTrue() : ExpectationChain<T> {
        asserter.assertTrue("", target as Boolean)
        return chain
    }

    fun toBeFalse() : ExpectationChain<T> {
        asserter.assertTrue("", !(target as Boolean))
        return chain
    }

    // STRING TYPE
    fun toBeEmpty() : ExpectationChain<T> {
        asserter.assertTrue("", (target == null) || ((target as String) != ""))
        return chain
    }

    fun toNotBeEmpty() : ExpectationChain<T> {
        asserter.assertTrue("", !(target == null) || ((target as String) != ""))
        return chain
    }

    fun toHaveLength(val length: Int) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).length == length)
        return chain
    }

    fun toBeBlank() : ExpectationChain<T> {
        val value = target as String
        asserter.assertTrue("", (value == null) || (value.trim() != ""))
        return chain
    }

    fun toNotBeBlank() : ExpectationChain<T> {
        val value = target as String
        asserter.assertTrue("", !(value == null) || (value.trim() != ""))
        return chain
    }

    fun toBeEquivalentTo(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).equalsIgnoreCase(comparison))
        return chain
    }

    fun toEndWith(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).endsWith(comparison))
        return chain
    }

    fun toEndWithEquivalent(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).toLowerCase().endsWith(comparison.toLowerCase()))
        return chain
    }

    fun toContain(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).indexOf(comparison) > -1)
        return chain
    }

    fun toContainEquivalent(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).toLowerCase().indexOf(comparison.toLowerCase()) > -1)
        return chain
    }

    fun toNotContain(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).indexOf(comparison) == -1)
        return chain
    }

    fun toNotContainEquivalent(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).toLowerCase().indexOf(comparison.toLowerCase()) == -1)
        return chain
    }

    fun toStartWith(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).startsWith(comparison))
        return chain
    }

    fun toStartWithEquivalent(val comparison: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).toLowerCase().startsWith(comparison.toLowerCase()))
        return chain
    }

    fun toMatch(val regex: String) : ExpectationChain<T> {
        asserter.assertTrue("", (target as String).matches(regex))
        return chain
    }

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
    fun toBe(val test: T) : ExpectationChain<T>{
        asserter.assertEquals("", target, test)
        return chain
    }

    fun toNotBe(val test: T) : ExpectationChain<T>{
        asserter.assertTrue("", target != test)
        return chain
    }
}

// Shim around expectations
public class Should<T>(val target: T){

    // add support for chaining
    public class ShouldChain<T>(val should: Should<T>) {
        val and: Should<T> get() = should
    }

    val expector = Expectation(target)
    private val chain = ShouldChain(this)

    // NULLABLE TYPES
    fun beNull() { expector.toBeNull() }
    fun notBeNull() : ShouldChain<T> { expector.toNotBeNull(); return chain }

    // BOOLEAN TYPE
    fun beTrue() : ShouldChain<T> { expector.toBeTrue(); return chain }
    fun beFalse() : ShouldChain<T> { expector.toBeFalse(); return chain }

    // STRING TYPE
    fun beEmpty() : ShouldChain<T> { expector.toBeEmpty(); return chain }
    fun notBeEmpty() : ShouldChain<T> { expector.toNotBeEmpty(); return chain }
    fun haveLength(val length: Int) : ShouldChain<T> { expector.toHaveLength(length); return chain }
    fun beBlank() : ShouldChain<T> { expector.toBeBlank(); return chain }
    fun notBeBlank() : ShouldChain<T> { expector.toNotBeBlank(); return chain }
    fun beEquivalentTo(val comparison: String) : ShouldChain<T> { expector.toBeEquivalentTo(comparison); return chain }
    fun endWith(val comparison: String) : ShouldChain<T> { expector.toEndWith(comparison); return chain }
    fun endWithEquivalent(val comparison: String) : ShouldChain<T> { expector.toEndWithEquivalent(comparison); return chain }
    fun contain(val comparison: String) : ShouldChain<T> { expector.toContain(comparison); return chain }
    fun containEquivalent(val comparison: String) : ShouldChain<T> { expector.toContainEquivalent(comparison); return chain }
    fun notContain(val comparison: String) : ShouldChain<T> { expector.toNotContain(comparison); return chain }
    fun notContainEquivalent(val comparison: String) : ShouldChain<T> { expector.toNotContainEquivalent(comparison); return chain }
    fun startWith(val comparison: String) : ShouldChain<T> { expector.toStartWith(comparison); return chain }
    fun startWithEquivalent(val comparison: String) : ShouldChain<T> { expector.toStartWithEquivalent(comparison); return chain }
    fun match(val regex: String) : ShouldChain<T> { expector.toMatch(regex); return chain }

}