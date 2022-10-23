package com.nseaf.mycalculator;

public class Calculator {
    String numberString;
    String detailsString;
    long intNumber;
    double realNumber;
    boolean isIntNumber;
    boolean numHasRadixPoint;
    long memoryInt;
    double memoryDouble;
    boolean isIntMemory;

    public Calculator() {
        this.numberString = "0";
        this.detailsString = "";
        this.isIntNumber = true;
        this.isIntMemory = true;
        this.numHasRadixPoint = false;
        this.memoryInt = 0;
        this.memoryDouble = 0.0;
    }

    public void processNumber(int i) {

        if(numberString.length()<12) {  // limit of 12 digits

            if (isIntNumber) {

                intNumber = intNumber * 10 + i;
                numberString = String.valueOf(intNumber);

            }
            else {
                numberString += i;
                realNumber = Double.parseDouble(numberString);
            }
            detailsString = "Clicked: "+i;
        }
        else
            detailsString="The number is too long..";
    }

    public void clearClicked() {
        if (numberString == "0" && detailsString == "") {

            intNumber=0;
            realNumber=0.0;
            isIntNumber=true;
            numHasRadixPoint=false;
        }
        else {
            numberString="0";
            detailsString="";
        }
    }

    public void memPlusClicked() {
        if(isIntMemory){
            if(isIntNumber) {
                memoryInt += intNumber;
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt + realNumber;
            }
        }
    }

    public void memRecallClicked() {
        detailsString = "Memory Recall clicked";
        if (isIntMemory) {
            numberString = Long.toString(memoryInt);
        }
        else {
            numberString = Double.toString(memoryDouble);
        }
    }

    public void memMinusClicked() {

        if(isIntMemory){
            if(isIntNumber) {
                memoryInt -= intNumber;
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt - realNumber;
            }
        }
    }

    public void memClearClicked() {
    }

    public void expClicked() {
    }

    public void piClicked() {
    }

    public void divClicked() {
    }

    public void mulClicked() {
    }

    public void minClicked() {
    }

    public void plusClicked() {
    }

    public void equalClicked() {
    }

    public void radicalPointClicked() {
        if(!numHasRadixPoint) {
            numberString += ".";
            detailsString = "Clicked: .";
            numHasRadixPoint = true;
            isIntNumber = false;
            realNumber = (float) intNumber;
            intNumber = 0;
        }
    }
}
