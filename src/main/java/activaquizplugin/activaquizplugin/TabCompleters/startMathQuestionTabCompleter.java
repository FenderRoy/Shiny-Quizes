package activaquizplugin.activaquizplugin.TabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class startMathQuestionTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            List<String> completions = new ArrayList<>();
            completions.add("plusSom");
            completions.add("minSom");
            completions.add("keerSom");
            completions.add("randomSom");

            return completions;
        }

        return null;
    }
}
