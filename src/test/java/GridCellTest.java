import me.gorgeousone.tangledmaze.generation.GridCell;
import me.gorgeousone.tangledmaze.util.Direction;
import me.gorgeousone.tangledmaze.util.Vec2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridCellTest {

	@Test
	void testGridCellWalls() {
		GridCell cell = new GridCell(new Vec2(0, 0), new Vec2(3, 4), null);
		List<Vec2> wallsPositiveX = cell.getWalls(Direction.EAST);
		System.out.println(wallsPositiveX);
		assertTrue(wallsPositiveX.contains(new Vec2(2, 0)));
		assertTrue(wallsPositiveX.contains(new Vec2(2, 1)));
		assertTrue(wallsPositiveX.contains(new Vec2(2, 2)));
		assertTrue(wallsPositiveX.contains(new Vec2(2, 3)));
		assertEquals(wallsPositiveX.size(), 4);

		List<Vec2> wallsNegativeZ = cell.getWalls(Direction.NORTH);
		System.out.println(wallsNegativeZ);
		assertTrue(wallsNegativeZ.contains(new Vec2(0, 0)));
		assertTrue(wallsNegativeZ.contains(new Vec2(1, 0)));
		assertTrue(wallsNegativeZ.contains(new Vec2(2, 0)));
		assertEquals(wallsNegativeZ.size(), 3);
	}
}
