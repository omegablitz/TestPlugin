package testplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import testplugin.TestPlugin;

/**
 * Created by Aashish on 2/26/2016.
 */
public class CommandPreprocessor implements Listener {
    private TestPlugin pl;

    public CommandPreprocessor(TestPlugin pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        String cmd = e.getMessage().substring(1).trim();
        if(cmd.contains(" ")) {
            // If more than one token
            return;
        }
        String alias = pl.getConfiguration().getString(cmd);
        if(alias != null) {
            e.setMessage('/' + alias);
        }
    }
}
