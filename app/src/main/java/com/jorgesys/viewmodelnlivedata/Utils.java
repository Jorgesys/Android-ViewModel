package com.jorgesys.viewmodelnlivedata;

import android.content.Context;
import android.content.res.Resources;

public class Utils {

    public static User getRandomUser(Context ctx){

        Resources res = ctx.getResources();
        String[] users = res.getStringArray(R.array.users_array);
        String[] lastNames = res.getStringArray(R.array.lastname_array);
        int random = (int)(Math.random() * users.length-1 + 0);
        int random2 = (int)(Math.random() * users.length-1 + 0);
        int randomAge = (int)(Math.random() * 50-1 + 18);//Ages from 18 to 50.
        User user = new User(randomAge, users[random], lastNames[random2]);

        return user;

    }


}
