package kotlin.expectations.tests

import org.junit.Test as test
import org.junit.Assert.*
import kotlin.test.*
import kotlin.expectations.*
import java.util.Date
import org.joda.time.DateTime

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

    test fun toBeOnOrAfter() {

        val currentDay = DateTime().toDate() as Date
        val currentDayDifferentTime = DateTime().minusHours(1)?.toDate() as Date
        val previousDay = DateTime().minusDays(1)?.toDate() as Date
        val nextDay = DateTime().plusDays(1)?.toDate() as Date

        expect(currentDay).toBeOnOrAfter(previousDay)
        expect(currentDay).toBeOnOrAfter(currentDayDifferentTime)
        failsWith<AssertionError>({
            expect(currentDay).toBeOnOrAfter(nextDay)
        })
    }
}