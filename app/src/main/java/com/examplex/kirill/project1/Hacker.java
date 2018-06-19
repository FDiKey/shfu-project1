package com.examplex.kirill.project1;

import android.widget.ImageView;

/**
 * Created by kirill on 17/06/2018.
 */

public class Hacker
{
    String nickname;
    Integer ava;

    public Hacker(String nickname, Integer ava) {
        this.nickname = nickname;
        this.ava = ava;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAva() {
        return ava;
    }

    public void setAva(Integer ava) {
        this.ava = ava;
    }
}
