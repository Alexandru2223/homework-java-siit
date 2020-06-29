package com.ibm.streams.tutorial.util;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.ComparisonFailure;

public class StringWithComparisonMatcher extends TypeSafeDiagnosingMatcher<String> {
    private final String expected;

    private StringWithComparisonMatcher(String expected) {
        this.expected = expected;
    }

    public static StringWithComparisonMatcher isString(String expected) {
        return new StringWithComparisonMatcher(expected);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(expected);
    }

    @Override
    protected boolean matchesSafely(String actual, Description mismatchDescription) {
        if (!expected.equals(actual)) {
            String compactedMismatch = new ComparisonFailure("did not match:", expected, actual).getMessage();
            mismatchDescription.appendText(compactedMismatch);
            return false;
        }
        return true;
    }

}
