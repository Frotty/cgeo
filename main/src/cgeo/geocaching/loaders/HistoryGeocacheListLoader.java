package cgeo.geocaching.loaders;

import cgeo.geocaching.DataStore;
import cgeo.geocaching.SearchResult;
import cgeo.geocaching.enumerations.CacheType;
import cgeo.geocaching.geopoint.Geopoint;
import cgeo.geocaching.settings.Settings;

import android.content.Context;

public class HistoryGeocacheListLoader extends AbstractSearchLoader {
    private final Geopoint coords;

    public HistoryGeocacheListLoader(Context context, Geopoint coords) {
        super(context);
        this.coords = coords;
    }

    @Override
    public SearchResult runSearch() {
        if (coords != null) {
            return DataStore.getHistoryOfCachesMulti(true, Settings.getCacheTypes());
        }
        return DataStore.getHistoryOfCaches(true, CacheType.ALL);

    }

}
