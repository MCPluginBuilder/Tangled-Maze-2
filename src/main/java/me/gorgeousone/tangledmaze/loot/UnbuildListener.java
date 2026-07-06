package me.gorgeousone.tangledmaze.loot;

import me.gorgeousone.tangledmaze.event.MazeUnbuildEvent;
import me.gorgeousone.tangledmaze.maze.MazePart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class UnbuildListener implements Listener {

	private final LootHandler lootHandler;

	public UnbuildListener(LootHandler lootHandler) {
		this.lootHandler = lootHandler;
	}

	@EventHandler
	public void onMazeUnbuild(MazeUnbuildEvent event) {
		if (event.getMazePart() != MazePart.WALLS) {
			return;
		}
		lootHandler.removeChests(event.getMaze());
	}
}
