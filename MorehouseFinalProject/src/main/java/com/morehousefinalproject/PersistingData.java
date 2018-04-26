/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morehousefinalproject;

/**
 *
 * @author Brian Morehouse
 */
public class PersistingData {

    private String userEmail;
    private static PersistingData instance = null;

    public PersistingData() {
        // Exists only to defeat instantiation.
    }

    public static PersistingData getInstance() {
        if (instance == null) {
            instance = new PersistingData();
        }
        return instance;
    }

    public void StoreData(String userEmail) {

        this.userEmail = userEmail;

    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

}
