package com.jr;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Gett {

    public static Collection<Dto> getEnt() {
        return Collections.singletonList(new Dto("8-4725-24-09-50", "someString -_-_- // ", new Date()));
    }
}
