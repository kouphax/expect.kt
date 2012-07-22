package kotlin.expectations

import kotlin.test.assertTrue

fun Expectation<Double>.toBeGreaterOrEqualTo(val value: Double) : ExpectationChain<Double> {
    assertTrue(target >= value)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeGreaterThan(val value: Double) : ExpectationChain<Double> {
    assertTrue(target > value)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeLessOrEqualTo(val value: Double) : ExpectationChain<Double> {
    assertTrue(target <= value)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeLessThan(val value: Double) : ExpectationChain<Double> {
    assertTrue(target < value)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeInRange(val lower: Double, val upper: Double) : ExpectationChain<Double> {
    assertTrue(target >= lower && target <= upper)
    return ExpectationChain(this)
}

fun Expectation<Double>.toBeApproximately(val value: Double, val tolerance: Double) : ExpectationChain<Double> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

public val Double.should : Should<Double> get() = Should(this)

fun Should<Double>.beGreaterOrEqualTo(val value: Double) : ShouldChain<Double> {
    expector.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Double>.beGreaterThan(val value: Double) : ShouldChain<Double> {
    expector.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Double>.beLessOrEqualTo(val value: Double) : ShouldChain<Double> {
    expector.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Double>.beLessThan(val value: Double) : ShouldChain<Double> {
    expector.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Double>.beInRange(val lower: Double, val upper: Double) : ShouldChain<Double> {
    expector.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Double>.beApproximately(val value: Double, val tolerance: Double) : ShouldChain<Double> {
    expector.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}
