package com.chomentowski.mBankHomework.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbank.exampleRootLibrary.FieldDoesNotContainThisValue;
import pl.mbank.exampleRootLibrary.fields.SelectionBoxInterface;

import java.util.List;

public class ExtendedSelectionBoxInterface implements SelectionBoxInterface {
    private final SelectionBoxInterface selectionBoxInterface;
    private static final Logger logger = LoggerFactory.getLogger(ExtendedSelectionBoxInterface.class);

    public ExtendedSelectionBoxInterface(SelectionBoxInterface selectionBoxInterface) {
        this.selectionBoxInterface = selectionBoxInterface;
    }

    public void selectItem(String value) {
        try {
            setSelectionItem(value);
        } catch (FieldDoesNotContainThisValue e) {
            logger.error(e.getMessage());
        }
    }

    public void addItems(String... arguments) {
        for (String argument : arguments) {
            addItem(argument);
        }
    }

    @Override
    public void addItem(String s) {
        selectionBoxInterface.addItem(s);
    }

    @Override
    public void setItemList(List<String> list) {
        selectionBoxInterface.setItemList(list);
    }

    @Override
    public void setSelectionItem(String s) throws FieldDoesNotContainThisValue {
        selectionBoxInterface.setSelectionItem(s);
    }

    @Override
    public List<String> getItemList() {
        return selectionBoxInterface.getItemList();
    }

    @Override
    public String getSelectionItem() {
        return selectionBoxInterface.getSelectionItem();
    }

    @Override
    public void setReadOnly(Boolean aBoolean) {
        selectionBoxInterface.setReadOnly(aBoolean);
    }

    @Override
    public Boolean getReadOnly() {
        return selectionBoxInterface.getReadOnly();
    }

    @Override
    public String getNameData() {
        return selectionBoxInterface.getNameData();
    }
}
