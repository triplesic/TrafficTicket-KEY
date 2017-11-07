package com.coaching.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TrafficTicketTest {

    //SUT
    ITicketSystem trafficTicket;

    @Before
    public void setup(){
        trafficTicket = new TrafficTicketSystem();
    }

    @Test
    public void shouldReturnNoTicketIfSpeedNotMoreThan(){
        double speed = 80;
        boolean isHoliday = false;
        boolean isRushHour = false;
        String compensation = trafficTicket.shouldCompensate(speed, isHoliday, isRushHour);
        assertEquals("ไม่เสียค่าปรับ", compensation);
    }

    @Test
    public void shouldReturnTicketIfSpeedMoreThan80KMH(){
        double speed = 81;
        boolean isHoliday = false;
        boolean isRushHour = false;
        String compensation = trafficTicket.shouldCompensate(speed, isHoliday, isRushHour);
        assertEquals("เสียค่าปรับ 300 บาท", compensation);
    }

    @Test
    public void shouldReturnTicketIfSpeedMoreThan100KMH() {
        double speed = 100.01;
        boolean isHoliday = false;
        boolean isRushHour = false;
        String compensation = trafficTicket.shouldCompensate(speed, isHoliday, isRushHour);
        assertEquals("เสียค่าปรับ 500 บาท", compensation);
    }

    @Test
    public void shouldReturnTicketPlus15PercenIfSpeedMoreThan80KMH(){
        double speed = 81;
        boolean isHoliday = true;
        boolean isRushHour = false;
        String compensation = trafficTicket.shouldCompensate(speed, isHoliday, isRushHour);
        assertEquals("เสียค่าปรับ 345 บาท", compensation);
    }

    @Test
    public void shouldReturnTicketPlus15PercenIfSpeedMoreThan100KMH(){
        double speed = 109;
        boolean isHoliday = true;
        boolean isRushHour = false;
        String compensation = trafficTicket.shouldCompensate(speed, isHoliday, isRushHour);
        assertEquals("เสียค่าปรับ 575 บาท", compensation);
    }

    @Test
    public void shouldReturnTicketInRushHourIfSpeedMoreThan80KMH(){
        double speed = 81;
        boolean isHoliday = false;
        boolean isRushHour = true;
        String compensation = trafficTicket.shouldCompensate(speed, isHoliday, isRushHour);
        assertEquals("ไม่เสียค่าปรับ", compensation);
    }

    @Test
    public void shouldReturnTicketInRushHourIfSpeedMoreThan100KMH(){
        double speed = 101;
        boolean isHoliday = false;
        boolean isRushHour = true;
        String compensation = trafficTicket.shouldCompensate(speed, isHoliday, isRushHour);
        assertEquals("เสียค่าปรับ 300 บาท", compensation);
    }
}
