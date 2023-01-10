package com.demo.test.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class IoTestTest {

    @Test
    void outputStream() throws IOException {
        new IoTest().outputStream();
    }

    @Test
    void inputStream() throws IOException {
        new IoTest().inputStream();
    }
}