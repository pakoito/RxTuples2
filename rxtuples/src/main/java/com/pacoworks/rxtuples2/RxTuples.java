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

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;

/**
 * Helper class to create Tuples
 *
 * @author pakoito
 */
public final class RxTuples {
    private RxTuples() {
        // No instances
    }

    // region Pair

    public static <T, U> BiFunction<T, U, Pair<T, U>> toPair() {
        return new BiFunction<T, U, Pair<T, U>>() {
            @Override
            public Pair<T, U> apply(T t, U t2) {
                return Pair.with(t, t2);
            }
        };
    }

    // endregion

    // region Triplet
    public static <A, B, C> Function3<A, B, C, Triplet<A, B, C>> toTriplet() {
        return new Function3<A, B, C, Triplet<A, B, C>>() {
            @Override
            public Triplet<A, B, C> apply(A a, B b, C c) {
                return Triplet.with(a, b, c);
            }
        };
    }

    public static <A, B, T> io.reactivex.functions.BiFunction<T, Pair<A, B>, Triplet<T, A, B>> toTripletFromSingle() {
        return new BiFunction<T, Pair<A, B>, Triplet<T, A, B>>() {
            @Override
            public Triplet<T, A, B> apply(T t, Pair<A, B> objects) {
                return Triplet.with(t, objects.getValue0(), objects.getValue1());
            }
        };
    }

    public static <A, B, T> BiFunction<Pair<A, B>, T, Triplet<A, B, T>> toTripletFromPair() {
        return new BiFunction<Pair<A, B>, T, Triplet<A, B, T>>() {
            @Override
            public Triplet<A, B, T> apply(Pair<A, B> objects, T t) {
                return Triplet.with(objects.getValue0(), objects.getValue1(), t);
            }
        };
    }

    // endregion

    // region Quartet

    public static <A, B, C, D> Function4<A, B, C, D, Quartet<A, B, C, D>> toQuartet() {
        return new Function4<A, B, C, D, Quartet<A, B, C, D>>() {
            @Override
            public Quartet<A, B, C, D> apply(A a, B b, C c, D d) {
                return Quartet.with(a, b, c, d);
            }
        };
    }

    public static <A, B, C, T> BiFunction<T, Triplet<A, B, C>, Quartet<T, A, B, C>> toQuartetFromSingle() {
        return new BiFunction<T, Triplet<A, B, C>, Quartet<T, A, B, C>>() {
            @Override
            public Quartet<T, A, B, C> apply(T t, Triplet<A, B, C> objects) {
                return Quartet.with(t, objects.getValue0(), objects.getValue1(),
                        objects.getValue2());
            }
        };
    }

