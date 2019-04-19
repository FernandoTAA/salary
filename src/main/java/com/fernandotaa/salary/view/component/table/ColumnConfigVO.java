package com.fernandotaa.salary.view.component.table;

import java.util.function.Function;

/**
 * Value object for column configuration to be used in {@link TableModel}
 */
class ColumnConfigVO<T> {

    public String header;
    public Function<T, ?> getter;

    public ColumnConfigVO(String header, Function<T, ?> getter) {
        this.header = header;
        this.getter = getter;
    }

    public String getHeader() {
        return header;
    }

    public Function<T, ?> getGetter() {
        return getter;
    }
}
