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
 * @author Julian David Devia Serna
 */
public class Start {

    public Start() {
        documents = new ArrayList<>();
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
     * @return the frequency
     */
    public boolean isFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(boolean frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the estimateDate
     */
    public Date getEstimateDate() {
        return estimateDate;
    }

    /**
     * @param estimateDate the estimateDate to set
     */
    public void setEstimateDate(Date estimateDate) {
        this.estimateDate = estimateDate;
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

    private String text;
    private String selection;
    private boolean frequency;
    private Date estimateDate;
    private List<String> documents;
    
    /**
     * adds a new document's uri
     * @param uri the document's uri to add
     */
    public void addDocument(String uri){
        documents.add(uri);
    }
    
    @Override
    public boolean equals(Object o){
        Start other=(Start) o;
        return this.getText().equals(other.getText()) && this.getSelection().equals(other.getSelection()) &&
                this.isFrequency()==other.isFrequency() && this.getEstimateDate().equals(other.getEstimateDate()) &&
                this.getDocuments().equals(other.getDocuments());
    }
}
