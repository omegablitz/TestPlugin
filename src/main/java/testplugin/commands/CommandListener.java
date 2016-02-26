package testplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import testplugin.TestPlugin;

/**
 * Created by Aashish on 2/26/2016.
 */
public class CommandListener implements CommandExecutor {
    private TestPlugin pl;

    public CommandListener(TestPlugin pl) {
        this.pl = pl;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length == 0) {
            help(sender);
            return true;
        }

        if(args[0].equals("help")) {
            help(sender);
            return true;
        } else if(args[0].equals("create")) {
            if(args.length < 3) {
                help(sender);
                return true;
            }
            StringBuilder aliasCommand = new StringBuilder();
            for (int i = 2; i < args.length; i++) {
                aliasCommand.append(args[i]);
                if (i != args.length - 1) {
                    aliasCommand.append(' ');
                }
            }
            pl.getConfiguration().set(args[1], aliasCommand.toString());
            pl.saveConfig();
            sender.sendMessage("Alias created!");
            return true;
        } else if(args[0].equals("reload")) {
            pl.reloadConfig();
            sender.sendMessage("Reloaded");
            return true;
        }

        help(sender);
        return true;
    }

    public void help(CommandSender sender) {
        sender.sendMessage("Usage: /alias <alias> <command string>");
    }
}
