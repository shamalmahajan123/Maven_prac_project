package dev1;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        ProductPlaced.class // Add your test classes here
})
public class TestSuite {
}


