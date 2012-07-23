package kotlin.expectations

import java.util.Date
import kotlin.test.assertTrue
import org.joda.time.DateTime
import org.joda.time.LocalDate

fun Expectation<Date>.toBeAfter(val date: Date) : ExpectationChain<Date> {
    assertTrue(target.after(date))
    return ExpectationChain(this)
}

fun Expectation<Date>.toBeBefore(val date: Date) : ExpectationChain<Date> {
    assertTrue(target.before(date))
    return ExpectationChain(this)
}

fun Expectation<Date>.toBeOnOrAfter(val date: Date) : ExpectationChain<Date> {
    val targetJoda = DateTime(target).toLocalDate()
    val dateJoda = DateTime(date).toLocalDate()
    expect(targetJoda?.compareTo(dateJoda) as Int).toBeInRange(0,1)
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

fun Should<Date>.beOnOrAfter(val date: Date) : ShouldChain<Date> {
    expector.toBeOnOrAfter(date)
    return ShouldChain(this)
}