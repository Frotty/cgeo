package cgeo.geocaching.loaders;

import cgeo.geocaching.SearchResult;
import cgeo.geocaching.connector.gc.GCMultiParser;
import cgeo.geocaching.settings.Settings;

import android.content.Context;

public class UsernameGeocacheListLoader extends AbstractSearchLoader {

    private final String username;

    public UsernameGeocacheListLoader(Context context, String username) {
        super(context);
        this.username = username;
    }

    @Override
    public SearchResult runSearch() {
        return GCMultiParser.searchByUsernameMulti(username, Settings.getCacheTypes(), Settings.isShowCaptcha(), this);
    }

}
