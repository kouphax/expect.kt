package kotlin.expectations

import kotlin.test.assertTrue

fun Expectation<String>.toBeEmpty() : ExpectationChain<String> {
    assertTrue((target == null) || ((target as String) != ""))
    return ExpectationChain(this)
}

fun Expectation<String>.toNotBeEmpty() : ExpectationChain<String> {
    assertTrue(!(target == null) || ((target as String) != ""))
    return ExpectationChain(this)
}

fun Expectation<String>.toHaveLength(val length: Int) : ExpectationChain<String> {
    assertTrue((target as String).length == length)
    return ExpectationChain(this)
}

fun Expectation<String>.toBeBlank() : ExpectationChain<String> {
    val value = target as String
    assertTrue((value == null) || (value.trim() != ""))
    return ExpectationChain(this)
}

fun Expectation<String>.toNotBeBlank() : ExpectationChain<String> {
    val value = target as String
    assertTrue(!(value == null) || (value.trim() != ""))
    return ExpectationChain(this)
}

fun Expectation<String>.toBeEquivalentTo(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).equalsIgnoreCase(comparison))
    return ExpectationChain(this)
}

fun Expectation<String>.toEndWith(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).endsWith(comparison))
    return ExpectationChain(this)
}

fun Expectation<String>.toEndWithEquivalent(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).toLowerCase().endsWith(comparison.toLowerCase()))
    return ExpectationChain(this)
}

fun Expectation<String>.toContain(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).indexOf(comparison) > -1)
    return ExpectationChain(this)
}

fun Expectation<String>.toContainEquivalent(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).toLowerCase().indexOf(comparison.toLowerCase()) > -1)
    return ExpectationChain(this)
}

fun Expectation<String>.toNotContain(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).indexOf(comparison) == -1)
    return ExpectationChain(this)
}

fun Expectation<String>.toNotContainEquivalent(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).toLowerCase().indexOf(comparison.toLowerCase()) == -1)
    return ExpectationChain(this)
}

fun Expectation<String>.toStartWith(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).startsWith(comparison))
    return ExpectationChain(this)
}

fun Expectation<String>.toStartWithEquivalent(val comparison: String) : ExpectationChain<String> {
    assertTrue((target as String).toLowerCase().startsWith(comparison.toLowerCase()))
    return ExpectationChain(this)
}

fun Expectation<String>.toMatch(val regex: String) : ExpectationChain<String> {
    assertTrue((target as String).matches(regex))
    return ExpectationChain(this)
}

public val String.should : Should<String> get() = Should(this)

fun Should<String>.beEmpty() : ShouldChain<String> { 
	expector.toBeEmpty()
	return ShouldChain(this) 
}
fun Should<String>.notBeEmpty() : ShouldChain<String> { 
	expector.toNotBeEmpty()
	return ShouldChain(this) 
}
fun Should<String>.haveLength(val length: Int) : ShouldChain<String> { 
	expector.toHaveLength(length)
	return ShouldChain(this) 
}
fun Should<String>.beBlank() : ShouldChain<String> { 
	expector.toBeBlank()
	return ShouldChain(this) 
}
fun Should<String>.notBeBlank() : ShouldChain<String> { 
	expector.toNotBeBlank()
	return ShouldChain(this) 
}
fun Should<String>.beEquivalentTo(val comparison: String) : ShouldChain<String> { 
	expector.toBeEquivalentTo(comparison)
	return ShouldChain(this) 
}
fun Should<String>.endWith(val comparison: String) : ShouldChain<String> { 
	expector.toEndWith(comparison)
	return ShouldChain(this) 
}
fun Should<String>.endWithEquivalent(val comparison: String) : ShouldChain<String> { 
	expector.toEndWithEquivalent(comparison)
	return ShouldChain(this) 
}
fun Should<String>.contain(val comparison: String) : ShouldChain<String> { 
	expector.toContain(comparison)
	return ShouldChain(this) 
}
fun Should<String>.containEquivalent(val comparison: String) : ShouldChain<String> { 
	expector.toContainEquivalent(comparison)
	return ShouldChain(this) 
}
fun Should<String>.notContain(val comparison: String) : ShouldChain<String> { 
	expector.toNotContain(comparison)
	return ShouldChain(this) 
}
fun Should<String>.notContainEquivalent(val comparison: String) : ShouldChain<String> { 
	expector.toNotContainEquivalent(comparison)
	return ShouldChain(this) 
}
fun Should<String>.startWith(val comparison: String) : ShouldChain<String> { 
	expector.toStartWith(comparison)
	return ShouldChain(this) 
}
fun Should<String>.startWithEquivalent(val comparison: String) : ShouldChain<String> { 
	expector.toStartWithEquivalent(comparison)
	return ShouldChain(this) 
}
fun Should<String>.match(val regex: String) : ShouldChain<String> { 
	expector.toMatch(regex)
	return ShouldChain(this) 
}