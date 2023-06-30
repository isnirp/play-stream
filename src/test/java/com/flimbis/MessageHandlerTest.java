package com.flimbis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessageHandlerTest {

    @Test
    void testMsgAppendsMsgCounter() {
        MessageHandler messageHandler = new MessageHandler();

        messageHandler.keepCount();
        messageHandler.setMessage(MessageHandler.MESSAGE_INIT);

        String actual = MessageHandler.MESSAGE_INIT + "-" + messageHandler.getCounter();
        assertThat(messageHandler.getMessage()).isEqualTo(actual);
    }
}