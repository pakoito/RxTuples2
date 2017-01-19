/*
 * Copyright (c) pakoito 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxtuples2;

import org.javatuples.Octet;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Septet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;
import org.junit.Assert;
import org.junit.Test;

import io.reactivex.Observable;

public class RxTuplesTest {
    public static final Pair<Integer, Integer> RES_PAIR = Pair.with(1, 2);

    public static final Triplet<Integer, Integer, Integer> RES_TRIPLET = Triplet.with(1, 2, 3);

    public static final Quartet<Integer, Integer, Integer, Integer> RES_QUARTET = Quartet.with(1,
            2, 3, 4);

    public static final Quintet<Integer, Integer, Integer, Integer, Integer> RES_QUINTET = Quintet
            .with(1, 2, 3, 4, 5);

    public static final Sextet<Integer, Integer, Integer, Integer, Integer, Integer> RES_SEXTET = Sextet
            .with(1, 2, 3, 4, 5, 6);

    public static final Septet<Integer, Integer, Integer, Integer, Integer, Integer, Integer> RES_SEPTET = Septet
            .with(1, 2, 3, 4, 5, 6, 7);

    public static final Octet<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> RES_OCTET = Octet
            .with(1, 2, 3, 4, 5, 6, 7, 8);

    private static final Observable<Integer> RANGE = Observable.range(1, 10);

    private static final Observable<Octet<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>> ZIP_RANGE = RANGE
            .zipWith(RANGE, RxTuples.<Integer, Integer> toPair())
            .zipWith(RANGE, RxTuples.<Integer, Integer, Integer> toTripletFromPair())
            .zipWith(RANGE, RxTuples.<Integer, Integer, Integer, Integer> toQuartetFromTriplet())
            .zipWith(RANGE,
                    RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintetFromQuartet())
            .zipWith(
                    RANGE,
                    RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextetFromQuintet())
            .zipWith(
                    RANGE,
                    RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptetFromSextet())
            .zipWith(
                    RANGE,
                    RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromSeptet());

    @Test
    public void testWarmup() throws Exception {
        Assert.assertEquals(true,
                ZIP_RANGE.blockingFirst().equals(Octet.with(1, 1, 1, 1, 1, 1, 1, 1)));
        Assert.assertEquals(true,
                ZIP_RANGE.blockingLast().equals(Octet.with(10, 10, 10, 10, 10, 10, 10, 10)));
        Assert.assertEquals(
                true,
                Observable
                        .combineLatest(Observable.just(1), Observable.just(2), Observable.just(3),
                                Observable.just(4),
                                RxTuples.<Integer, Integer, Integer, Integer> toQuartet())
                        .blockingFirst().equals(RES_QUARTET));
    }

    @Test
    public void testToPair() throws Exception {
        Assert.assertEquals(true, RxTuples.toPair().apply(1, 2).equals(RES_PAIR));
    }

    @Test
    public void testToTriplet() throws Exception {
        Assert.assertEquals(true, RxTuples.<Integer, Integer, Integer> toTriplet().apply(1, 2, 3)
                .equals(RES_TRIPLET));
        Assert.assertEquals(true,
                RxTuples.<Integer, Integer, Integer> toTripletFromPair().apply(Pair.with(1, 2), 3)
                        .equals(RES_TRIPLET));
        Assert.assertEquals(true,
                RxTuples.<Integer, Integer, Integer> toTripletFromSingle().apply(1, Pair.with(2, 3))
                        .equals(RES_TRIPLET));
    }

    @Test
    public void testToQuartet() throws Exception {
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer> toQuartet().apply(1, 2, 3, 4)
                        .equals(RES_QUARTET));
        Assert.assertEquals(true, RxTuples
                .<Integer, Integer, Integer, Integer> toQuartetFromTriplet().apply(RES_TRIPLET, 4)
                .equals(RES_QUARTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer> toQuartetFromSingle()
                        .apply(1, Triplet.with(2, 3, 4)).equals(RES_QUARTET));
        Assert.assertEquals(true, RxTuples.<Integer, Integer, Integer, Integer> toQuartetFromPair()
                .apply(Pair.with(1, 2), Pair.with(3, 4)).equals(RES_QUARTET));
    }

    @Test
    public void testToQuintet() throws Exception {
        Assert.assertEquals(true, RxTuples
                .<Integer, Integer, Integer, Integer, Integer> toQuintet().apply(1, 2, 3, 4, 5)
                .equals(RES_QUINTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintetFromQuartet()
                        .apply(RES_QUARTET, 5).equals(RES_QUINTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintetFromSingle()
                        .apply(1, Quartet.with(2, 3, 4, 5)).equals(RES_QUINTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintetFromTriplet()
                        .apply(Triplet.with(1, 2, 3), Pair.with(4, 5)).equals(RES_QUINTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer> toQuintetFromPair()
                        .apply(Pair.with(1, 2), Triplet.with(3, 4, 5)).equals(RES_QUINTET));
    }

    @Test
    public void testToSextet() throws Exception {
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextet()
                        .apply(1, 2, 3, 4, 5, 6).equals(RES_SEXTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextetFromQuintet()
                        .apply(RES_QUINTET, 6).equals(RES_SEXTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextetFromSingle()
                        .apply(1, Quintet.with(2, 3, 4, 5, 6)).equals(RES_SEXTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextetFromQuartet()
                        .apply(Quartet.with(1, 2, 3, 4), Pair.with(5, 6)).equals(RES_SEXTET));
        Assert.assertEquals(true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextetFromPair()
                        .apply(Pair.with(1, 2), Quartet.with(3, 4, 5, 6)).equals(RES_SEXTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer> toSextetFromTriplet()
                        .apply(Triplet.with(1, 2, 3), Triplet.with(4, 5, 6)).equals(RES_SEXTET));
    }

    @Test
    public void testToSeptet() throws Exception {
        Assert.assertEquals(true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptet()
                        .apply(1, 2, 3, 4, 5, 6, 7).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptetFromSextet()
                        .apply(RES_SEXTET, 7).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptetFromSingle()
                        .apply(1, Sextet.with(2, 3, 4, 5, 6, 7)).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptetFromQuintet()
                        .apply(Quintet.with(1, 2, 3, 4, 5), Pair.with(6, 7)).equals(RES_SEPTET));
        Assert.assertEquals(true, RxTuples
                .<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptetFromPair()
                .apply(Pair.with(1, 2), Quintet.with(3, 4, 5, 6, 7)).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptetFromQuartet()
                        .apply(Quartet.with(1, 2, 3, 4), Triplet.with(5, 6, 7)).equals(RES_SEPTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer> toSeptetFromTriplet()
                        .apply(Triplet.with(1, 2, 3), Quartet.with(4, 5, 6, 7)).equals(RES_SEPTET));
    }

    @Test
    public void testToOctet() throws Exception {
        Assert.assertEquals(true, RxTuples
                .<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctet()
                .apply(1, 2, 3, 4, 5, 6, 7, 8).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromSeptet()
                        .apply(RES_SEPTET, 8).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromSingle()
                        .apply(1, Septet.with(2, 3, 4, 5, 6, 7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromSextet()
                        .apply(Sextet.with(1, 2, 3, 4, 5, 6), Pair.with(7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromPair()
                        .apply(Pair.with(1, 2), Sextet.with(3, 4, 5, 6, 7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromQuintet()
                        .apply(Quintet.with(1, 2, 3, 4, 5), Triplet.with(6, 7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromTriplet()
                        .apply(Triplet.with(1, 2, 3), Quintet.with(4, 5, 6, 7, 8)).equals(RES_OCTET));
        Assert.assertEquals(
                true,
                RxTuples.<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> toOctetFromQuartet()
                        .apply(Quartet.with(1, 2, 3, 4), Quartet.with(5, 6, 7, 8)).equals(RES_OCTET));
    }
}
