package com.hospitalapp.commons.util;

import java.util.Collection;

public class ELFunctionsUtil {

    public static boolean collectionContains(Collection<? extends Object> collection, Object entry){
        return collection.contains(entry);
    }

    public static boolean isSubsetCollection(Collection<? extends Object> col, Collection<? extends Object> sub){
        boolean results = false;
        for(Object obj: sub){
            if(col.contains(obj)){
                results = true;
                break;
            }
        }
        return results;
    }
}
