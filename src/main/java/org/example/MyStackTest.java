package org.example;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

public class MyStackTest {

    // 1. Test: pop() bei leerem Stack (sollte EmptyStackException werfen)
    @Test
    public void testPopEmptyStack() {
        MyStack stack = new MyStack();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    // 2. Test: push() auf einem leeren Stack
    @Test
    public void testPushToEmptyStack() {
        MyStack stack = new MyStack();
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.top());
    }

    // 3. Test: pop() bei einem Stack mit einem Element
    @Test
    public void testPopOneElementStack() {
        MyStack stack = new MyStack();
        stack.push(10);
        int element = stack.pop();
        assertEquals(10, element);
        assertTrue(stack.isEmpty());
    }

    // 4. Test: pop() bei einem Stack mit mehr als einem Element
    @Test
    public void testPopMultipleElementsStack() {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        int element = stack.pop();
        assertEquals(20, element);
        assertEquals(1, stack.size());
        assertEquals(10, stack.top());
    }

    // 5. Test: push() bei einem Stack mit weniger als 4 Elementen
    @Test
    public void testPushToStackLessThanFour() {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
    }

    // 6. Test: push() bei einem Stack mit 4 Elementen
    @Test
    public void testPushToStackWithFourElements() {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        assertEquals(4, stack.size());
        stack.push(50);
        assertEquals(5, stack.size());
        assertTrue(stack.isFull());
    }

    // 7. Test: push() bei einem vollen Stack (sollte IndexOutOfBoundsException werfen)
    @Test
    public void testPushFullStack() {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        // Dies sollte eine Ausnahme werfen
        assertThrows(IndexOutOfBoundsException.class, () -> stack.push(60));
    }

    // 8. Test: pop() bei einem vollen Stack
    @Test
    public void testPopFullStack() {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        assertTrue(stack.isFull());
        int element = stack.pop();
        assertEquals(50, element);
        assertEquals(4, stack.size());
        assertFalse(stack.isFull());
    }
}