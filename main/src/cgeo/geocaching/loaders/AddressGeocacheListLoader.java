package cgeo.geocaching.loaders;

import cgeo.geocaching.SearchResult;
import cgeo.geocaching.connector.gc.GCMultiParser;
import cgeo.geocaching.settings.Settings;

import android.content.Context;

public class AddressGeocacheListLoader extends AbstractSearchLoader {

    private final String address;

    public AddressGeocacheListLoader(Context context, String address) {
        super(context);
        this.address = address;
    }

    @Override
    public SearchResult runSearch() {
        return GCMultiParser.searchByAddressMulti(address, Settings.getCacheTypes(), Settings.isShowCaptcha(), this);
    }

}
