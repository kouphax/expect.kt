package kotlin.expectations.tests

import org.junit.Test as test
import org.junit.Assert.*
import kotlin.test.*
import kotlin.expectations.*

class NumericExpectationTests {

    test fun toBeGreaterOrEqualTo() {
        expect(2).toBeGreaterOrEqualTo(1)
        expect(2).toBeGreaterOrEqualTo(2)
        failsWith<AssertionError>({
            expect(2).toBeGreaterOrEqualTo(3)
        })

        2.should.beGreaterOrEqualTo(1)
        2.should.beGreaterOrEqualTo(2)
        failsWith<AssertionError>({
            2.should.beGreaterOrEqualTo(3)
        })
    }

    test fun toBeGreaterThan() {
        expect(2).toBeGreaterThan(1)
        failsWith<AssertionError>({
            expect(2).toBeGreaterThan(2)
        })

        2.should.beGreaterThan(1)
        failsWith<AssertionError>({
            2.should.beGreaterThan(2)
        })
    }

    test fun toBeLessOrEqualTo() {

        expect(1).toBeLessOrEqualTo(2)
        expect(1).toBeLessOrEqualTo(1)
        failsWith<AssertionError>({
            expect(2).toBeLessOrEqualTo(1)
        })

        1.should.beLessOrEqualTo(2)
        1.should.beLessOrEqualTo(1)
        failsWith<AssertionError>({
            2.should.beLessOrEqualTo(1)
        })

    }

    test fun toBeLessThan() {
        expect(1).toBeLessThan(2)
        failsWith<AssertionError>({
            expect(2).toBeLessThan(2)
        })

        1.should.beLessThan(2)
        failsWith<AssertionError>({
            2.should.beLessThan(2)
        })
    }

    test fun toBePositive() {
        expect(1).toBePositive()
        failsWith<AssertionError>({
            expect(-1).toBePositive()
        })

        1.should.bePositive()
        failsWith<AssertionError>({
            (-1).should.bePositive()
        })
    }

    test fun toBeInRange() {
        expect(2).toBeInRange(1,3)
        expect(2).toBeInRange(2,2)

        failsWith<AssertionError>({
            expect(2).toBeInRange(3,6)
        })

        2.should.beInRange(1,3)
        2.should.beInRange(2,2)

        failsWith<AssertionError>({
            2.should.beInRange(3,6)
        })
    }

    test fun toBeApproximately() {
        expect(2).toBeApproximately(4, 2)
        expect(4).toBeApproximately(2, 2)

        failsWith<AssertionError>({
            expect(2).toBeApproximately(8,5)
        })

        2.should.beApproximately(4, 2)
        4.should.beApproximately(2, 2)

        failsWith<AssertionError>({
            2.should.beApproximately(8,5)
        })
    }
}