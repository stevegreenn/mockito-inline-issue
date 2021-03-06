package mockito.inline.issue

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import static org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner)
class GroovyMockitoTest {

    @Mock Helper helper
    @InjectMocks ClassUnderTest classUnderTest

    /**
     * Test that the Groovy class under test can call methods on a mocked Groovy
     * helper class.
     */
    @Test
    void testCallGroovyFromGroovy() {
        classUnderTest.methodUnderTest()
        verify(helper).helperMethod()
    }

    static class ClassUnderTest {
        private final Helper helper

        ClassUnderTest(Helper helper) {
            this.helper = helper
        }

        void methodUnderTest() {
            helper.helperMethod()
        }
    }

    static class Helper {
        void helperMethod() { }
    }
}