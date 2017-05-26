package com.example.shoo.gptrial2;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;

public class LoadDataService extends Service {
    public LoadDataService() {
    }
BluetoothAdapter bluetoothAdapter;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }
}
