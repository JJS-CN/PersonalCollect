package com.example.mbenben.studydemo.basenote.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by MDove on 2017/10/17.
 */

public class LockScreenBroadcastReceiver extends BroadcastReceiver {
    //监听屏幕关闭
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Intent mLockIntent = new Intent(context, LockScreenActivity.class);
            mLockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            context.startActivity(mLockIntent);
        }
    }
}
