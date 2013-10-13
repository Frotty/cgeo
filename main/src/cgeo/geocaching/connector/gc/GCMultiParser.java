package cgeo.geocaching.connector.gc;

import cgeo.geocaching.SearchResult;
import cgeo.geocaching.enumerations.CacheType;
import cgeo.geocaching.filter.CacheTypesFilterList;
import cgeo.geocaching.geopoint.Geopoint;
import cgeo.geocaching.loaders.RecaptchaReceiver;

import java.util.LinkedList;
import java.util.List;

public class GCMultiParser {

    public static SearchResult mergeResults(List<SearchResult> results) {
        SearchResult result = new SearchResult();
        for(SearchResult res : results) {
            result.addGeocodes(res.getGeocodes());
        }
        return result;
    }

    public static SearchResult searchByOwnerMulti(final String userName, final CacheTypesFilterList cacheTypes, final boolean showCaptcha, RecaptchaReceiver recaptchaReceiver) {
        List<SearchResult> results = new LinkedList<SearchResult>();
        for (CacheType type : cacheTypes.getTypes()) {
            results.add(GCParser.searchByOwner(userName, type, showCaptcha, recaptchaReceiver));
        }
        return mergeResults(results);
    }

    public static SearchResult searchByUsernameMulti(final String userName, final CacheTypesFilterList cacheTypes, final boolean showCaptcha, RecaptchaReceiver recaptchaReceiver) {
        List<SearchResult> results = new LinkedList<SearchResult>();
        for (CacheType type : cacheTypes.getTypes()) {
            results.add(GCParser.searchByUsername(userName, type, showCaptcha, recaptchaReceiver));
        }
        return mergeResults(results);
    }

    public static SearchResult searchByKeywordMulti(final String keyword, final CacheTypesFilterList cacheTypes, final boolean showCaptcha, RecaptchaReceiver recaptchaReceiver) {
        List<SearchResult> results = new LinkedList<SearchResult>();
        for (CacheType type : cacheTypes.getTypes()) {
            results.add(GCParser.searchByKeyword(keyword, type, showCaptcha, recaptchaReceiver));
        }
        return mergeResults(results);
    }

    public static SearchResult searchByCoordsMulti(final Geopoint coords, final CacheTypesFilterList cacheTypes, final boolean showCaptcha, RecaptchaReceiver recaptchaReceiver) {
        List<SearchResult> results = new LinkedList<SearchResult>();
        for (CacheType type : cacheTypes.getTypes()) {
            results.add(GCParser.searchByCoords(coords, type, showCaptcha, recaptchaReceiver));
        }
        return mergeResults(results);
    }

    public static SearchResult searchByAddressMulti(final String address, final CacheTypesFilterList cacheTypes, final boolean showCaptcha, RecaptchaReceiver recaptchaReceiver) {
        List<SearchResult> results = new LinkedList<SearchResult>();
        for (CacheType type : cacheTypes.getTypes()) {
            results.add(GCParser.searchByAddress(address, type, showCaptcha, recaptchaReceiver));
        }
        return mergeResults(results);
    }

}
