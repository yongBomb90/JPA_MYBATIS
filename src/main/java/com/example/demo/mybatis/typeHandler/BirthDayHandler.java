package com.example.demo.mybatis.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;
import java.text.SimpleDateFormat;

@MappedJdbcTypes(JdbcType.DATE)
public class BirthDayHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        // set 할때 콜
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 리절트 셋에서 가져올때 콜
        Date temp = rs.getDate(columnName);
        if ( temp == null ) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-**-dd");
        String birthDay =  formatter.format(temp);
        return birthDay;
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
