package cgeo.geocaching.loaders;

import cgeo.geocaching.DataStore;
import cgeo.geocaching.SearchResult;
import cgeo.geocaching.enumerations.CacheType;
import cgeo.geocaching.geopoint.Geopoint;
import cgeo.geocaching.settings.Settings;

import android.content.Context;

public class RemoveFromHistoryLoader extends AbstractSearchLoader {

    private final String[] selected;
    private final Geopoint coords;

    public RemoveFromHistoryLoader(Context context, String[] selected, Geopoint coords) {
        super(context);
        this.selected = selected.clone();
        this.coords = coords;
    }

    @Override
    public SearchResult runSearch() {
        DataStore.clearVisitDate(selected);
        if (coords != null) {
            return DataStore.getHistoryOfCachesMulti(true, Settings.getCacheTypes());
        }
        return DataStore.getHistoryOfCaches(true, CacheType.ALL);
    }

}
