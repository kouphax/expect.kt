package kotlin.tests

import org.junit.Test as test
import org.junit.Assert.*
import kotlin.test.*
import kotlin.expectations.*


class StringExpectationTests {

    // toEndWith
    // toContain
    // toNotContain
    // toStartWith
    // toMatch
    // toEndWithEquivalent
    // toBeEquivalentTo
    // toContainEquivalent
    // toStartWithEquivalent
    // toNotContainEquivalent

    test fun toBeEmpty () {

        expect("").toBeEmpty()

        failsWith<AssertionError>({
            expect("james").toBeEmpty()
        })

        failsWith<AssertionError>({
            expect("     ").toBeEmpty()
        })

        "".should.beEmpty()

        failsWith<AssertionError>({
           "pass".should.beEmpty()
        })
    }

    test fun toNotBeEmpty () {

        expect("james").toNotBeEmpty()

        failsWith<AssertionError>({
            expect("").toBeEmpty()
        })

        expect("     ").toNotBeEmpty()

        "james".should.notBeEmpty()

        failsWith<AssertionError>({
           "".should.notBeEmpty()
        })
    }

    test fun toHaveLengthOf(){
        expect("james").toHaveLengthOf(5)

        failsWith<AssertionError>({
            expect("james").toHaveLengthOf(12)
        })

        "james".should.haveLengthOf(5)

        failsWith<AssertionError>({
            "james".should.haveLengthOf(12)
        })
    }

    test fun toBeBlank() {
        expect("").toBeBlank()
        expect("   ").toBeBlank()

        "".should.beBlank()
        "    ".should.beBlank()

        failsWith<AssertionError>({
            expect("james").toBeBlank()
        })

        failsWith<AssertionError>({
            "james".should.beBlank()
        })
    }

    test fun toNotBeBlank() {
        expect("james").toNotBeBlank()
        expect("  james ").toNotBeBlank()

        "james".should.notBeBlank()
        "   james ".should.notBeBlank()

        failsWith<AssertionError>({
            expect("").toNotBeBlank()
        })

        failsWith<AssertionError>({
            expect("     ").toNotBeBlank()
        })

        failsWith<AssertionError>({
            "".should.notBeBlank()
        })

        failsWith<AssertionError>({
            "    ".should.notBeBlank()
        })
    }
}