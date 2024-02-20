package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                    // INSERT YOUR CODE HERE
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();

                    // Iterate over each row of the result set
                    while (rs.next()) {

                        JsonObject obj = new JsonObject();

                        for (int i = 1; i <= columnCount; i++) {
                            String columnName = rsmd.getColumnName(i);
                            Object columnValue = rs.getObject(i);


                                // Check for instances of known data types
                                 if (columnValue instanceof Integer) {
                                    obj.put(columnName, ((Integer) columnValue).intValue());
                                 }
                                 // if statement for time 
                                 
                                 
                                // Fallback to string 
                                else {
                                    obj.put(columnName, columnValue.toString());
                                }
                            }
                       records.add(obj);
                    }    
                }
            }   

        
            
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
