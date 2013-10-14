package cgeo.geocaching.filter;

import cgeo.geocaching.enumerations.CacheType;
import cgeo.geocaching.utils.Log;

import java.util.LinkedList;
import java.util.List;

public class CacheTypesFilterList {
    public static CacheTypesFilterList INSTANCE = new CacheTypesFilterList();

    private CacheTypesFilterList() {
        types.add(CacheType.TRADITIONAL);
    }

    List<CacheType> types = new LinkedList<CacheType>();

    public void addType(CacheType type) {
        types.add(type);
    }

    public void removeType(CacheType type) {
        types.remove(type);
    }

    public boolean isAll() {
        return types.size() >= 17;
    }

    public boolean isSingle() {
        return types.size() == 1;
    }

    public int getSize() {
        return types.size();
    }

    public List<CacheType> getTypes() {
        return types;
    }

    public final String getL10nSequence() {
        Log.v(">>>>>>>L10n seq");
        String result = "";
        if( types.size() < 1 ) {
            return "";
        }
        for (CacheType type : types) {
            result += type.getL10n();
            result += ", ";
        }

        return result.substring(0, result.length() - 2);
    }

    public boolean[] convertToArray() {
        boolean[] result = new boolean[17];
        // Ugly
        result[0] = types.contains(CacheType.TRADITIONAL);
        result[1] = types.contains(CacheType.MULTI);
        result[2] = types.contains(CacheType.MYSTERY);
        result[3] = types.contains(CacheType.CITO);
        result[4] = types.contains(CacheType.EARTH);
        result[5] = types.contains(CacheType.EVENT);
        result[6] = types.contains(CacheType.GPS_EXHIBIT);
        result[7] = types.contains(CacheType.BLOCK_PARTY);
        result[8] = types.contains(CacheType.GCHQ);
        result[9] = types.contains(CacheType.LETTERBOX);
        result[10] = types.contains(CacheType.LOSTANDFOUND);
        result[11] = types.contains(CacheType.MEGA_EVENT);
        result[12] = types.contains(CacheType.PROJECT_APE);
        result[13] = types.contains(CacheType.UNKNOWN);
        result[14] = types.contains(CacheType.VIRTUAL);
        result[15] = types.contains(CacheType.WEBCAM);
        result[16] = types.contains(CacheType.WHERIGO);
        return result;
    }

    public boolean contains(CacheType type) {
        return types.contains(type);
    }
}
