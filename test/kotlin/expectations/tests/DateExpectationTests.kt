package kotlin.expectations.tests

import org.junit.Test as test
import org.junit.Assert.*
import kotlin.test.*
import kotlin.expectations.*
import java.util.Date

class DateExpectationTests {
    test fun toBeAfter () {
        val laterDate = Date(2001, 1, 1)
        val earlierDate = Date(2000, 1, 1)

        expect(laterDate).toBeAfter(earlierDate)
        failsWith<AssertionError>({
            expect(earlierDate).toBeAfter(laterDate)
        })

        laterDate.should.beAfter(earlierDate)
        failsWith<AssertionError>({
            earlierDate.should.beAfter(laterDate)
        })
    }

    test fun toBeBefore () {
        val laterDate = Date(2001, 1, 1)
        val earlierDate = Date(2000, 1, 1)

        expect(earlierDate).toBeBefore(laterDate)
        failsWith<AssertionError>({
            expect(laterDate).toBeBefore(earlierDate)
        })

        earlierDate.should.beBefore(laterDate)
        failsWith<AssertionError>({
            laterDate.should.beBefore(earlierDate)
        })
    }
}