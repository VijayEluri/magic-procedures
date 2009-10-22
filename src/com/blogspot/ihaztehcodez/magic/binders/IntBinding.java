package com.blogspot.ihaztehcodez.magic.binders;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.blogspot.ihaztehcodez.magic.Binding;

public class IntBinding implements Binding {

	@Override
	public Object getValue(CallableStatement statement, int index) throws SQLException {
		int value = statement.getInt(index);
		if (statement.wasNull()) {
			return null;
		} else {
			return Integer.valueOf(value);
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
			statement.setInt(index, ((Integer)value).intValue());
		}
	}

	@Override
	public Class<?>[] worksWith() {
		return new Class<?>[] { Integer.class };
	}

}