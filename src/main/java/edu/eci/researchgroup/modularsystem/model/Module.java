/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Julian David devia Serna
 */
public class Module {

    /**
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    public Module(){
        remarks = new ArrayList<>();
        initialDate =  new Date();
    }

    /**
     * @return the start
     */
    public Start getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Start start) {
        this.start = start;
    }

    /**
     * @return the development
     */
    public Development getDevelopment() {
        return development;
    }

    /**
     * @param development the development to set
     */
    public void setDevelopment(Development development) {
        this.development = development;
    }

    /**
     * @return the end
     */
    public End getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(End end) {
        this.end = end;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the iteration
     */
    public boolean isIteration() {
        return iteration;
    }

    /**
     * @param iteration the iteration to set
     */
    public void setIteration(boolean iteration) {
        this.iteration = iteration;
    }

    /**
     * @return the initialDate
     */
    public Date getInitialDate() {
        return initialDate;
    }

    /**
     * @param initialDate the initialDate to set
     */
    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    /**
     * @return the remarks
     */
    public List<String> getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(List<String> remarks) {
        this.remarks = remarks;
    }
    private String name;
    private User owner;
    private boolean iteration;
    private Date initialDate;
    private List<String> remarks;
    private Start start;
    private Development development;
    private End end;
}