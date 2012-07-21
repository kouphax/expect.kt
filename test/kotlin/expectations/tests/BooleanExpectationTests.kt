package kotlin.tests

import org.junit.Test as test
import org.junit.Assert.*
import kotlin.test.*
import kotlin.expectations.*


class BooleanExpectationTests {
    test fun toBeTrueTest () {
        expect(true).toBeTrue()

        failsWith<AssertionError>({
            expect(false).toBeTrue()
        })

        true.should.beTrue()

        failsWith<AssertionError>({
            false.should.beTrue()
        })
    }

    test fun toBeFalseTest () {
        expect(false).toBeFalse()

        failsWith<AssertionError>({
            expect(true).toBeFalse()
        })

        false.should.beFalse()

        failsWith<AssertionError>({
            true.should.beFalse()
        })
    }
}