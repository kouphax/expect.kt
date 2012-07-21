package kotlin.tests

import org.junit.Test as test
import org.junit.Assert.*
import kotlin.test.*
import kotlin.expectations.*


class StringExpectationTests {

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

    test fun toEndWith() {
        expect("james").toEndWith("s")

        failsWith<AssertionError>({
            expect("james").toEndWith("j")
        })

        "james".should.endWith("s")

        failsWith<AssertionError>({
            "james".should.endWith("j")
        })
    }

    test fun toContain() {
        expect("james").toContain("ame")

        failsWith<AssertionError>({
           expect("james").toContain("nope")
        })

        "james".should.contain("ame")

        failsWith<AssertionError>({
            "james".should.contain("nope")
        })
    }

    test fun toNotContain() {
        expect("james").toNotContain("nope")

        failsWith<AssertionError>({
           expect("james").toNotContain("ame")
        })

        "james".should.notContain("nope")

        failsWith<AssertionError>({
            "james".should.notContain("ame")
        })
    }

    test fun toStartWith() {
        expect("james").toStartWith("j")

        failsWith<AssertionError>({
            expect("james").toStartWith("s")
        })

        "james".should.startWith("j")

        failsWith<AssertionError>({
            "james".should.startWith("s")
        })
    }

    test fun toMatch(){
        expect("james").toMatch("^james$")

        failsWith<AssertionError>({
            expect("james").toMatch("^fail$")
        })

        "james".should.match("^james$")

        failsWith<AssertionError>({
            "james".should.match("^fail$")
        })
    }

    test fun toEndWithEquivalent() {
        expect("james").toEndWithEquivalent("S")

        "james".should.endWithEquivalent("S")
    }

    test fun toContainEquivalent() {
        expect("james").toContainEquivalent("aMe")

        "james".should.containEquivalent("aMe")
    }

    test fun toNotContainEquivalent() {
        failsWith<AssertionError>({
           expect("james").toNotContainEquivalent("aMe")
        })

        failsWith<AssertionError>({
            "james".should.notContainEquivalent("aMe")
        })
    }

    test fun toStartWithEquivalent() {
        expect("james").toStartWithEquivalent("J")

        "james".should.startWithEquivalent("J")
    }
}