package net.crossscar.cshacks.multi.cshacks.fabric;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.crossscar.cshacks.multi.cshacks.gui.HacksScreen;

public class ModMenuConfig implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return HacksScreen::new;
    }
}
