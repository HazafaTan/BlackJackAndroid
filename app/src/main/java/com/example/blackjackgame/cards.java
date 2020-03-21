package com.example.blackjackgame;

import android.widget.ImageView;

public class cards {
    String strSymbol; // String that will hold the symbol of the card
    String strValue; // string that will hold the value of the card
    int intNum; // Integer that will be assigned to each card that will be used for the image

    /**
     *
     * @param strValue // String that will hold the value of the card
     * @param strSymbol   string that will hold the value of the card
     * @param intNum Integer that will be assigned to each card that will be used for the image
     */
    public cards (String strValue, String strSymbol, int intNum){
        this.strSymbol = strSymbol;
        this.strValue = strValue;
        this.intNum = intNum;
    }

 //getter and setter methods for each variable
    public String getSymbol() {

        return strSymbol;
}

    public String getValue() {

        return strValue;
    }
    public int getIntNum() {
        return intNum;
    }

    public void setIntNum(int intNum) {
        this.intNum = intNum;
    }


}