    public static <A, B, C, D> BiFunction<Pair<A, B>, Pair<C, D>, Quartet<A, B, C, D>> toQuartetFromPair() {
        return new BiFunction<Pair<A, B>, Pair<C, D>, Quartet<A, B, C, D>>() {
            @Override
            public Quartet<A, B, C, D> apply(Pair<A, B> objects, Pair<C, D> objects2) {
                return Quartet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1());
            }
        };
    }

    public static <A, B, C, T> BiFunction<Triplet<A, B, C>, T, Quartet<A, B, C, T>> toQuartetFromTriplet() {
        return new BiFunction<Triplet<A, B, C>, T, Quartet<A, B, C, T>>() {
            @Override
            public Quartet<A, B, C, T> apply(Triplet<A, B, C> objects, T t) {
                return Quartet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        t);
            }
        };
    }

    // endregion

    // region Quintet

    public static <A, B, C, D, E> Function5<A, B, C, D, E, Quintet<A, B, C, D, E>> toQuintet() {
        return new Function5<A, B, C, D, E, Quintet<A, B, C, D, E>>() {
            @Override
            public Quintet<A, B, C, D, E> apply(A a, B b, C c, D d, E e) {
                return Quintet.with(a, b, c, d, e);
            }
        };
    }

    public static <A, B, C, D, T> BiFunction<T, Quartet<A, B, C, D>, Quintet<T, A, B, C, D>> toQuintetFromSingle() {
        return new BiFunction<T, Quartet<A, B, C, D>, Quintet<T, A, B, C, D>>() {
            @Override
            public Quintet<T, A, B, C, D> apply(T t, Quartet<A, B, C, D> objects) {
                return Quintet.with(t, objects.getValue0(), objects.getValue1(),
                        objects.getValue2(), objects.getValue3());
            }
        };
    }

    public static <A, B, C, D, E> BiFunction<Pair<A, B>, Triplet<C, D, E>, Quintet<A, B, C, D, E>> toQuintetFromPair() {
        return new BiFunction<Pair<A, B>, Triplet<C, D, E>, Quintet<A, B, C, D, E>>() {
            @Override
            public Quintet<A, B, C, D, E> apply(Pair<A, B> objects, Triplet<C, D, E> objects2) {
                return Quintet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2());
            }
        };
    }

    public static <A, B, C, D, E> BiFunction<Triplet<A, B, C>, Pair<D, E>, Quintet<A, B, C, D, E>> toQuintetFromTriplet() {
        return new BiFunction<Triplet<A, B, C>, Pair<D, E>, Quintet<A, B, C, D, E>>() {
            @Override
            public Quintet<A, B, C, D, E> apply(Triplet<A, B, C> objects, Pair<D, E> objects2) {
                return Quintet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects2.getValue0(), objects2.getValue1());
            }
        };
    }

    public static <A, B, C, D, T> BiFunction<Quartet<A, B, C, D>, T, Quintet<A, B, C, D, T>> toQuintetFromQuartet() {
        return new BiFunction<Quartet<A, B, C, D>, T, Quintet<A, B, C, D, T>>() {
            @Override
            public Quintet<A, B, C, D, T> apply(Quartet<A, B, C, D> objects, T t) {
                return Quintet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), t);
            }
        };
    }

    // endregion

    // region Sextet

    public static <A, B, C, D, E, F> Function6<A, B, C, D, E, F, Sextet<A, B, C, D, E, F>> toSextet() {
        return new Function6<A, B, C, D, E, F, Sextet<A, B, C, D, E, F>>() {
            @Override
            public Sextet<A, B, C, D, E, F> apply(A a, B b, C c, D d, E e, F f) {
                return Sextet.with(a, b, c, d, e, f);
            }
        };
    }

    public static <A, B, C, D, E, T> BiFunction<T, Quintet<A, B, C, D, E>, Sextet<T, A, B, C, D, E>> toSextetFromSingle() {
        return new BiFunction<T, Quintet<A, B, C, D, E>, Sextet<T, A, B, C, D, E>>() {
            @Override
            public Sextet<T, A, B, C, D, E> apply(T t, Quintet<A, B, C, D, E> objects) {
                return Sextet.with(t, objects.getValue0(), objects.getValue1(),
                        objects.getValue2(), objects.getValue3(), objects.getValue4());
            }
        };
    }

    public static <A, B, C, D, E, F> BiFunction<Pair<A, B>, Quartet<C, D, E, F>, Sextet<A, B, C, D, E, F>> toSextetFromPair() {
        return new BiFunction<Pair<A, B>, Quartet<C, D, E, F>, Sextet<A, B, C, D, E, F>>() {
            @Override
            public Sextet<A, B, C, D, E, F> apply(Pair<A, B> objects, Quartet<C, D, E, F> objects2) {
                return Sextet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2(), objects2.getValue3());
            }
        };
    }

    public static <A, B, C, D, E, F> BiFunction<Triplet<A, B, C>, Triplet<D, E, F>, Sextet<A, B, C, D, E, F>> toSextetFromTriplet() {
        return new BiFunction<Triplet<A, B, C>, Triplet<D, E, F>, Sextet<A, B, C, D, E, F>>() {
            @Override
            public Sextet<A, B, C, D, E, F> apply(Triplet<A, B, C> objects, Triplet<D, E, F> objects2) {
                return Sextet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects2.getValue0(), objects2.getValue1(), objects2.getValue2());
            }
        };
    }

    public static <A, B, C, D, E, F> BiFunction<Quartet<A, B, C, D>, Pair<E, F>, Sextet<A, B, C, D, E, F>> toSextetFromQuartet() {
        return new BiFunction<Quartet<A, B, C, D>, Pair<E, F>, Sextet<A, B, C, D, E, F>>() {
            @Override
            public Sextet<A, B, C, D, E, F> apply(Quartet<A, B, C, D> objects, Pair<E, F> objects2) {
                return Sextet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects2.getValue0(), objects2.getValue1());
            }
        };
    }

    public static <A, B, C, D, E, T> BiFunction<Quintet<A, B, C, D, E>, T, Sextet<A, B, C, D, E, T>> toSextetFromQuintet() {
        return new BiFunction<Quintet<A, B, C, D, E>, T, Sextet<A, B, C, D, E, T>>() {
            @Override
            public Sextet<A, B, C, D, E, T> apply(Quintet<A, B, C, D, E> objects, T t) {
                return Sextet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), t);
            }
        };
    }

    // endregion

    // region Septet

    public static <A, B, C, D, E, F, G> Function7<A, B, C, D, E, F, G, Septet<A, B, C, D, E, F, G>> toSeptet() {
        return new Function7<A, B, C, D, E, F, G, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> apply(A a, B b, C c, D d, E e, F f, G g) {
                return Septet.with(a, b, c, d, e, f, g);
            }
        };
    }

    public static <A, B, C, D, E, F, T> BiFunction<T, Sextet<A, B, C, D, E, F>, Septet<T, A, B, C, D, E, F>> toSeptetFromSingle() {
        return new BiFunction<T, Sextet<A, B, C, D, E, F>, Septet<T, A, B, C, D, E, F>>() {
            @Override
            public Septet<T, A, B, C, D, E, F> apply(T t, Sextet<A, B, C, D, E, F> objects) {
                return Septet.with(t, objects.getValue0(), objects.getValue1(),
                        objects.getValue2(), objects.getValue3(), objects.getValue4(),
                        objects.getValue5());
            }
        };
    }

    public static <A, B, C, D, E, F, G> BiFunction<Pair<A, B>, Quintet<C, D, E, F, G>, Septet<A, B, C, D, E, F, G>> toSeptetFromPair() {
        return new BiFunction<Pair<A, B>, Quintet<C, D, E, F, G>, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> apply(Pair<A, B> objects,
                                                    Quintet<C, D, E, F, G> objects2) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2(), objects2.getValue3(),
                        objects2.getValue4());
            }
        };
    }

    public static <A, B, C, D, E, F, G> BiFunction<Triplet<A, B, C>, Quartet<D, E, F, G>, Septet<A, B, C, D, E, F, G>> toSeptetFromTriplet() {
        return new BiFunction<Triplet<A, B, C>, Quartet<D, E, F, G>, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> apply(Triplet<A, B, C> objects,
                                                    Quartet<D, E, F, G> objects2) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects2.getValue0(), objects2.getValue1(), objects2.getValue2(),
                        objects2.getValue3());
            }
        };
    }

    public static <A, B, C, D, E, F, G> BiFunction<Quartet<A, B, C, D>, Triplet<E, F, G>, Septet<A, B, C, D, E, F, G>> toSeptetFromQuartet() {
        return new BiFunction<Quartet<A, B, C, D>, Triplet<E, F, G>, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> apply(Quartet<A, B, C, D> objects,
                                                    Triplet<E, F, G> objects2) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects2.getValue0(), objects2.getValue1(),
                        objects2.getValue2());
            }
        };
    }

    public static <A, B, C, D, E, F, G> BiFunction<Quintet<A, B, C, D, E>, Pair<F, G>, Septet<A, B, C, D, E, F, G>> toSeptetFromQuintet() {
        return new BiFunction<Quintet<A, B, C, D, E>, Pair<F, G>, Septet<A, B, C, D, E, F, G>>() {
            @Override
            public Septet<A, B, C, D, E, F, G> apply(Quintet<A, B, C, D, E> objects,
                                                    Pair<F, G> objects2) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects2.getValue0(),
                        objects2.getValue1());
            }
        };
    }

    public static <A, B, C, D, E, F, T> BiFunction<Sextet<A, B, C, D, E, F>, T, Septet<A, B, C, D, E, F, T>> toSeptetFromSextet() {
        return new BiFunction<Sextet<A, B, C, D, E, F>, T, Septet<A, B, C, D, E, F, T>>() {
            @Override
            public Septet<A, B, C, D, E, F, T> apply(Sextet<A, B, C, D, E, F> objects, T t) {
                return Septet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects.getValue5(), t);
            }
        };
    }

    // endregion

    // region Octet

    public static <A, B, C, D, E, F, G, H> Function8<A, B, C, D, E, F, G, H, Octet<A, B, C, D, E, F, G, H>> toOctet() {
        return new Function8<A, B, C, D, E, F, G, H, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> apply(A a, B b, C c, D d, E e, F f, G g, H h) {
                return Octet.with(a, b, c, d, e, f, g, h);
            }
        };
    }


    public static <A, B, C, D, E, F, G, T> BiFunction<T, Septet<A, B, C, D, E, F, G>, Octet<T, A, B, C, D, E, F, G>> toOctetFromSingle() {
        return new BiFunction<T, Septet<A, B, C, D, E, F, G>, Octet<T, A, B, C, D, E, F, G>>() {
            @Override
            public Octet<T, A, B, C, D, E, F, G> apply(T t, Septet<A, B, C, D, E, F, G> objects) {
                return Octet.with(t, objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects.getValue5(),
                        objects.getValue6());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> BiFunction<Pair<A, B>, Sextet<C, D, E, F, G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromPair() {
        return new BiFunction<Pair<A, B>, Sextet<C, D, E, F, G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> apply(Pair<A, B> objects,
                                                      Sextet<C, D, E, F, G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2(), objects2.getValue3(),
                        objects2.getValue4(), objects2.getValue5());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> BiFunction<Triplet<A, B, C>, Quintet<D, E, F, G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromTriplet() {
        return new BiFunction<Triplet<A, B, C>, Quintet<D, E, F, G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> apply(Triplet<A, B, C> objects,
                                                      Quintet<D, E, F, G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects2.getValue0(), objects2.getValue1(), objects2.getValue2(),
                        objects2.getValue3(), objects2.getValue4());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> BiFunction<Quartet<A, B, C, D>, Quartet<E, F, G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromQuartet() {
        return new BiFunction<Quartet<A, B, C, D>, Quartet<E, F, G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> apply(Quartet<A, B, C, D> objects,
                                                      Quartet<E, F, G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects2.getValue0(), objects2.getValue1(),
                        objects2.getValue2(), objects2.getValue3());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> BiFunction<Quintet<A, B, C, D, E>, Triplet<F, G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromQuintet() {
        return new BiFunction<Quintet<A, B, C, D, E>, Triplet<F, G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> apply(Quintet<A, B, C, D, E> objects,
                                                      Triplet<F, G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects2.getValue0(),
                        objects2.getValue1(), objects2.getValue2());
            }
        };
    }

    public static <A, B, C, D, E, F, G, H> BiFunction<Sextet<A, B, C, D, E, F>, Pair<G, H>, Octet<A, B, C, D, E, F, G, H>> toOctetFromSextet() {
        return new BiFunction<Sextet<A, B, C, D, E, F>, Pair<G, H>, Octet<A, B, C, D, E, F, G, H>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, H> apply(Sextet<A, B, C, D, E, F> objects,
                                                      Pair<G, H> objects2) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects.getValue5(),
                        objects2.getValue0(), objects2.getValue1());
            }
        };
    }

    public static <A, B, C, D, E, F, G, T> BiFunction<Septet<A, B, C, D, E, F, G>, T, Octet<A, B, C, D, E, F, G, T>> toOctetFromSeptet() {
        return new BiFunction<Septet<A, B, C, D, E, F, G>, T, Octet<A, B, C, D, E, F, G, T>>() {
            @Override
            public Octet<A, B, C, D, E, F, G, T> apply(Septet<A, B, C, D, E, F, G> objects, T t) {
                return Octet.with(objects.getValue0(), objects.getValue1(), objects.getValue2(),
                        objects.getValue3(), objects.getValue4(), objects.getValue5(),
                        objects.getValue6(), t);
            }
        };
    }

    // endregion
}
