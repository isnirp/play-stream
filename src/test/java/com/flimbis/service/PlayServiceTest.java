package com.flimbis.service;

import com.flimbis.MessageHandler;
import com.flimbis.model.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayServiceTest {

    private PlayService playService;
    @Mock
    private MessageHandler messageHandler;
    @Mock
    private DataOutputStream writer;
    @Mock
    private DataInputStream reader;

    @Test
    void testProcessExitsWhenMsgCapacityFull() throws Exception {
        Player player1 = new Player("player1");
        playService = new ServerService(80, player1, messageHandler);

        when(messageHandler.getCounter()).thenReturn(MessageHandler.MESSAGE_CAP);

        assertThatThrownBy(() -> playService.listenAndBroadcast(writer, reader))
                .isInstanceOf(MessageMaxException.class);
    }
}