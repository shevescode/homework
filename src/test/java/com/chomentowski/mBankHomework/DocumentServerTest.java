package com.chomentowski.mBankHomework;

import com.chomentowski.mBankHomework.server.DocumentServerInterfaceFacade;
import com.chomentowski.mBankHomework.server.DocumentServerInterfaceFacadeImpl;
import org.junit.jupiter.api.Test;
import pl.mbank.exampleRootLibrary.DocumentServer;
import pl.mbank.exampleRootLibrary.FieldDoesNotContainThisValue;
import pl.mbank.exampleRootLibrary.fields.SelectionBoxInterface;

import static org.junit.jupiter.api.Assertions.*;

class DocumentServerTest {

    @Test
    public void ShouldGetSelectionItemBlackWhenSelectionItemBlack() throws FieldDoesNotContainThisValue {
        //given:
        DocumentServer documentServer = new DocumentServer();
        DocumentServerInterfaceFacade documentServerInterface = new DocumentServerInterfaceFacadeImpl(documentServer.getDocumentServerInterface());

        //when:
        SelectionBoxInterface colorSelectionBox = documentServerInterface.createSelectionBox("color");
        colorSelectionBox.addItem("green");
        colorSelectionBox.addItem("red");
        colorSelectionBox.addItem("black");
        colorSelectionBox.setSelectionItem("black");

        //then:
        assertEquals("black", colorSelectionBox.getSelectionItem());
    }
}