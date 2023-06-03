package net.crossscar.cshacks.multi.cshacks;

import net.crossscar.cshacks.multi.cshacks.hacks.FlyHack;
import net.crossscar.cshacks.multi.cshacks.hacks.FullBrightHack;
import net.crossscar.cshacks.multi.cshacks.hacks.XrayHack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsHacks
{
	public static final String MOD_ID = "cshacks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void init() {
		new FlyHack().init();
		new XrayHack().init();
		new FullBrightHack().init();
	}
}