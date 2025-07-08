package com.example.stumanagement.util;

import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Time;

public class utildata {
    //generate respective IDs
    public static String generatestuId()
    {
        return "s/"+UUID.randomUUID();
    }
    public static String generatestaffId()
    {
        return "st/"+ UUID.randomUUID();
    }
    public static String courseId()
    {
        return "c/"+ UUID.randomUUID();
    }

}
