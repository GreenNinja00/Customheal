import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Attr;

public class commands implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String string, @NotNull String[] args) {


        if (sender.isOp()) {
            if (sender instanceof Player) {

                Player player = (Player) sender;
                if (cmd.getName().equalsIgnoreCase("customheal")) ;
                {
                    Player player1 = Bukkit.getServer().getPlayer(args[0]);
                    double maxhealth = (player1.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
                    if (args.length == 1) {
                        if (player1 != null) {


                            player1.setHealth(maxhealth);
                            sender.sendMessage(Component.text(" Player has been healed").color(TextColor.fromHexString("##00ff00")));

                            player1.sendMessage(Component.text(" You have been healed by" + player.getName()).color(TextColor.fromHexString("##00ff00")));

                        } else {
                            sender.sendMessage(Component.text(" Send a valid playername").color(TextColor.fromHexString("#FF0000")));
                            return true;
                        }

                    }

                    if (args.length >= 2) {
                        if (player1 != null) {

                            int healhealth = Integer.parseInt(args[1]);
                            double currenthealth = player1.getHealth();

                            double healvalue = (healhealth + currenthealth);
                            if ((healhealth + currenthealth) > maxhealth) {

                                 healvalue = maxhealth;

                            }
                            player1.setHealth(healvalue);
                            sender.sendMessage(Component.text(" Player has been healed").color(TextColor.fromHexString("##00ff00")));

                            player1.sendMessage(Component.text(" You have been healed by" + player.getName()).color(TextColor.fromHexString("##00ff00")));
                        } else {
                            sender.sendMessage(Component.text(" Send a valid playername").color(TextColor.fromHexString("#FF0000")));
                            return true;

                        }

                    }
                }
            }

        }
        return true;
    }
}