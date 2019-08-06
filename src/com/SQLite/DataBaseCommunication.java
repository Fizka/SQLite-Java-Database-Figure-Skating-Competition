package com.SQLite;

import java.sql.Connection;
import java.sql.Statement;

public interface DataBaseCommunication {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:figure_skating_competition.db";

}
