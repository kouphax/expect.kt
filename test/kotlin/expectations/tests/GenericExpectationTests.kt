package kotlin.tests

import org.junit.Test as test
import org.junit.Assert.*
import kotlin.test.*
import kotlin.expectations.*


class GenericExpectationTests {
    test fun toBe () {
        expect("james").toBe("james")

        failsWith<AssertionError>({
            expect("pass").toBe("fail")
        })

        "james".should.be("james")

        failsWith<AssertionError>({
           "pass".should.be("fail")
        })
    }

    test fun toNotBe() {
        expect("james").toNotBe("fail")

        failsWith<AssertionError>({
            expect("fail").toNotBe("fail")
        })

        "james".should.notBe("fail")

        failsWith<AssertionError>({
           "fail".should.notBe("fail")
        })
    }

    test fun toBeNull () {
        expect(null).toBeNull()

        failsWith<AssertionError>({
            expect("pass").toBeNull()
        })

        null.should.beNull()

        failsWith<AssertionError>({
           "pass".should.beNull()
        })
    }

    test fun toNotBeNull () {
        expect("asdasd").toNotBeNull()

        failsWith<AssertionError>({
            expect(null).toNotBeNull()
        })

        "asdasd".should.notBeNull()

        failsWith<AssertionError>({
           null.should.notBeNull()
        })
    }
}