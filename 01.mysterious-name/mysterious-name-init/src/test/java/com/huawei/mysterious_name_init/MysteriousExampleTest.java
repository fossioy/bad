/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.mysterious_name_init;

import java.util.Random;

import org.junit.jupiter.api.Test;

import com.huawei.mysterious_name_init.MysteriousExample;
import com.huawei.mysterious_name_init.Perf;
import com.huawei.mysterious_name_init.Type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MysteriousExampleTest {
    @Test
    public void should_got_40000_when_amont_given_aud_is_29_and_Type_is_TYPE1() {
        Perf perf = new Perf(29);
        Type type = Type.TYPE1;

        int amount = new MysteriousExample().amont(perf, type);

        assertEquals(40000, amount);
    }

    @Test
    public void should_got_40000_when_amont_given_aud_is_30_and_Type_is_TYPE1() {
        Perf perf = new Perf(30);
        Type type = Type.TYPE1;

        int amount = new MysteriousExample().amont(perf, type);

        assertEquals(40000, amount);
    }

    @Test
    public void should_got_41000_when_amont_given_aud_is_31_and_Type_is_TYPE1() {
        Perf perf = new Perf(31);
        Type type = Type.TYPE1;

        int amount = new MysteriousExample().amont(perf, type);

        assertEquals(41000, amount);
    }

    @Test
    public void should_got_30000_when_amont_given_aud_is_19_and_Type_is_TYPE2() {
        Perf perf = new Perf(19);
        Type type = Type.TYPE2;

        int amount = new MysteriousExample().amont(perf, type);

        assertEquals(30000, amount);
    }

    @Test
    public void should_got_30000_when_amont_given_aud_is_20_and_Type_is_TYPE2() {
        Perf perf = new Perf(20);
        Type type = Type.TYPE2;

        int amount = new MysteriousExample().amont(perf, type);

        assertEquals(30000, amount);
    }

    @Test
    public void should_got_31500_when_amont_given_aud_is_21_and_Type_is_TYPE2() {
        Perf perf = new Perf(21);
        Type type = Type.TYPE2;

        int amount = new MysteriousExample().amont(perf, type);

        assertEquals(31500, amount);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_amont_given_Type_UNKOWN() {
        Perf perf = new Perf(new Random().nextInt(Integer.MAX_VALUE));
        Type type = Type.UNKNOWN;

        assertThrows(IllegalArgumentException.class, () -> new MysteriousExample().amont(perf, type));
    }
}
