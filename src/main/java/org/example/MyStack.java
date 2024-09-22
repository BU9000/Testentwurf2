package org.example;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack {
    // Der Stack wird durch einen Vektor mit einer maximalen Kapazität von 5 repräsentiert
    private Vector<Integer> stack;
    private static final int CAPACITY = 5;

    // Konstruktor: Erstellt einen leeren Stack
    public MyStack() {
        stack = new Vector<>(CAPACITY);
    }

    // Legt ein neues Element auf den Stack, wenn er nicht voll ist
    public void push(int x) {
        // Negative Werte sind nicht erlaubt
        if (x < 0) {
            throw new IllegalArgumentException("Negative Werte sind nicht erlaubt");
        }
        // Prüfen, ob der Stack voll ist
        if (stack.size() >= CAPACITY) {
            throw new IndexOutOfBoundsException("Stack ist voll");
        }
        // Element hinzufügen
        stack.add(x);
    }

    // Entfernt und gibt das oberste Element zurück, wenn der Stack nicht leer ist
    public int pop() {
        // Prüfen, ob der Stack leer ist
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        // Oberstes Element entfernen und zurückgeben
        return stack.remove(stack.size() - 1);
    }

    // Gibt true zurück, wenn der Stack leer ist
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Gibt true zurück, wenn der Stack voll ist
    public boolean isFull() {
        return stack.size() == CAPACITY;
    }

    // Gibt das oberste Element zurück, ohne es zu entfernen
    public int top() {
        // Prüfen, ob der Stack leer ist
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.lastElement();
    }

    // Gibt die aktuelle Größe des Stacks zurück
    public int size() {
        return stack.size();
    }
}
