## Introduction

Expect.kt is a set of assertions that allow you to assert the outcome of testing state using a more fluent and specific set of assertions than you get from the `kotlin.test`.  Each type has a set of extension functions that allow you to check certain specifics that relate to that type.

## Syntax

Expect.kt allows you to use two different approaches to defining an assertion.

### Expect Syntax

Expect syntax offers typical expect(something).toBeInACertainState style of grammar.  The following test highlight this appraoch.

    expect("james").toBe("james")

### Fluent Syntax

It is also possible to use a more fluent syntax to make the same assertion

    "james".should.be("james")

## Chaining

Expect.kt allows you to chain assertions to keep things really neat and tidy.

    expect("james").toStartWith("j").and.toEndWith("s")
    
Or, in fluent syntax

    "james".should.startWith("j").and.endWith("s")
    
## The Assertions

### Standard Assertions

There are a few assertions that can be used against any type,

- `toBe(...)/be(...)` - assert that the state is the value passed in,

    expect("james").toBe("james")
    "james".should.be("james")
    
- `toNotBe(...)/notBe(...)` - assert that the state is NOT the value passed in,

    expect("james").toNotBe("henry")
    "james".should.notBe("henry")


<!--
#   // STANDARD TESTS

    // toBe
    // toNotBe
    // toBeNull
    // toNotBeNull

#   // BOOLEAN TYPES

    // toBeTrue
    // toBeFalse

#   // STRING TYPES

    // toBeEmpty
    // toNotBeEmpty
    // toHaveLength
    // toBeBlank
    // toNotBeBlank
    // toBeEquivalentTo
    // toEndWith
    // toEndWithEquivalent
    // toContain
    // toContainEquivalent
    // toNotContain
    // toNotContainEquivalent
    // toStartWith
    // toStartWithEquivalent
    // toMatch

#   // NUMERIC TYPES

    // toBeGreaterOrEqualTo
    // toBeGreaterThan
    // toBeLessOrEqualTo
    // toBeLessThan
    // toBePositive
    // toBeInRange
    // toBeApproximately

#    // DATES, TIMES AND TIMESTAMPS

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

#    // COLLECTIONS

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

#    // DICTIONARIES

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

#    // EXCEPTIONS

    // toThrow
    // toThrow(type)
    // toNotThrow
    // toNotThrow(type)
-->