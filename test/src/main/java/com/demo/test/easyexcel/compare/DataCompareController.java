package com.demo.test.easyexcel.compare;

import com.demo.test.easyexcel.util.TestFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 数据对比Controller
 * 提供Excel数据对比的HTTP接口
 *
 * @author demo
 */
@Slf4j
@RestController
@RequestMapping("/api/compare")
public class DataCompareController {

    /**
     * 上传Excel文件并进行数据对比
     * 
     * @param file 上传的Excel文件（单sheet，两列数据）
     * @return 处理结果
     */
    @PostMapping("/upload")
    public Map<String, Object> uploadAndCompare(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 验证文件
            if (file == null || file.isEmpty()) {
                result.put("success", false);
                result.put("message", "文件不能为空");
                return result;
            }

            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null
                    || (!originalFilename.endsWith(".xlsx") && !originalFilename.endsWith(".xls"))) {
                result.put("success", false);
                result.put("message", "文件格式不正确，请上传Excel文件（.xlsx或.xls）");
                return result;
            }

            // 保存上传的文件到临时目录
            String tempDir = TestFileUtil.getPath() + File.separator + "easyexcel" + File.separator + "compare"
                    + File.separator + "temp";
            File tempDirFile = new File(tempDir);
            if (!tempDirFile.exists()) {
                tempDirFile.mkdirs();
            }

            String inputFileName = UUID.randomUUID().toString() + "_" + originalFilename;
            File inputFile = new File(tempDir, inputFileName);
            file.transferTo(inputFile);

            // 生成输出文件路径
            String outputFileName = "compare_result_" + UUID.randomUUID().toString() + ".xlsx";
            String outputPath = tempDir + File.separator + outputFileName;

            // 执行数据对比
            DataCompareUtil.compareData(inputFile.getAbsolutePath(), outputPath);

            // 返回结果
            result.put("success", true);
            result.put("message", "数据对比完成");
            result.put("outputFileName", outputFileName);
            result.put("downloadUrl", "/api/compare/download?fileName=" + URLEncoder.encode(outputFileName, "UTF-8"));

            // 清理输入文件
            if (inputFile.exists()) {
                inputFile.delete();
            }

        } catch (Exception e) {
            log.error("数据对比失败", e);
            result.put("success", false);
            result.put("message", "数据对比失败：" + e.getMessage());
        }

        return result;
    }

    /**
     * 下载对比结果文件
     * 
     * @param fileName 文件名
     * @param response HTTP响应
     */
    @GetMapping("/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        try {
            String tempDir = TestFileUtil.getPath() + File.separator + "easyexcel" + File.separator + "compare"
                    + File.separator + "temp";
            File file = new File(tempDir, fileName);

            if (!file.exists()) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().println("{\"error\":\"文件不存在\"}");
                return;
            }

            // 设置响应头
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + encodedFileName);

            // 读取文件并写入响应
            java.nio.file.Files.copy(file.toPath(), response.getOutputStream());
            response.getOutputStream().flush();

            // 下载后删除临时文件
            file.delete();

        } catch (IOException e) {
            log.error("下载文件失败", e);
            try {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().println("{\"error\":\"下载文件失败：" + e.getMessage() + "\"}");
            } catch (IOException ex) {
                log.error("写入错误响应失败", ex);
            }
        }
    }

    /**
     * 直接对比并下载结果（一步完成）
     * 
     * @param file     上传的Excel文件
     * @param response HTTP响应
     */
    @PostMapping("/compareAndDownload")
    public void compareAndDownload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        try {
            // 验证文件
            if (file == null || file.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().println("{\"error\":\"文件不能为空\"}");
                return;
            }

            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null
                    || (!originalFilename.endsWith(".xlsx") && !originalFilename.endsWith(".xls"))) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().println("{\"error\":\"文件格式不正确，请上传Excel文件（.xlsx或.xls）\"}");
                return;
            }

            // 保存上传的文件到临时目录
            String tempDir = TestFileUtil.getPath() + File.separator + "easyexcel" + File.separator + "compare"
                    + File.separator + "temp";
            File tempDirFile = new File(tempDir);
            if (!tempDirFile.exists()) {
                tempDirFile.mkdirs();
            }

            String inputFileName = UUID.randomUUID().toString() + "_" + originalFilename;
            File inputFile = new File(tempDir, inputFileName);
            file.transferTo(inputFile);

            // 生成输出文件路径
            String outputFileName = "compare_result_" + UUID.randomUUID().toString() + ".xlsx";
            String outputPath = tempDir + File.separator + outputFileName;

            // 执行数据对比
            DataCompareUtil.compareData(inputFile.getAbsolutePath(), outputPath);

            // 清理输入文件
            if (inputFile.exists()) {
                inputFile.delete();
            }

            // 设置响应头
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            String encodedFileName = URLEncoder.encode("对比结果.xlsx", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + encodedFileName);

            // 读取文件并写入响应
            File outputFile = new File(outputPath);
            java.nio.file.Files.copy(outputFile.toPath(), response.getOutputStream());
            response.getOutputStream().flush();

            // 下载后删除临时文件
            outputFile.delete();

        } catch (Exception e) {
            log.error("数据对比并下载失败", e);
            try {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().println("{\"error\":\"处理失败：" + e.getMessage() + "\"}");
            } catch (IOException ex) {
                log.error("写入错误响应失败", ex);
            }
        }
    }
}
