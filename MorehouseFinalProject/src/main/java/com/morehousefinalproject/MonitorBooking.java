package com.morehousefinalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class MonitorBooking {

    public boolean validateDB(Connection conn, String location, String start_Time, String end_Time, String date) {

        String dbLoc;
        String dbDate;
        double dbend;
        double startTime;

        Statement stmt = null;

        try {

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM StudyRoomBooking;");

            //do not allow starttime to be later than endtime                          
            startTime = convertTimeStringToFloat(start_Time);
            if (LocalTime.parse(start_Time).isAfter(LocalTime.parse(end_Time))) {
                return false;
            }
            //do not allow passed time to be entered into database
            boolean flg = hasEnteredDatePassed(date, startTime);
            if (flg == true) {
                return false;
            }
            while (rs.next()) {

                dbLoc = rs.getString("Location");
                dbDate = rs.getString("Date");

                dbend = convertTimeStringToFloat(rs.getString("EndTime"));

                //
                //check if row should be deleted
                int dbyear = Integer.parseInt(dbDate.substring(0, 4));
                int dbmonth = Integer.parseInt(dbDate.substring(5, 7));
                int dbday = Integer.parseInt(dbDate.substring(8, 10));

                boolean del = false;
                if (getCurrentyear() > dbyear) {
                    del = true;
                }
                if ((getCurrentyear() == dbyear) && (getCurrentmonth() > dbmonth)) {
                    del = true;
                }
                if ((getCurrentyear() == dbyear) && (getCurrentmonth() == dbmonth) && (getCurrentday() >= dbday)) {
                    del = true;
                }

                if ((getSystemTime() >= dbend) && (del == true)) {
                    //remove row.

                    PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM StudyRoomBooking WHERE EndTime=? and StartTime=?");

                    preparedStatement.setString(1, rs.getString("EndTime"));
                    preparedStatement.setString(2, rs.getString("StartTime"));
                    preparedStatement.executeUpdate();

                }

                //Check to see if new booked room is in conflick with existing 
                if ((dbLoc.equals(location) == true) && (date.equals(dbDate) == true)) {
                    //return (s1 < e2) && (e1 > s2);  - start and end
                    LocalTime startTimeEntered = LocalTime.parse(start_Time); //S2
                    LocalTime endTimeEntered = LocalTime.parse(end_Time);    //E2
                    LocalTime startTimeDataBase = LocalTime.parse(rs.getString("StartTime")); //S1
                    LocalTime endTimeDataBase = LocalTime.parse(rs.getString("EndTime"));     //E1

                    if (startTimeDataBase.isBefore(endTimeEntered) && endTimeDataBase.isAfter(startTimeEntered)) {
                        return false;
                    }
                }
            }//move to next record

        } catch (SQLException ex) {
            Logger.getLogger(NewBookingController.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;
    }

    //Helper functions
    public double convertTimeStringToFloat(String time) {
        double value;

        String st = time.replace(':', '.');
        value = Double.parseDouble(st);

        return value;
    }

    public double getSystemTime() {
        int ttm;
        int tth;
        double dd;
        Calendar cal = Calendar.getInstance();
        tth = cal.get(Calendar.HOUR_OF_DAY);
        ttm = cal.get(Calendar.MINUTE);

        System.out.println(tth + "." + ttm);
        if (ttm < 10) {
            dd = (Double.parseDouble(tth + ".0" + ttm));
        } else {
            dd = (Double.parseDouble(tth + "." + ttm));
        }
        System.out.println(dd);
        return dd;
    }

    public int getCurrentyear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    public int getCurrentmonth() {
        Calendar cal = Calendar.getInstance();
        int mm = (cal.get(Calendar.MONTH)) + 1;
        return mm;
    }

    public int getCurrentday() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public boolean hasEnteredDatePassed(String date, double EnteredStartTime) {

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        double sysTime = getSystemTime();

        if (getCurrentyear() > year) {
            return true;  //yes current entered day has passed
        }
        if ((getCurrentyear() >= year) && (getCurrentmonth() > month)) {
            return true;  //yes current entered day has passed
        }
        if ((getCurrentyear() >= year) && (getCurrentmonth() >= month) && getCurrentday() > day) {
            return true;  //yes current entered day has passed
        }
        if ((getCurrentyear() >= year) && (getCurrentmonth() >= month) && (getCurrentday() >= day) && (sysTime > EnteredStartTime)) {
            return true;  //yes current entered day has passed
        }
        return false;
    }

}
