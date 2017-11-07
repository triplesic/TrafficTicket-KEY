package com.coaching.tdd;

public class TrafficTicketSystem implements ITicketSystem {

//    public String shouldCompensate(double speed, boolean isHoliday) {
//
//        if(isHoliday)
//        {
//            if (speed > 80 && speed <= 100)
//                return "เสียค่าปรับ 345 บาท";
//            else if (speed > 100)
//                return "เสียค่าปรับ 575 บาท";
//        }else{
//            if (speed > 80 && speed <= 100)
//                return "เสียค่าปรับ 300 บาท";
//            else if (speed > 100)
//                return "เสียค่าปรับ 500 บาท";
//        }
//        return "ไม่เสียค่าปรับ";
//    }

    public String shouldCompensate(double speed, boolean isHoliday, boolean isRushHour) {

        double rate = isHoliday ? 1.15 : 1.0;

        if(isRushHour){
            speed = speed - 10;
        }

        if (speed > 80 && speed <= 100)
            return "เสียค่าปรับ " + (int)(300 * rate) + " บาท";
        else if (speed > 100)
            return "เสียค่าปรับ " + (int)(500 * rate) + " บาท";
        return "ไม่เสียค่าปรับ";
    }


}
