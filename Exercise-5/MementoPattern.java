package exercise5;

import java.util.*;

// memento
class TextEditorMemento {
    private String text;
    
    public TextEditorMemento(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
}

// Originator
class TextEditor {
    private String text;
    
    public TextEditor(String text) {
        this.text = text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public TextEditorMemento save() {
        return new TextEditorMemento(text);
    }
    
    public void restore(TextEditorMemento memento) {
        text = memento.getText();
    }
    
    public String getText() {
        return text;
    }
}

// caretaker
class TextEditorHistory {
    private List<TextEditorMemento> history = new ArrayList<>();
    
    public void save(TextEditorMemento memento) {
        history.add(memento);
    }
    
    public TextEditorMemento getLastSavedState() {
        if (history.size() > 0) {
            return history.remove(history.size() - 1);
        } else {
            return null;
        }
    }
}

public class MementoPattern {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor("Hi, This is Gokul");
        TextEditorHistory history = new TextEditorHistory();
        editor.setText("I am working in Sirius Computer Solutions");
        history.save(editor.save());
        editor.setText("Currently staying in Chennai");
        history.save(editor.save());
        editor.restore(history.getLastSavedState());
        System.out.println(editor.getText()); 
    }
}
