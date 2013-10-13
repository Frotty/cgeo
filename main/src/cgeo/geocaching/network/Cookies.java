package cgeo.geocaching.network;

import cgeo.geocaching.utils.Log;

import ch.boye.httpclientandroidlib.client.CookieStore;
import ch.boye.httpclientandroidlib.cookie.Cookie;
import ch.boye.httpclientandroidlib.impl.client.BasicCookieStore;
import ch.boye.httpclientandroidlib.impl.cookie.BasicClientCookie;

import org.apache.commons.lang3.StringUtils;

public abstract class Cookies {

    private static boolean cookieStoreRestored = false;
    final static CookieStore cookieStore = new BasicCookieStore();

    public static void restoreCookieStore(final String oldCookies) {
        Log.v(">>>>>>>C 1");
        if (!cookieStoreRestored) {
            Log.v(">>>>>>>C 2");
            clearCookies();
            Log.v(">>>>>>>C 3");
            if (oldCookies != null) {
                Log.v(">>>>>>>C 4");
                for (final String cookie : StringUtils.split(oldCookies, ';')) {
                    Log.v(">>>>>>>C 5");
                    final String[] split = StringUtils.split(cookie, "=", 3);
                    Log.v(">>>>>>>C 6");
                    if (split.length == 3) {
                        Log.v(">>>>>>>C 7");
                        final BasicClientCookie newCookie = new BasicClientCookie(split[0], split[1]);
                        Log.v(">>>>>>>C 8");
                        newCookie.setDomain(split[2]);
                        Log.v(">>>>>>>C 9");
                        cookieStore.addCookie(newCookie);
                        Log.v(">>>>>>>C 10");
                    }
                }
            }
            cookieStoreRestored = true;
        }
    }

    public static String dumpCookieStore() {
        StringBuilder cookies = new StringBuilder();
        for (final Cookie cookie : cookieStore.getCookies()) {
            cookies.append(cookie.getName());
            cookies.append('=');
            cookies.append(cookie.getValue());
            cookies.append('=');
            cookies.append(cookie.getDomain());
            cookies.append(';');
        }
        return cookies.toString();
    }

    public static void clearCookies() {
        cookieStore.clear();
    }
}
