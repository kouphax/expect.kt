package kotlin.expectations

import java.util.regex.Pattern
import kotlin.test.assertTrue
import kotlin.test.assertNull
import kotlin.test.assertNotNull

// Entry points for expectations
public fun <T> expect(val target: T) : Expectation<T> {
    return Expectation(target)
}


public val <T> T.should : Should<T> get() = Should(this)

// sugar
public class ExpectationChain<T>(val expectation: Expectation<T>) {
    val and: Expectation<T> get() = expectation
}

// add support for chaining
public class ShouldChain<T>(val should: Should<T>) {
    val and: Should<T> get() = should
}

public open class Expectation<T>(val target: T) {

    fun toBeNull() : ExpectationChain<T> {
        assertNull(target)
        return ExpectationChain(this)
    }

    fun toNotBeNull() : ExpectationChain<T> {
        assertNotNull(target)
        return ExpectationChain(this)
    }

    fun toBe(val test: T) : ExpectationChain<T>{
        assertTrue(target == test)
        return ExpectationChain(this)
    }

    fun toNotBe(val test: T) : ExpectationChain<T>{
        assertTrue(target != test)
        return ExpectationChain(this)
    }
}



// Shim around expectations
public class Should<T>(val target: T){

    val expector = Expectation(target)

    // NULLABLE TYPES
    fun beNull() : ShouldChain<T>  {
        expector.toBeNull()
        return ShouldChain(this)
    }

    fun notBeNull() : ShouldChain<T> {
        expector.toNotBeNull()
        return ShouldChain(this)
    }

    fun be(val test: T) : ShouldChain<T> {
        expector.toBe(test)
        return ShouldChain(this)
    }

    fun notBe(val test: T) : ShouldChain<T> {
        expector.toNotBe(test)
        return ShouldChain(this)
    }
}