/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morehousefinalproject;
import org.springframework.data.repository.CrudRepository;
import com.morehousefinalproject.UserModel;
/**
 *
 * @author Brian Morehouse
 */
public interface UserRepo extends CrudRepository<UserModel, Long> {
    
}
