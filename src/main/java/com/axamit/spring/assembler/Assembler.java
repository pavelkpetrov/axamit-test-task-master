package com.axamit.spring.assembler;

import java.util.List;

/**
 * Created by Pavel on 30.10.2016.
 */
public interface Assembler<T,V> {
    V assemble(T source);
    List<V> assemble(List<T> source);
}
