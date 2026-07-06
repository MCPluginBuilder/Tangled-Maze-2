import me.gorgeousone.tangledmaze.util.Version;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VersionTest {
	
	@Test
	void testVersionRegex() {

		Version v100 = new Version("1.0.0");
		Version v101 = new Version("1.0.1");
		Version v110 = new Version("1.1.0");
		Version v200 = new Version("2.0.0");
		Version v20 = new Version("2.0");

		assertTrue(v100.isBelow(v101));
		assertTrue(v100.isBelow(v110));
		assertTrue(v100.isBelow(v200));
		assertTrue(v100.isBelow(v20));

		assertFalse(v101.isBelow(v100));
		assertFalse(v110.isBelow(v100));
		assertFalse(v200.isBelow(v100));
		assertFalse(v20.isBelow(v100));
	}
}
