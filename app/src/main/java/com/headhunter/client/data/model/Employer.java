
package com.headhunter.client.data.model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Embedded;

public class Employer {

    @SerializedName("id")
    @Expose
    private String ids;
    @SerializedName("name")
    @Expose
    private String _name;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

}
