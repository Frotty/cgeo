package cgeo.geocaching.loaders;

import cgeo.geocaching.SearchResult;
import cgeo.geocaching.connector.ConnectorFactory;
import cgeo.geocaching.connector.capability.ISearchByKeyword;
import cgeo.geocaching.connector.gc.GCMultiParser;
import cgeo.geocaching.settings.Settings;

import android.content.Context;

public class KeywordGeocacheListLoader extends AbstractSearchLoader {

    private final String keyword;

    public KeywordGeocacheListLoader(Context context, String keyword) {
        super(context);
        this.keyword = keyword;
    }

    @Override
    public SearchResult runSearch() {
        SearchResult searchResult = new SearchResult();
        if (Settings.isGCConnectorActive()) {
            searchResult = GCMultiParser.searchByKeywordMulti(keyword, Settings.getCacheTypes(), Settings.isShowCaptcha(), this);
        }

        for (ISearchByKeyword connector : ConnectorFactory.getSearchByKeywordConnectors()) {
            if (connector.isActivated()) {
                searchResult.addSearchResult(connector.searchByName(keyword));
            }
        }

        return searchResult;
    }

}
