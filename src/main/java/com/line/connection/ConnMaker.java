package com.line.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnMaker {
    Connection connect() throws ClassNotFoundException, SQLException;
}
