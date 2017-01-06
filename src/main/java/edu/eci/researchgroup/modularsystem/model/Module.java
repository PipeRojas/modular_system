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
     * Returns the owner of the module
     *
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the module
     *
     * @param owner the owner to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Module() {
        remarks = new ArrayList<>();
        initialDate = new Date();
    }

    /**
     * Returns the start of the module
     *
     * @return the start
     */
    public Start getStart() {
        return start;
    }

    /**
     * Sets the start of the module
     *
     * @param start the start to set
     */
    public void setStart(Start start) {
        this.start = start;
    }

    /**
     * Returns the development of the module
     *
     * @return the development
     */
    public Development getDevelopment() {
        return development;
    }

    /**
     * Sets the development of the module
     *
     * @param development the development to set
     */
    public void setDevelopment(Development development) {
        this.development = development;
    }

    /**
     * Returns the end of the module
     *
     * @return the end
     */
    public End getEnd() {
        return end;
    }

    /**
     * Sets the end of the module
     *
     * @param end the end to set
     */
    public void setEnd(End end) {
        this.end = end;
    }

    /**
     * Returns the name of the module
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the module
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns if the module is set to iterate
     *
     * @return the iteration
     */
    public boolean isIteration() {
        return iteration;
    }

    /**
     * Sets if the module is set to iterate
     *
     * @param iteration the iteration to set
     */
    public void setIteration(boolean iteration) {
        this.iteration = iteration;
    }

    /**
     * Returns the initialDate of the module
     *
     * @return the initialDate
     */
    public Date getInitialDate() {
        return initialDate;
    }

    /**
     * Sets the initialDate of the module
     *
     * @param initialDate the initialDate to set
     */
    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    /**
     * Returns the remarks of the module
     *
     * @return the remarks
     */
    public List<String> getRemarks() {
        return remarks;
    }

    /**
     * Sets the remarks of the module
     *
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

    /**
     * Adds a new remark to the module
     *
     * @param remark the remark to add
     */
    public void addRemark(String remark) {
        remarks.add(remark);
    }

    /**
     * Adds a new document's uri to the start phase
     *
     * @param uri the document's uri to add
     */
    public void addStartDocument(String uri) {
        start.addDocument(uri);
    }

    /**
     * Adds a new sub-module to the development phase
     *
     * @param subModule the module to add
     */
    public void addSubModule(Module subModule) {
        development.addSubModule(subModule);
    }

    /**
     * Adds a new document's uri to the development phase
     *
     * @param uri the document's uri to add
     */
    public void addDevelopmentDocument(String uri) {
        development.addDocument(uri);
    }

    public boolean hasSubModule(Module subModule) {
        return development.hasSubModule(subModule);
    }

    @Override
    public boolean equals(Object o) {
        Module other = (Module) o;
        return this.getName().equals(other.getName()) && this.getOwner().equals(other.getOwner())
                && this.isIteration() == other.isIteration() && this.getInitialDate().equals(other.getInitialDate())
                && this.getRemarks().equals(other.getRemarks()) && this.getStart().equals(other.getStart())
                && this.getDevelopment().equals(other.getDevelopment()) && this.getEnd().equals(other.getEnd());
    }

    @Override
    public String toString() {
        return name + "\n\t" + development.toString();
    }
}
