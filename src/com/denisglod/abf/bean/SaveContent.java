package com.denisglod.abf.bean;

import java.io.Serializable;

public class SaveContent implements Serializable {

    private String console;
    private String numberOfVertices;
    private String vertexNames;
    private String weightOfEdges;

    public SaveContent() {
        //NO-OP
    }

    public SaveContent(String console, String numberOfVertices, String vertexNames, String weightOfEdges) {
        this.console = console;
        this.numberOfVertices = numberOfVertices;
        this.vertexNames = vertexNames;
        this.weightOfEdges = weightOfEdges;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(String numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public String getVertexNames() {
        return vertexNames;
    }

    public void setVertexNames(String vertexNames) {
        this.vertexNames = vertexNames;
    }

    public String getWeightOfEdges() {
        return weightOfEdges;
    }

    public void setWeightOfEdges(String weightOfEdges) {
        this.weightOfEdges = weightOfEdges;
    }
}
