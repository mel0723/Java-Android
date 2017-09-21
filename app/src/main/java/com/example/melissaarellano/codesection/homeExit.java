package com.example.melissaarellano.codesection;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import com.example.melissaarellano.codesection.MainActivity;

/* compiled from: MainActivity */
class homeExit implements OnClickListener {
    final /* synthetic */ MainActivity home;

    homeExit(MainActivity mainActivity) {
        this.home = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.home.finish();
    }
}