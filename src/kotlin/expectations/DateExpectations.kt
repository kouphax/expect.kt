package kotlin.expectations

import java.util.Date
import kotlin.test.assertTrue

fun Expectation<Date>.toBeAfter(val date: Date) : ExpectationChain<Date> {
    assertTrue(target.after(date))
    return ExpectationChain(this)
}

fun Expectation<Date>.toBeBefore(val date: Date) : ExpectationChain<Date> {
    assertTrue(target.before(date))
    return ExpectationChain(this)
}

public val Date.should : Should<Date> get() = Should(this)

fun Should<Date>.beAfter(val date: Date) : ShouldChain<Date> {
    expector.toBeAfter(date)
    return ShouldChain(this)
}

fun Should<Date>.beBefore(val date: Date) : ShouldChain<Date> {
    expector.toBeBefore(date)
    return ShouldChain(this)
}