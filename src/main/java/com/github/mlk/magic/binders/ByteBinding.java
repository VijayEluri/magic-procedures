package com.github.mlk.magic.binders;

import com.github.mlk.magic.Binding;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class ByteBinding implements Binding {

    @Override
    public Object getValue(CallableStatement statement, int index) throws SQLException {
        byte value = statement.getByte(index);
        if (statement.wasNull()) {
            return null;
        } else {
            return value;
        }
    }

    @Override
    public void prepareGet(CallableStatement statement, int index) throws SQLException {
        statement.registerOutParameter(index, Types.INTEGER);
    }

    @Override
    public void setValue(CallableStatement statement, int index, Object value) throws SQLException {
        if (value == null) {
            statement.setNull(index, Types.INTEGER);
        } else {
            statement.setByte(index, (Byte) value);
        }
    }

    @Override
    public Class<?>[] worksWith() {
        return new Class<?>[]{Byte.class, byte.class};
    }

    @Override
    public int parameters() {
        return 1;
    }
}
