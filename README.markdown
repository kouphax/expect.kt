# Introduction

Expect.kt is a set of assertions that allow you to assert the outcome of testing state using a more fluent and specific set of assertions than you get from the `kotlin.test`.  Each type has a set of extension functions that allow you to check certain specifics that relate to that type.

# Syntax

Expect.kt allows you to use two different approaches to defining an assertion.

## Expect Syntax

Expect syntax offers typical expect(something).toBeInACertainState style of grammar.  The following test highlight this appraoch.

    expect("james").toBe("james")

## Fluent Syntax

It is also possible to use a more fluent syntax to make the same assertion

    "james".should.be("james")

# Chaining

Expect.kt allows you to chain assertions to keep things really neat and tidy.

    expect("james").toStartWith("j").and.toEndWith("s")
    
Or, in fluent syntax

    "james".should.startWith("j").and.endWith("s")

# Standard Assertions

There are a few assertions that can be used against any type,

## toBe(...)/be(...)

Assert that the state is the value passed in,

    expect("james").toBe("james")
    "james".should.be("james")

## toNotBe(...)/notBe(...)

Assert that the state is NOT the value passed in,

    expect("james").toNotBe("henry")
    "james".should.notBe("henry")

## toBeNull()/beNull()

Assert that the state is null,

    expect(null).toBeNull()
    null.should.beNull()

## toNotBeNull()/notBeNull()

Assert that the state is NOT null

    expect("james").toNotBeNull()
    "james".should.notBeNull()
    
# Logic Assertions

## toBeTrue()/beTrue()

Assert that the value is `true`

    expect(true).toBeTrue()
    true.should.beTrue()
    
## toNotBeTrue()/notBeTrue()

Assert that the state is NOT `true`

    expect(false).toNotBeTrue()
    false.should.notBeTrue()
    
## toBeFalse()/beFalse()

Assert that the value is `false`

    expect(false).toBeFalse()
    false.should.beFalse()
    
## toNotBeFalse()/notBeFalse()

Assert that the state is NOT `false`

    expect(true).toNotBeFalse()
    true.should.notBeFalse()
    
# String Assertions

## toBeEmpty
## toNotBeEmpty
## toHaveLength
## toBeBlank
## toNotBeBlank
## toBeEquivalentTo
## toEndWith
## toEndWithEquivalent
## toContain
## toContainEquivalent
## toNotContain
## toNotContainEquivalent
## toStartWith
## toStartWithEquivalent
## toMatch

# Int Assertions

## toBeGreaterOrEqualTo
## toBeGreaterThan
## toBeLessOrEqualTo
## toBeLessThan
## toBePositive
## toBeInRange
## toBeApproximately

> TODO: This stuff is still in development and very subject to change.

# Date and Time Assertions

## toBeAfter
## toBeBefore
## toBeOnOrAfter
## toHaveDay
## toHaveMonth
## toHaveYear
## toHaveHour
## toHaveMinute
## toHaveSecond
## toBeLessThan().before()
## toBeWithin(timespan).after()
## toBeMoreThan(timespan)...
## toBeAtLeast(timespan)...
## toBeExactly

# Collection Assertions

## toNotBeEmpty
## toHaveCount
## toContainInOrder
## toHaveSameCount
## toBeSubsetOf
## toNotBeSubsetOf
## toHaveElementAt
## toNotHaveElementAt
## toContain
## toContain - lambda
## toNotContain - lambda
## toOnlyContain - lambda
## toNotContainNulls
## toBeEmpty

# Dictionary Assertions

## toEqual
## toNotEqual
## toBeEmpty
## toNotBeEmpty
## toContainKey
## toNotContainKey
## toContainValue
## toNotContainValue
## toHaveCount
## toContain - keyvaluepair

# Exception Assertions

## toThrow
## toThrow&lt;TException>
## toNotThrow
## toNotThrow&lt;TException>