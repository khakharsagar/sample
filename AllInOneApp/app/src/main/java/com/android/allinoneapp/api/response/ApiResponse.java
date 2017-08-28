
package com.android.allinoneapp.api.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    public String guid;
    public Integer index;
    public String favoriteFruit;
    public Float latitude;
    public String company;
    public String email;
    public String picture;
    public List<String> tags = null;
    public String registered;
    public String eyeColor;
    public String phone;
    public String address;
    public List<Friend> friends = null;
    public Boolean isActive;
    public String about;
    public String balance;
    public String name;
    public String gender;
    public Integer age;
    public String greeting;
    public Float longitude;
    public String id;
}