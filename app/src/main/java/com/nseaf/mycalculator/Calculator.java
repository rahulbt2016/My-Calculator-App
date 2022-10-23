package com.nseaf.mycalculator;

public class Calculator {
    String numberString;
    String detailsString;
    long intNumber;
    long intNumber2;
    double realNumber;
    double realNumber2;
    boolean isIntNumber;
    boolean isIntNumber2;
    boolean numHasRadixPoint;
    long memoryInt;
    double memoryDouble;
    boolean isIntMemory;
    String operation;
    boolean isFirstOperation;

    public Calculator() {
        this.numberString = "0";
        this.detailsString = "";
        this.isIntNumber = true;
        this.isIntNumber2 = true;
        this.isIntMemory = true;
        this.numHasRadixPoint = false;
        this.intNumber = 0;
        this.intNumber2 = 0;
        this.realNumber = 0.0;
        this.realNumber2 = 0.0;
        this.operation = "";
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
        numberString="0";
        detailsString="";
        intNumber=0;
        realNumber=0.0;
        intNumber2 = 0;
        realNumber2 = 0.0;
        operation = "";
        isIntNumber=true;
        isIntNumber2=true;
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
        operationClicked();
        operation = "/";
        detailsString = "Operation: ÷";
    }

    public void mulClicked() {
        operationClicked();
        operation = "*";
        detailsString = "Operation: ×";
    }

    public void minClicked() {
        operationClicked();
        operation = "-";
        detailsString = "Operation: -";
    }

    public void plusClicked() {
        operationClicked();
        operation = "+";
        detailsString = "Operation: +";
    }

    public void equalClicked() {
        if (!operation.equalsIgnoreCase("")) {

            if (operation.equalsIgnoreCase("+")) {
                if (isIntNumber && isIntNumber2) {
                    intNumber += intNumber2;
                    isIntNumber = true;
                }
                else if (!isIntNumber && !isIntNumber2){
                    realNumber += realNumber2;
                    isIntNumber = false;
                }
                else if (!isIntNumber && isIntNumber2) {
                    realNumber += intNumber2;
                    isIntNumber = false;
                }
                else if (isIntNumber && !isIntNumber2) {
                    realNumber = intNumber + realNumber2;
                    isIntNumber = false;
                }

                if (!isIntNumber) {
                    if (realNumber % 1 == 0.0) {
                        intNumber = (int) realNumber;
                        isIntNumber = true;

                    }
                }

                numberString = isIntNumber ?  String.valueOf(intNumber) : String.valueOf(realNumber);
            }

            else if (operation.equalsIgnoreCase("-")) {

            }

            else if (operation.equalsIgnoreCase("*")) {

            }

            else if (operation.equalsIgnoreCase("/")) {

            }
        }

        //Erasing operand 2, once the operation is done
        isIntNumber2 = true;
        intNumber2 = 0;
        realNumber2 = 0.0;

        detailsString = "Answer";
        operation = "";
        isFirstOperation = true;
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

    //For any operation, shifting the value of the operand 1 to operand 2,
    //we can record new number as operand 1
    private void operationClicked() {
        if (isFirstOperation) {
            isFirstOperation = false;
            if(isIntNumber) {
                intNumber2 = intNumber;
                isIntNumber2 = true;
                intNumber = 0;
            }
            else {
                realNumber2 = realNumber;
                isIntNumber2 = false;
                intNumber = 0;
                isIntNumber = true;
            }

        }

        else {
            equalClicked();
            operationClicked();
        }

        numHasRadixPoint = false;
        numberString = "0";
    }
}
