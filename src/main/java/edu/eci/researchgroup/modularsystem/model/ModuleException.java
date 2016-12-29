/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.model;

/**
 *
 * @author Julian David Devia Serna
 */
public class ModuleException  extends Exception{
    /**
     *
     * @param message the message of the exception
     * @param cause the cause to throw the exception
     */
    public ModuleException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param message the message of the exception
     */
    public ModuleException(String message) {
        super(message);
    }
    
}
