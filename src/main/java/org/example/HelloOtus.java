package org.example;


import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;

public class HelloOtus {
    Multimap< String, String > otusMap = HashMultimap.create();

    public void setOtusMap() {
        otusMap.putAll((Multimap<? extends String, ? extends String>) new HashMap<String, String>());
    }
}
