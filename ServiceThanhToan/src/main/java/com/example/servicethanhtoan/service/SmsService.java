package com.example.servicethanhtoan.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class SmsService {
    public boolean sendSms(String phoneNumber) {
        boolean status = false;
        try {
            String sms = "'xin chao kien, ma ve cua ban la 18283, khoi hanh luc 8h30'";
            String cmd = "adb shell service call isms 5 i32 1 s16 \"com.android.mms.service\" s16 \"null\" s16 \""+phoneNumber+"\" s16 \"+84980200030\" s16 \""+sms+"\" s16 \"null\" s16 \"null\" s16 \"null\" s16 \"null\"";
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c",cmd);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return status;

    }
}
