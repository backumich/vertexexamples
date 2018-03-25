package com.vertex.academy;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class FactorialCalculatorTest {

    FactorialCalculator underTest;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void factorial() {
        long result = underTest.factorial(3);

        assertThat(result, allOf(isDividedBy(1),
                isDividedBy(2),
                isDividedBy(3)));
    }

    private Matcher<Long> isDividedBy(final int number){
        return new BaseMatcher<Long>() {
            public boolean matches(Object item) {
                Long underTest = (Long) item;
                return underTest % number == 0;
            }

            public void describeTo(Description description) {

            }
        };
    }


    @Test
    public void forExample() {
        Object myBean = null;
        assertThat(myBean, hasProperty("foo", equalTo("bar")));

        assertThat("   my\tlovely  string ", equalToIgnoringWhiteSpace("my lovely string"));

        assertThat(7, not(allOf(equalTo(3), equalTo(5))));
    }
}