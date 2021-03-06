
package com.headhunter.client.data.model.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Salary {

    @SerializedName("from")
    @Expose
    private int from;
    @SerializedName("to")
    @Expose
    private int to;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("gross")
    @Expose
    private boolean gross;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isGross() {
        return gross;
    }

    public void setGross(boolean gross) {
        this.gross = gross;
    }

    private String getSignMoney() {
        if (getCurrency().equals("USD"))
            return "$";
        else
            return "₽";
    }

    public String getExpectedSalary() {
        if (getTo() == 0) {
            return "от " + getFrom() + " " + getSignMoney() + " на руки";
        } else if (getFrom() == 0) {
            return "до " + getTo() + " " + getSignMoney() + " на руки";
        } else {
            return getFrom() + " - " + getTo() + " " + getSignMoney() + " на руки";
        }
    }

}
