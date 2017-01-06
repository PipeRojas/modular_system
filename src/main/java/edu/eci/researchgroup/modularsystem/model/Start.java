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
     * Returns the text of the start
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the start
     *
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the selection of the start
     *
     * @return the selection
     */
    public String getSelection() {
        return selection;
    }

    /**
     * Sets the selection of the start
     *
     * @param selection the selection to set
     */
    public void setSelection(String selection) {
        this.selection = selection;
    }

    /**
     * Returns the frequency of the start
     *
     * @return the frequency
     */
    public boolean isFrequency() {
        return frequency;
    }

    /**
     * Sets the frequency of the start
     *
     * @param frequency the frequency to set
     */
    public void setFrequency(boolean frequency) {
        this.frequency = frequency;
    }

    /**
     * Returns the estimateDate of the start
     *
     * @return the estimateDate
     */
    public Date getEstimateDate() {
        return estimateDate;
    }

    /**
     * Sets the estimateDate of the start
     *
     * @param estimateDate the estimateDate to set
     */
    public void setEstimateDate(Date estimateDate) {
        this.estimateDate = estimateDate;
    }

    /**
     * Returns the documents of the start
     *
     * @return the documents
     */
    public List<String> getDocuments() {
        return documents;
    }

    /**
     * Sets the documents of the start
     *
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
     *
     * @param uri the document's uri to add
     */
    public void addDocument(String uri) {
        documents.add(uri);
    }

    @Override
    public boolean equals(Object o) {
        Start other = (Start) o;
        return this.getText().equals(other.getText()) && this.getSelection().equals(other.getSelection())
                && this.isFrequency() == other.isFrequency() && this.getEstimateDate().equals(other.getEstimateDate())
                && this.getDocuments().equals(other.getDocuments());
    }
}
