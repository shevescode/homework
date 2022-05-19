package com.chomentowski.mBankHomework;

import com.chomentowski.mBankHomework.server.ProxyDocumentServerInterface;
import com.chomentowski.mBankHomework.server.ProxyDocumentServerInterfaceImpl;
import org.junit.jupiter.api.Test;
import pl.mbank.exampleRootLibrary.DocumentServer;
import pl.mbank.exampleRootLibrary.FieldDoesNotContainThisValue;
import pl.mbank.exampleRootLibrary.fields.SelectionBoxInterface;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @Test
    public void Should_GetSelectionItemBlackWhenSelectionItemBlack() throws FieldDoesNotContainThisValue {
        //given
        DocumentServer documentServer = new DocumentServer();
        ProxyDocumentServerInterface documentServerInterface = new ProxyDocumentServerInterfaceImpl(documentServer.getDocumentServerInterface());
        //when
        SelectionBoxInterface colorSelectionBox = documentServerInterface.createSelectionBox("color");
        colorSelectionBox.addItem("green");
        colorSelectionBox.addItem("red");
        colorSelectionBox.addItem("black");
        colorSelectionBox.setSelectionItem("black");
        //then
        assertEquals("black", colorSelectionBox.getSelectionItem());
    }
}