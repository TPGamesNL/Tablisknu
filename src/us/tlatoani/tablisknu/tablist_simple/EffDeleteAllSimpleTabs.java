package us.tlatoani.tablisknu.tablist_simple;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import us.tlatoani.tablisknu.tablist.SimpleTablist;
import us.tlatoani.tablisknu.tablist.Tablist;
import us.tlatoani.tablisknu.tablist.TablistProvider;
import org.bukkit.event.Event;

/**
 * Created by Tlatoani on 8/3/16.
 */
public class EffDeleteAllSimpleTabs extends Effect {
    private TablistProvider tablistProvider;

    @Override
    protected void execute(Event event) {
        for (Tablist tablist : tablistProvider.get(event)) {
            if (tablist.getSupplementaryTablist() instanceof SimpleTablist) {
                SimpleTablist simpleTablist = (SimpleTablist) tablist.getSupplementaryTablist();
                simpleTablist.clear();
            }
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return tablistProvider.toString("delete all simple tabs [for %]");
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        tablistProvider = TablistProvider.of(expressions, 0);
        return true;
    }
}
