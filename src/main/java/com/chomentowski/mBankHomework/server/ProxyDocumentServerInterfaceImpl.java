package com.chomentowski.mBankHomework.server;

import pl.mbank.exampleRootLibrary.DocumentServerInterface;
import pl.mbank.exampleRootLibrary.fields.SelectionBoxInterface;
import pl.mbank.exampleRootLibrary.fields.TextFieldInterface;

public class ProxyDocumentServerInterfaceImpl implements ProxyDocumentServerInterface {
    private final DocumentServerInterface documentServerInterface;

    public ProxyDocumentServerInterfaceImpl(DocumentServerInterface documentServerInterface) {
        this.documentServerInterface = documentServerInterface;
    }

    @Override
    public TextFieldInterface createTextField(String name) {
        documentServerInterface.createNewTextField(name);
        return documentServerInterface.getTextFieldInterByName(name);
    }

    @Override
    public SelectionBoxInterface createSelectionBox(String name) {
        documentServerInterface.createNewSelectionBox(name);
        return documentServerInterface.getSelectionBoxByName(name);
    }
}
