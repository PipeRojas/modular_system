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
public class User {

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
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the Selection
     */
    public String getSelection() {
        return Selection;
    }

    /**
     * @param Selection the Selection to set
     */
    public void setSelection(String Selection) {
        this.Selection = Selection;
    }
    private String name;
    private String text;
    private String Selection;
}
