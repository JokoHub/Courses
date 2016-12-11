package com.joko.IBA.JUnitTests;

import com.joko.IBA.GUIExample.ChatClient;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Joko on 11.12.2016.
 */
public class ChatClientTest {

    ChatClient chatClient = new ChatClient();


    @Before
    public void beforeTest() {
        System.out.println("testing before performing");
        assertTrue(chatClient != null);
    }

    @After
    public void afterTest(){
        System.out.println("testing after performing");
        assertTrue(chatClient.getQuitButton().getActionListeners().length < 2);
    }

    @Test
    public void checkInsides(){
        assertEquals(chatClient.getUsernames().getItemCount(), 3);
    }

    @Test
    public void checkFrame(){
        chatClient.launchFrame();
        int a = chatClient.getSendButton().getActionListeners().length;
        a = a / 0;
    }

}