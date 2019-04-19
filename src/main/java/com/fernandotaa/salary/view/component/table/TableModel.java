package com.fernandotaa.salary.view.component.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Generic TableModel to use with any claass.
 *
 * @param <T> Type to be read and construct the table
 */
public class TableModel<T> extends AbstractTableModel {

    private List<T> rows = new ArrayList<>();
    private List<ColumnConfigVO<T>> columns = new ArrayList<>();

    @Override
    public String getColumnName(int columnIndex) {
        return columns.get(columnIndex).getHeader();
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return columns.get(columnIndex).getGetter().apply(rows.get(rowIndex));
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Add a new column to be used in a table
     *
     * @param header
     * @param getter
     */
    public void addColmun(String header, Function<T, ?> getter) {
        columns.add(new ColumnConfigVO<>(header, getter));
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
        fireTableDataChanged();
    }
}