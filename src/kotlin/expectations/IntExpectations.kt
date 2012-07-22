package kotlin.expectations

import kotlin.test.assertTrue

fun Expectation<Int>.toBeGreaterOrEqualTo(val value: Int) : ExpectationChain<Int> {
    assertTrue(target >= value)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeGreaterThan(val value: Int) : ExpectationChain<Int> {
    assertTrue(target > value)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeLessOrEqualTo(val value: Int) : ExpectationChain<Int> {
    assertTrue(target <= value)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeLessThan(val value: Int) : ExpectationChain<Int> {
    assertTrue(target < value)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeInRange(val lower: Int, val upper: Int) : ExpectationChain<Int> {
    assertTrue(target >= lower && target <= upper)
    return ExpectationChain(this)
}

fun Expectation<Int>.toBeApproximately(val value: Int, val tolerance: Int) : ExpectationChain<Int> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

public val Int.should : Should<Int> get() = Should(this)


fun Should<Int>.beGreaterOrEqualTo(val value: Int) : ShouldChain<Int> {
    expector.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Int>.beGreaterThan(val value: Int) : ShouldChain<Int> {
    expector.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Int>.beLessOrEqualTo(val value: Int) : ShouldChain<Int> {
    expector.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Int>.beLessThan(val value: Int) : ShouldChain<Int> {
    expector.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Int>.beInRange(val lower: Int, val upper: Int) : ShouldChain<Int> {
    expector.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Int>.beApproximately(val value: Int, val tolerance: Int) : ShouldChain<Int> {
    expector.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}
