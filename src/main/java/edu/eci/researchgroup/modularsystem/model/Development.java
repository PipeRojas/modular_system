/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian David Devia Serna
 */
public class Development {

    public Development() {
        documents = new ArrayList<>();
        subModules = new ArrayList<>();
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
     * @return the selection
     */
    public String getSelection() {
        return selection;
    }

    /**
     * @param selection the selection to set
     */
    public void setSelection(String selection) {
        this.selection = selection;
    }

    /**
     * @return the documents
     */
    public List<String> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    /**
     * @return the subModules
     */
    public List<Module> getSubModules() {
        return subModules;
    }

    /**
     * @param subModules the subModules to set
     */
    public void setSubModules(List<Module> subModules) {
        this.subModules = subModules;
    }
    private String text;
    private String selection;
    private List<String> documents;
    private List<Module> subModules;
    
    /**
     * adds a new sub-module
     * @param newMod the module to add
     */
    public void addSubModule(Module newMod){
        subModules.add(newMod);
    }
    
    /**
     * adds a new document's uri
     * @param uri the document's uri to add
     */
    public void addDocument(String uri){
        documents.add(uri);
    }
    
    public boolean hasSubModule(Module subModule){
        return subModules.contains(subModule);
    }
    
    @Override
    public boolean equals(Object o){
        Development other=(Development) o;
        return this.getText().equals(other.getText()) && this.getSelection().equals(other.getSelection()) &&
                this.getDocuments().equals(other.getDocuments()) && this.getSubModules().equals(other.getSubModules());
    }
    
    @Override
    public String toString(){
        return subModules.toString();
    }
}
