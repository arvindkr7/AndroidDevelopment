package com.example.myelin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;



// CLI
// >adb shell cat /proc/cpuinfo

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("CPU_INFO", String.valueOf(CpuInfo.getCpuUsage()));

    }

    public static String getCPUDetails(){

        /*
         *Created By Atiar Talukdar
         * 01/01/2018
         * contact@atiar.info
         */

        ProcessBuilder processBuilder;
        String cpuDetails = "";
        String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
        InputStream is;
        Process process ;
        byte[] bArray ;
        bArray = new byte[1024];

        try{
            processBuilder = new ProcessBuilder(DATA);

            process = processBuilder.start();

            is = process.getInputStream();

            while(is.read(bArray) != -1){
                cpuDetails = cpuDetails + new String(bArray);   //Stroing all the details in cpuDetails
            }
            is.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }

        return cpuDetails;
    }
}