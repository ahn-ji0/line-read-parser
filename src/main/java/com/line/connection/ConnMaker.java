package com.line.connection;

import java.sql.SQLException;

public interface ConnMaker {
    java.sql.Connection connect() throws ClassNotFoundException, SQLException;
}
