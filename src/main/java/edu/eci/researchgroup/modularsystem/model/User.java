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
     * Returns the name of the user
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name od the user
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the text of the user
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the user
     *
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the selection of the user
     *
     * @return the selection
     */
    public String getSelection() {
        return selection;
    }

    /**
     * Sets the selection of the user
     *
     * @param Selection the selection to set
     */
    public void setSelection(String Selection) {
        this.selection = Selection;
    }
    private String name;
    private String text;
    private String selection;

    @Override
    public boolean equals(Object o) {
        User other = (User) o;
        return this.getName().equals(other.getName()) && this.getText().equals(other.getText()) && this.getSelection().equals(other.getSelection());
    }
}
