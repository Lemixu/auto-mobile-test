package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
//        ArticleTest.class,
//        ChangeAppConditionTests.class,
//        GetStartedTest.class,
//        MyListsTest.class,
        SearchTests.class,
        ArticleTest.class,
        MyListsTest.class,
        Ex9.class,
        Ex6.class,
        Ex5.class
})

public class TestSuite { }
