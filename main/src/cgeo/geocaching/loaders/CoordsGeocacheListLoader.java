package cgeo.geocaching.loaders;

import cgeo.geocaching.SearchResult;
import cgeo.geocaching.connector.ConnectorFactory;
import cgeo.geocaching.connector.capability.ISearchByCenter;
import cgeo.geocaching.connector.gc.GCMultiParser;
import cgeo.geocaching.geopoint.Geopoint;
import cgeo.geocaching.settings.Settings;

import android.content.Context;

public class CoordsGeocacheListLoader extends AbstractSearchLoader {
    private final Geopoint coords;

    public CoordsGeocacheListLoader(Context context, Geopoint coords) {
        super(context);
        this.coords = coords;
    }

    @Override
    public SearchResult runSearch() {

        SearchResult search = new SearchResult();
        if (Settings.isGCConnectorActive()) {
            search = GCMultiParser.searchByCoordsMulti(coords, Settings.getCacheTypes(), Settings.isShowCaptcha(), this);
        }

        for (ISearchByCenter centerConn : ConnectorFactory.getSearchByCenterConnectors()) {
            if (centerConn.isActivated()) {
                search.addSearchResult(centerConn.searchByCenter(coords));
            }
        }

        return search;
    }

}
