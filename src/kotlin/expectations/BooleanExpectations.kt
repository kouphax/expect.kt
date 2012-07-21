package kotlin.expectations

import kotlin.test.assertTrue

fun Expectation<Boolean>.toBeTrue() : ExpectationChain<Boolean> {
    assertTrue(target)
    return ExpectationChain(this)
}

fun Expectation<Boolean>.toBeFalse() : ExpectationChain<Boolean> {
    assertTrue(!target)
    return ExpectationChain(this)
}

public val Boolean.should : Should<Boolean> get() = Should(this)

fun Should<Boolean>.beTrue() : ShouldChain<Boolean> {
    expector.toBeTrue()
    return ShouldChain(this)
}

fun Should<Boolean>.beFalse() : ShouldChain<Boolean> {
    expector.toBeFalse()
    return ShouldChain(this)
}
