package edu.MyCollections;

import java.util.Collection;

public interface TestList<E> extends Collection<E> {
    @Override
    int size();

    @Override
    boolean isEmpty();

    @Override
    boolean add(E e);

    boolean add(int index, E e);
}
