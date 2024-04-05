/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.mysterious_name;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RenamedExampleTest {
    @Test
    public void should_got_40000_when_calculateAmount_given_aud_is_29_and_Type_is_TRAGEDY() {
        Performance performance = new Performance(29);
        PlayType playType = PlayType.TRAGEDY;

        int amount = new RenamedExample().calculateAmount(performance, playType);

        assertEquals(40000, amount);
    }

    @Test
    public void should_got_40000_when_calculateAmount_given_aud_is_30_and_Type_is_TRAGEDY() {
        Performance performance = new Performance(30);
        PlayType playType = PlayType.TRAGEDY;

        int amount = new RenamedExample().calculateAmount(performance, playType);

        assertEquals(40000, amount);
    }

    @Test
    public void should_got_41000_when_calculateAmount_given_aud_is_31_and_Type_is_TRAGEDY() {
        Performance performance = new Performance(31);
        PlayType playType = PlayType.TRAGEDY;

        int amount = new RenamedExample().calculateAmount(performance, playType);

        assertEquals(41000, amount);
    }

    @Test
    public void should_got_30000_when_calculateAmount_given_aud_is_19_and_Type_is_COMEDY() {
        Performance performance = new Performance(19);
        PlayType playType = PlayType.COMEDY;

        int amount = new RenamedExample().calculateAmount(performance, playType);

        assertEquals(30000, amount);
    }

    @Test
    public void should_got_30000_when_calculateAmount_given_aud_is_20_and_Type_is_COMEDY() {
        Performance performance = new Performance(20);
        PlayType playType = PlayType.COMEDY;

        int amount = new RenamedExample().calculateAmount(performance, playType);

        assertEquals(30000, amount);
    }

    @Test
    public void should_got_31500_when_calculateAmount_given_aud_is_21_and_Type_is_COMEDY() {
        Performance performance = new Performance(21);
        PlayType playType = PlayType.COMEDY;

        int amount = new RenamedExample().calculateAmount(performance, playType);

        assertEquals(31500, amount);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_calculateAmount_given_Type_UNKOWN() {
        Performance performance = new Performance(new Random().nextInt(Integer.MAX_VALUE));
        PlayType playType = PlayType.UNKNOWN;

        assertThrows(IllegalArgumentException.class, () -> new RenamedExample().calculateAmount(performance, playType));
    }
}