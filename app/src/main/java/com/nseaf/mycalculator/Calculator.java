package com.nseaf.mycalculator;

public class Calculator {
    String numberString="0";
    String detailsString="";
    long intNumber;
    double realNumber;
    boolean isIntNumber=true;
    boolean numHasRadixPoint=false;
    long memoryInt=0;
    double memoryDouble=0.0;
    boolean isIntMemory=true;

    public Calculator() {
    }

    public void processNumber(int i) {
        if(numberString.length()<12) {  // limit of 12 digits
            intNumber = intNumber * 10 + i;
            numberString = String.valueOf(intNumber);
            detailsString = "Clicked: "+i;
        }
        else
            detailsString="The number is too long..";
    }

    public void clearClicked() {
        numberString="0";
        detailsString="";
        intNumber=0;
        realNumber=0.0;
        isIntNumber=true;
        numHasRadixPoint=false;
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
}
