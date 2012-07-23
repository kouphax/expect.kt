# Introduction

Expect.kt is a set of assertions that allow you to assert the outcome of testing state using a more fluent and specific set of assertions than you get from the `kotlin.test`.  Each type has a set of extension functions that allow you to check certain specifics that relate to that type.

Rather than fulfilling a specific need this project was started as a means to understand the [Kotlin](http://confluence.jetbrains.net/display/Kotlin/Welcome) language and explore its features (and limitations).  As it stands most of the assertions are not making good use of the "Kotlin way" and are shamelessly ripped off [FluentAssertions for .NET](http://fluentassertions.codeplex.com/).  The tweaking and improving come next plus there are actually some really nice bits of testing code with Kotlin.

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

Assert that a string is empty ("").

	expect("").toBeEmpty()
    "".should.beEmpty()

## toNotBeEmpty

Assert that a string is not empty ("").

	expect("  ").toNotBeEmpty()
    "  ".should.beNotEmpty()

## toHaveLength

Assert that a string is of a certain length.

	expect("james").toHaveLength(5)
    "james".should.haveLength(5)

## toBeBlank

Assert that a string is blank, in that it is empty or contains only whitespace.

	expect("   ").toBeBlank()
    "    ".should.beBlank()

## toNotBeBlank

Assert that a string is not blank, in that it isn't empty or contains more than whitespace.

	expect("james").toNotBeBlank()
    "james".should.notBeBlank()

## toBeEquivalentTo

Assert that a string is equal to another string regardless of case.

	expect("JAMES").toBeEquivalentTo("james")
    "JAMES".should.beEquivalentTo("james")

## toEndWith

Assert that a string ends with another string

	expect("James").toEndWith("es")
    "James".should.endWith("es")

## toEndWithEquivalent

Assert that a string ends with another string regardless of case.

	expect("JAMES").toEndWithEquivalent("es")
    "JAMES".should.endWithEquivalent("es")

## toContain

Assert that a string contains another string.

	expect("JAMES").toContain("AM")
    "JAMES".should.contain("AM)

## toContainEquivalent

Assert that a string contains another string regardless of case.

## toNotContain

Assert that a string doesn't contain another string.

## toNotContainEquivalent

Assert that a string doesn't contain another string regardless of case.

## toStartWith

Assert that a string starts with another string.

## toStartWithEquivalent

Assert that a string starts with another string regardless of case.

## toMatch

Assert that a string matches the given regex.

# Numeric Assertions (currently Int, Long, Double)

## toBeGreaterOrEqualTo

Assert that a number is greater than or equal to another

## toBeGreaterThan

Assert that a number is greater than to another

## toBeLessOrEqualTo

Assert that a number is less than or equal to another

## toBeLessThan

Assert that a number is less than to another

## toBeInRange

Assert that a number is within the lower and upper bounds passed in

## toBeApproximately

Assert that a number is approximately another, the level of error is defined by the tolerance value (+/- tolerance)

# Date and Time Assertions

## toBeAfter

Assert that the given date is after the passed in date.

## toBeBefore

Assert that the given date is before the passed in date.

## toBeOnOrAfter

Asserts that the passed in date is on or after the asserted date without considering the time part of the date.  _This is a dubious decisions and needs properly considered_

<!--
> TODO: This stuff is still in development and very subject to change.

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

-->