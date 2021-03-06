package com.example.demo.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.fastjson.JSON;
import com.example.demo.golbalException.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * <功能说明>
 * excel test
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/4/28  | 修改内容
 */
@RestController
public class EastExcelTest {

    @Autowired
    private UploadDAO uploadDAO;

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DownloadData}
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板")
                .registerWriteHandler(new CustomCellWriteHandler()).doWrite(data());
    }

    /**
     * 文件下载并且失败的时候返回json（默认失败了会返回一个有部分数据的Excel）
     *
     * @since 2.1.1
     */
    @GetMapping("downloadFailedUsingJson")
    public void downloadFailedUsingJson(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), DownloadData.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                    .doWrite(data());
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }
    }

    /**
     * 文件上传，适用于表头只有一行的
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link UploadData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
     * <p>
     * 3. 直接读即可
     */
    @PostMapping("upload")
    @ResponseBody
    public Result upload(MultipartFile file) throws IOException {
//        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
//        EasyExcel.read(file.getInputStream(), UploadData.class, new JsonObjectListener()).sheet().doRead();
//
        //从指定行开始读取 headRowNumber(2)
//        EasyExcel.read(file.getInputStream(), UploadData.class, new JsonObjectListener()).sheet().headRowNumber(2).doRead();
        String filename = file.getOriginalFilename();
        if (StringUtils.isBlank(filename) || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
            return Result.error("500", "excel格式错误");
        }
        ExcelListener excelListener = new ExcelListener();
        EasyExcel.read(file.getInputStream(), UploadData.class, excelListener).sheet("模板").headRowNumber(1).doRead();
        List<Object> list =  excelListener.getList();
        return Result.success(list);
    }


    private List<DownloadData> data() {
        List<DownloadData> list = new ArrayList<DownloadData>();
        for (int i = 0; i < 10; i++) {
            DownloadData data = new DownloadData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56 + i);
            list.add(data);
        }
        return list;
    }

}
