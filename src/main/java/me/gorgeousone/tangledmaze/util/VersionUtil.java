package me.gorgeousone.tangledmaze.util;

import java.util.logging.Logger;

import org.bukkit.Bukkit;

public final class VersionUtil {

	public static Version PLUGIN_VERSION;
	public static Version SERVER_VERSION;
	public static boolean IS_LEGACY_SERVER;

	private VersionUtil() {
	}

	public static void setup(String tangledMazeVersion, Logger logger) {
		PLUGIN_VERSION = new Version(tangledMazeVersion);
		SERVER_VERSION = parseMcVersionSafe(getServerVersionString(), logger);
		IS_LEGACY_SERVER = SERVER_VERSION.isBelow(new Version("1.13.0"));
		logger.info("    Found MC version: " + SERVER_VERSION);
	}

	public static String getServerVersionString() {
		return Bukkit.getBukkitVersion().split("-")[0];
	}

	public static Version parseMcVersionSafe(String versionString, Logger logger) {
		int major = 1;
		int minor = 13;
		int patch = 0;

		boolean abort = false;
		String[] split = versionString.split("\\.");

		try {
			major = Integer.parseInt(split[0]);
		} catch (Exception e) {
			logger.warning("Could not find MC major version. Assuming aquatic update (1.13) or later.");
			abort = true;
		}
		if (!abort && split.length > 1) {
			try {
				minor = Integer.parseInt(split[1]);
			} catch (Exception e) {
				logger.warning("Could not parse MC minor version. Assuming 0.");
				abort = true;
			}
		}
		if (!abort && split.length > 2) {
			try {
				patch = Integer.parseInt(split[2]);
			} catch (Exception ignored) {}
		}
		return new Version(major, minor, patch);
	}

}
