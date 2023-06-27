package com.demo.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@SpringBootTest
@RunWith(SpringRunner.class)
class TestEportTestController {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void b() {
        try {

            ResultActions perform = mockMvc.perform(
                    MockMvcRequestBuilders.get("/testCsv")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(new ResultHandler() {
                @Override
                public void handle(MvcResult result) throws Exception {
                    result.getResponse().setCharacterEncoding("UTF-8");
                    MockHttpServletResponse contentRespon = result.getResponse();
                    String fileName = "DealerFinanceInfo" + ".zip";
                    String filePath = "test-" + fileName;
                    File file = new File(filePath);
                    OutputStream out = new FileOutputStream(file);
                    out.write(contentRespon.getContentAsByteArray());
                    out.close();
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void c(){
        char[][] board={

                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'} ,
                {'.','9','8','.','.','.','.','6','.'} ,
                {'8','.','.','.','6','.','.','.','3'} ,
                {'4','.','.','8','.','3','.','.','1'} ,
                {'7','.','.','.','2','.','.','.','6'} ,
                {'.','6','.','.','.','.','2','8','.'} ,
                {'.','.','.','4','1','9','.','.','5'} ,
                {'.','.','.','.','8','.','.','7','9'}};
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] block = new boolean[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        int blockIndex = i / 3 * 3 + j / 3;
                        System.out.println("i="+i+";j="+j+";blockIndex="+blockIndex);
                        if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                            System.out.println("false");
                        } else {
                            row[i][num] = true;
                            col[j][num] = true;
                            block[blockIndex][num] = true;
                        }
                    }
                }
            }
        System.out.println("true");
    }
}