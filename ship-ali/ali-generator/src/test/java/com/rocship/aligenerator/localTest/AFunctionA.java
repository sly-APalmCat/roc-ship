package com.rocship.aligenerator.localTest;

import java.io.Serializable;
import java.util.function.Function;

@FunctionalInterface
public interface AFunctionA<T,R> extends Function<T,R>,Serializable {}