package core;


import lichessTest.LichessTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(LichessTest.class)
@IncludeTags("puper")
public class Junit5Runner {
}
