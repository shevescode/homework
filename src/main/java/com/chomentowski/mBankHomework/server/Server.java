package com.chomentowski.mBankHomework.server;

import com.chomentowski.mBankHomework.mBankHomework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbank.exampleRootLibrary.DocumentServer;
import pl.mbank.exampleRootLibrary.FieldDoesNotContainThisValue;
import pl.mbank.exampleRootLibrary.fields.ControlInterface;
import pl.mbank.exampleRootLibrary.fields.SelectionBoxInterface;
import pl.mbank.exampleRootLibrary.fields.TextFieldInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private static final Logger logger = LoggerFactory.getLogger(mBankHomework.class);
    private final ProxyDocumentServerInterface documentServerInterface;
    private final List<ControlInterface> fieldsList = new ArrayList<>();

    public Server() {
        DocumentServer documentServer = new DocumentServer();
        documentServerInterface = new ProxyDocumentServerInterfaceImpl(documentServer.getDocumentServerInterface());
    }

    public void init() {
        TextFieldInterface nameTextField = documentServerInterface.createTextField("name");
        TextFieldInterface surNameTextField = documentServerInterface.createTextField("surName");
        SelectionBoxInterface colorSelectionBox = documentServerInterface.createSelectionBox("color");
        SelectionBoxInterface countrySelectionBox = documentServerInterface.createSelectionBox("country");

        nameTextField.setValue("Kamil");
        surNameTextField.setValue("Kudynowski");

        addItemsToSelectionBox(colorSelectionBox,"green", "red", "black");
        addItemsToSelectionBox(countrySelectionBox,"Afghanistan", "Pakistan", "Turkmenistan");

        selectItemFromSelectionBox(countrySelectionBox,"Afghanistan");
        selectItemFromSelectionBox(colorSelectionBox,"black");

        addFieldsToList(nameTextField, surNameTextField, colorSelectionBox, countrySelectionBox);
        setFieldsAsReadOnly();
    }

    private void setFieldsAsReadOnly() {
        fieldsList.forEach(e -> e.setReadOnly(true));
    }

    private void addFieldsToList(ControlInterface... fields) {
        fieldsList.addAll(Arrays.asList(fields));
    }

    private void selectItemFromSelectionBox(SelectionBoxInterface selectionBox, String value) {
        try {
            selectionBox.setSelectionItem(value);
        } catch (FieldDoesNotContainThisValue e) {
            logger.error(e.getMessage());
        }
    }

    private void addItemsToSelectionBox(SelectionBoxInterface selectionBox, String... arguments) {
        for (String argument: arguments) {
            selectionBox.addItem(argument);
        }
    }
}
