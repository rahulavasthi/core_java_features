package baseFeatures;

import java.io.IOException;

public class OverridingTest {
	OverridingTest testOverride(int i) throws IOException {
		return new OverridingTest();
	}
}


class OverridingTestSubClass extends  OverridingTest{
	protected OverridingTestSubClass testOverride(int i) throws  IOException{
		return new OverridingTestSubClass();
	}
}
