/**
 * Copyright (C) <2019>  <chen junwen>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.mycat.proxy.packet;

/**
 * 结果集收集接口 int startIndex的含义应该是根据实际情况而定的
 *
 * @author jamie12221
 * @date 2019-05-10 13:21
 */
public interface ResultSetCollector {

    void onResultSetStart();

    void onResultSetEnd();

    void collectColumnList(ColumnDefPacket[] packets);

    void onRowStart();

    void onRowEnd();

    void collectDecimal(int columnIndex,ColumnDefPacket columnDef,int decimalScale, MySQLPacket mySQLPacket, int startIndex);

    void collectTiny(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectGeometry(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectTinyString(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectVarString(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectShort(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);


    void collectBlob(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);


    void collectMediumBlob(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectTinyBlob(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectFloat(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectDouble(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectNull(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectTimestamp(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);


    void collectInt24(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectDate(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectTime(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectDatetime(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectYear(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectNewDate(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectVarChar(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectBit(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectNewDecimal(int columnIndex,ColumnDefPacket columnDef,int decimalScale, MySQLPacket mySQLPacket, int startIndex);

    void collectEnum(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectSet(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectLong(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectLongLong(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);

    void collectLongBlob(int columnIndex,ColumnDefPacket columnDef, MySQLPacket mySQLPacket, int startIndex);
}
