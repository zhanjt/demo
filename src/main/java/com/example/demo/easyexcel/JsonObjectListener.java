package com.example.demo.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <功能说明>
 * 通用的excel读取模板监听类
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/4/28  | 修改内容
 */
public class JsonObjectListener extends AnalysisEventListener {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JsonObjectListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<Object> list = new ArrayList<Object>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
//    private Object object;

    public JsonObjectListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
//        object = new Object();
    }

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param object
     */
//    public JsonObjectListener(Object object) {
//        this.object = object;
//    }

    /**
     * 这个每一条数据解析都会来调用
     * 这里就可以对 object 对象进行强转成对应的对象的，因为在read的时候，有传了对应的类 UploadData.class,如下：
     * EasyExcel.read(file.getInputStream(), UploadData.class, new JsonObjectListener()).sheet().doRead();
     * TODO： 这里可以写个策略类，对导入不同的对象进行不同的业务处理，具体处理由具体的策略类实现 或者写在下面的doAfterAllAnalysed方法中
     * @param object
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke( Object object, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(object));
        list.add(object);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

//    protected abstract void dealData();

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
//        uploadDAO.save(list);
        LOGGER.info("存储数据库成功！");
    }
}
