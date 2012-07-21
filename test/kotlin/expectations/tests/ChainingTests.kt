package kotlin.expectations.tests

import org.junit.Test as test
import org.junit.Assert.*
import kotlin.test.*
import kotlin.expectations.*


class ChainingTests {
    test fun And () {
        expect("james").toStartWith("j").and.toEndWith("s")

        failsWith<AssertionError>({
            expect("james").toStartWith("j").and.toEndWith("f")
        })

        failsWith<AssertionError>({
            expect("james").toStartWith("f").and.toEndWith("s")
        })
    }
}